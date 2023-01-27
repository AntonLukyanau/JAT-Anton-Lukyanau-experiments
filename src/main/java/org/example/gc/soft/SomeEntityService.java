package org.example.gc.soft;

import org.example.gc.soft.cache.Cache;

public class SomeEntityService {

    private final Cache<String, SomeEntity> cache;

    public SomeEntityService() {
        cache = new Cache<>();
    }

    public SomeEntity getSomeEntity(String name) {
        SomeEntity someEntity = cache.get(name);
        if (someEntity == null) {
            someEntity = new SomeEntity(name);
            cache.store(name, someEntity);
        }
        return someEntity;
    }

    public void printCacheSize() {
        System.out.println(cache.calculateSize());
    }

}
