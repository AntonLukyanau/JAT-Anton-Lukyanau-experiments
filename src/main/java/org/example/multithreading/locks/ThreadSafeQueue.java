package org.example.multithreading.locks;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeQueue<T> implements Queue<T> {

    private final Queue<T> queue = new LinkedList<>();
    private final ReentrantLock reentrantLock = new ReentrantLock();

    @Override
    public int size() {
        try {
            reentrantLock.lock();
            return queue.size();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override
    public boolean isEmpty() {
        return size() > 0;
    }

    @Override
    public boolean contains(Object o) {
        try {
            reentrantLock.lock();
            return queue.contains(o);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        try {
            reentrantLock.lock();
            return queue.toArray();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        try {
            reentrantLock.lock();
            return queue.toArray(a);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override
    public boolean add(T t) {
        try {
            reentrantLock.lock();
            return queue.add(t);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        try {
            reentrantLock.lock();
            return queue.containsAll(c);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        try {
            reentrantLock.lock();
            return queue.addAll(c);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        try {
            reentrantLock.lock();
            return queue.removeAll(c);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        try {
            reentrantLock.lock();
            return queue.retainAll(c);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override
    public void clear() {
        try {
            reentrantLock.lock();
            queue.clear();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override
    public boolean offer(T t) {
        try {
            reentrantLock.lock();
            return queue.offer(t);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override
    public T remove() {
        try {
            reentrantLock.lock();
            return queue.remove();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override
    public T poll() {
        try {
            reentrantLock.lock();
            return queue.poll();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override
    public T element() {
        try {
            reentrantLock.lock();
            return queue.element();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override
    public T peek() {
        try {
            reentrantLock.lock();
            return queue.peek();
        } finally {
            reentrantLock.unlock();
        }
    }

}
