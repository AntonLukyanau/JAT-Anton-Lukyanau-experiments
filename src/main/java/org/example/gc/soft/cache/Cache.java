package org.example.gc.soft.cache;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;


public class Cache<K, V> {
    private final Map<K, SoftReference<V>> values = new ConcurrentHashMap<>();

    public void store(K key, V value) {
        expungesCollectedGCEntries();
        SoftReference<V> reference = new SoftReference<>(value);
        values.put(key, reference);
    }

    public V get(K key) {
        expungesCollectedGCEntries();
        SoftReference<V> reference = values.get(key);
        if (reference == null) {
            return null;
        }

        return reference.get();
    }

    public boolean remove(K key) {
        expungesCollectedGCEntries();
        if (values.containsKey(key)) {
            values.remove(key);
            return true;
        }
        return false;
    }

    public long calculateSize() {
        expungesCollectedGCEntries();
        return values.size();
    }

    private void expungesCollectedGCEntries() {
        Set<Map.Entry<K, SoftReference<V>>> entries = values.entrySet();
        for (Map.Entry<K, SoftReference<V>> entry : entries) {
            if (entry.getValue().get() == null) {
                System.out.println("Object " + entry.getKey() + " was removed");
                values.remove(entry.getKey());
            }
        }
    }
}
