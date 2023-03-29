package org.example.cash;

import java.util.List;

public interface MultiValueCash<K, T> {

    void store(K key, T value);

    void storeAll(K key, Iterable<T> values);

    List<T> get(K key);

    void remove(K key, T banner);

}
