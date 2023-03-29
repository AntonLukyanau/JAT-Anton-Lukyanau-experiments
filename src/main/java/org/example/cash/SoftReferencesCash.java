package org.example.cash;

import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

class SoftReferencesCash<K, T> implements MultiValueCash<K, T> {

    private final Map<K, Set<SoftReference<T>>> memory = new ConcurrentHashMap<>();

    @Override
    public void store(K key, T value) {
        if (key != null && value != null) {
            expungesCollectedGCEntries();
            if (isNotInCash(key, value)) {
                SoftReference<T> reference = new SoftReference<>(value);
                Set<SoftReference<T>> values = memory.computeIfAbsent(key, k -> new CopyOnWriteArraySet<>());
                values.add(reference);
                memory.put(key, values);
            }

        }
    }

    private boolean isNotInCash(K key, T value) {
        Set<SoftReference<T>> references = memory.computeIfAbsent(key, k -> new CopyOnWriteArraySet<>());
        return references.stream()
                .noneMatch(reference -> reference.refersTo(value));
    }

    @Override
    public void storeAll(K key, Iterable<T> values) {
        if (key != null && values != null) {
            expungesCollectedGCEntries();
            Set<SoftReference<T>> references = StreamSupport.stream(values.spliterator(), false)
                    .filter(Objects::nonNull)
                    .filter(value -> isNotInCash(key, value))
                    .map(SoftReference::new)
                    .collect(Collectors.toSet());
            Set<SoftReference<T>> oldValues = memory.computeIfAbsent(key, k -> new CopyOnWriteArraySet<>());
            oldValues.addAll(references);
            memory.put(key, oldValues);
        }
    }

    @Override
    public List<T> get(K key) {
        if (key != null) {
            expungesCollectedGCEntries();
            Set<SoftReference<T>> references = memory.computeIfAbsent(key, k -> new CopyOnWriteArraySet<>());
            return references.stream()
                    .map(SoftReference::get)
                    .filter(Objects::nonNull)
                    .toList();
        }
        return Collections.emptyList();
    }

    @Override
    public void remove(K key, T value) {
        if (key != null && value != null) {
            expungesCollectedGCEntries();
            Set<SoftReference<T>> references = memory.computeIfAbsent(key, k -> new CopyOnWriteArraySet<>());
            references.removeIf(reference -> reference.refersTo(value));
        }
    }

    private void expungesCollectedGCEntries() {
        for (Map.Entry<K, Set<SoftReference<T>>> entry : memory.entrySet()) {
            Set<SoftReference<T>> values = entry.getValue();
            if (values == null) {
                values = new CopyOnWriteArraySet<>();
            } else {
                values.removeIf(tSoftReference -> tSoftReference.refersTo(null));
            }
            memory.put(entry.getKey(), values);
        }
    }

}
