package org.example.gc.phantom;

import org.example.gc.phantom.resource.Resource;
import org.example.gc.phantom.resource.BeanResourcesHolder;

import java.util.HashSet;
import java.util.Set;


/**
 * Task: Implements closing of resources which associated with a resource holder.
 * Closing should be initiated after finalization of the resource holder by the garbage collector.
 * P.S. Use PhantomReference and ReferenceQueue
 */
public class PhantomReferenceMain {

    static ReferenceRegistrar<BeanResourcesHolder<Resource>, Resource> registrar;
    static ResourceCloser<BeanResourcesHolder<Resource>> closer;

    public static void main(String[] args) throws InterruptedException {

        ResourcesContext<BeanResourcesHolder<Resource>, Resource> context = new ResourcesContext<>();
        registrar = new ReferenceRegistrar<>(context);
        closer = new ResourceCloser<>(context);
        Thread closerThread = new Thread(closer);
        closerThread.start();

        BeanResourcesHolder<Resource> beanResourcesHolder = new BeanResourcesHolder<>("holder1");
        beanResourcesHolder.addResource(new Resource(1));
        beanResourcesHolder.addResource(new Resource(2));

        Set<Resource> resourceSet = new HashSet<>();
        resourceSet.add(new Resource(3));
        resourceSet.add(new Resource(4));
        BeanResourcesHolder<Resource> beanResourcesHolder2 = new BeanResourcesHolder<>("holder2", resourceSet);
        beanResourcesHolder2.addResource(new Resource(5));
        beanResourcesHolder2.addResource(new Resource(6));

        registrar.register(beanResourcesHolder, beanResourcesHolder.getResources());
        registrar.register(beanResourcesHolder2, beanResourcesHolder2.getResources());

        System.out.println("Some work");
        Thread.sleep(5000);

        beanResourcesHolder = null;
        System.gc();
        beanResourcesHolder2 = null;
        Thread.sleep(5000);

    }
}
