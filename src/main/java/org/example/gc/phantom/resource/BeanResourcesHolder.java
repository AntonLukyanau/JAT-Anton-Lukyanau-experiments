package org.example.gc.phantom.resource;

import java.util.HashSet;
import java.util.Set;

public class BeanResourcesHolder<T extends AutoCloseable> {
    private final String name;
    private final Set<T> resources;

    public BeanResourcesHolder(String name, Set<T> resources) {
        this.name = name;
        this.resources = new HashSet<>(resources);
    }

    public BeanResourcesHolder(String name) {
        this.name = name;
        resources = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Set<T> getResources() {
        return new HashSet<>(resources);
    }

    public boolean addResource(T resource) {
        return resources.add(resource);
    }

}
