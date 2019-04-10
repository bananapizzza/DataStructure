package com.minseungkwon.datastructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class QueueInterface<T> {
    abstract void add(T data);

    abstract T remove();

    abstract T peek();

    abstract boolean isEmpty();

    abstract int getSize();

    abstract Node<T> getFirstNode();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QueueInterface)) {
            return false;
        }

        QueueIterator<T> e1 = queueIterator();
        QueueIterator<?> e2 = ((QueueInterface<?>) obj).queueIterator();
        while (e1.hasNext() && e2.hasNext()) {
            T o1 = e1.next();
            Object o2 = e2.next();
            if (!(o1 == null ? o2 == null : o1.equals(o2)))
                return false;
        }
        return !(e1.hasNext() || e2.hasNext());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.getSize();
        Node<T> t = this.getFirstNode();
        while (t != null) {
            hash += t.hashCode();
            t = t.getNext();
        }
        return hash;
    }

    public QueueIterator<T> queueIterator() {
        return new QueueItr();
    }

    class QueueItr implements QueueIterator<T> {
        Node<T> current;
        int currentLocation = 0;

        QueueItr() {

        }

        public boolean hasNext() {
            System.out.println("!!");
            return false;
        }

        public T next() {

            return current == null ? null : current.getData();
        }
    }
}

