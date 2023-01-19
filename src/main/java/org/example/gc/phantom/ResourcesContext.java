package org.example.gc.phantom;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * It is container for store resources which mapped to phantom reference to object
 * @param <T> An object which will became as garbage and will finalize by garbage collector
 * @param <R> Resources which should be closed after finalization of associated object @param <T>
 */
public class ResourcesContext<T, R extends AutoCloseable> {

    private final ReferenceQueue<T> referenceQueue;
    private final Map<Reference<T>, Set<R>> referencedResources;

    public ResourcesContext() {
        referenceQueue = new ReferenceQueue<>();
        referencedResources = new ConcurrentHashMap<>();
    }

    public ReferenceQueue<T> getReferenceQueue() {
        return referenceQueue;
    }

    public Map<Reference<T>, Set<R>> getReferencedResources() {
        return referencedResources;
    }

}
