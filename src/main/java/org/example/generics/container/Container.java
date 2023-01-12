package org.example.generics.container;

import org.example.generics.model.Product;

public class Container<T> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public static <E> E method(E... items) {
        for (E item : items) {
            if (item.toString().length() > 0) {
                return item;
            }
        }
        return null;
    }
}
