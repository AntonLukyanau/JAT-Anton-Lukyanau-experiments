package org.example.gc.phantom.resource;

import java.io.Closeable;

public class Resource implements Closeable {

    private final int id;

    public Resource(int id) {
        this.id = id;
    }

    @Override
    public void close() {
        System.out.println("Resource " + id + " was closed");
    }

}
