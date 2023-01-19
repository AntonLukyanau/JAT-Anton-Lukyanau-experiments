package org.example.gc.phantom;

import org.example.gc.phantom.resource.BeanResourcesHolder;

import java.lang.ref.Reference;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * Object of this class checking the reference queue which placed into {@link ResourcesContext}
 * and close attached to {@link BeanResourcesHolder} resources
 *
 * @param <T> Context with registered {@link ResourcesContext}
 */
public class ResourceCloser<T> implements Runnable {

    private final ResourcesContext<T, ? extends AutoCloseable> context;

    public ResourceCloser(ResourcesContext<T, ? extends AutoCloseable> context) {
        this.context = context;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Reference<? extends T> reference = context.getReferenceQueue().remove();
                Map<Reference<T>, ? extends Set<? extends AutoCloseable>> referencedResources = context.getReferencedResources();
                if (!referencedResources.containsKey(reference)) {
                    System.err.println("Unexpected reference in the referenceQueue. Reference: " + reference);
                } else {
                    closeResources(reference, referencedResources);
                }
            } catch (InterruptedException e) {
                System.out.println("Closer was interrupted");
                break;
            }
        }
        System.out.println("ResourceCloser was finished.");
    }

    private void closeResources(
            Reference<? extends T> reference,
            Map<Reference<T>, ? extends Set<? extends AutoCloseable>> referencedResources) {

        Set<? extends AutoCloseable> resources = referencedResources.get(reference);
        for (AutoCloseable resource : resources) {
            close(resource);
        }
    }

    private void close(AutoCloseable resource) {
        try {
            resource.close();
        } catch (Exception e) {
            System.err.println("Exception on close resource " + resource
                    + ". StackTrace:\n" + Arrays.toString(e.getStackTrace()));
        }
    }
}
