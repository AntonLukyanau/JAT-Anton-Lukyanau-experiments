package org.example.gc.soft;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.Cleaner;

public class SoftReferenceMain {
    public static void main(String[] args) throws InterruptedException {
        // use VP option -Xmx6m
        /*
        SomeEntityService service = new SomeEntityService();
        for (int i = 0; i < 10_000; i++) {
            service.getSomeEntity("Vadim" + i);
        }
        System.out.println(Runtime.getRuntime().freeMemory());
        service.printCacheSize();
*/
        Object obj = new Object();
        Object obj2 = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> reference1 = new PhantomReference<>(obj, referenceQueue);
        PhantomReference<Object> reference2 = new PhantomReference<>(obj2, referenceQueue);
        Reference.reachabilityFence(reference2);
        Reference.reachabilityFence(obj2);
        obj = null;
        obj2 = null;
        System.gc();
        Reference<?> referenceFromQueue1 = referenceQueue.remove();
        System.out.println(referenceFromQueue1);
        Reference<?> referenceFromQueue2 = referenceQueue.remove();
        System.out.println(referenceFromQueue2);

    }
}
