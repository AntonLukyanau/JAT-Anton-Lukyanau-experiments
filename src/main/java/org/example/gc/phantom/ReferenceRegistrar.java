package org.example.gc.phantom;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Object with associated resources are register in context {@link ResourcesContext} by object of this class
 * @param <T> An object which will became garbage and will finalize by garbage collector
 * @param <R> Resources which should be closed after finalization of associated object @param <T>
 */
public class ReferenceRegistrar<T, R extends AutoCloseable> {

    private final ResourcesContext<T, R> context;

    public ReferenceRegistrar(ResourcesContext<T, R> context) {
        this.context = context;
    }

    public boolean register(T objWithResources, Set<R> resources) {
        Map<Reference<T>, Set<R>> referencedResources = context.getReferencedResources();
        for (Map.Entry<Reference<T>, Set<R>> entry : referencedResources.entrySet()) {
            if (entry.getKey().refersTo(objWithResources)) {
                return false;
            }
        }
        PhantomReference<T> reference = new PhantomReference<>(objWithResources, context.getReferenceQueue());
        referencedResources.put(reference, new HashSet<>(resources));
        return true;
    }

}
