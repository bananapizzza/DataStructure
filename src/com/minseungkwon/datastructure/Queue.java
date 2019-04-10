package com.minseungkwon.datastructure;

import java.util.NoSuchElementException;

public class Queue<T> extends QueueInterface<T> {

    private Node<T> first = null;
    private Node<T> last = null;

    public Node<T> getFirstNode() {
        return first;
    }

    public Node<T> getLastNode() {
        return last;
    }

    public void setFirst(Node<T> node) {
        first = node;
    }

    public void setLast(Node<T> node) {
        last = node;
    }


    public void add(T data) {
        Node<T> node = new Node<>(data);

        if (last != null) {
            last.setNext(node);
        }
        last = node;
        if (first == null) {
            first = last;
        }
    }

    public T remove() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        Node<T> node = first;
        first = first.getNext();

        if (first == null) {
            last = null;
        }
        return node.getData();
    }

    public T peek() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.getData();
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int getSize() {
        int size = 0;
        Node<T> node = first;
        if (node != null) {
            while (node != null) {
                size++;
                node = node.getNext();
            }
        }
        return size;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (!(obj instanceof Queue)) {
//            return false;
//        }
//        Queue<T> queue = (Queue) obj;
//        if (this.getSize() != queue.getSize()) {
//            return false;
//        }
//        Node<T> thisQueue = this.first;
//        Node<T> compareQueue = queue.first;
//        while (thisQueue != null) {
//            if (thisQueue.getData() != compareQueue.getData()) {
//                return false;
//            }
//            thisQueue = thisQueue.getNext();
//            compareQueue = compareQueue.getNext();
//        }
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 31 * hash + this.getSize();
//        Node<T> t = this.first;
//        while (t != null) {
//            hash += t.getData().hashCode();
//            t = t.getNext();
//        }
//        return hash;
//    }

    public QueueIterator<T> queueIterator() {
        return new QueueItr();
    }

    class QueueItr implements QueueIterator<T> {
        Node<T> next;

        QueueItr() {
            if (isEmpty()) {
                next = null;
            }
            next = first;
        }

        public boolean hasNext() {
            return !(next == null);
        }

        public T next() {
            Node<T> saveNext = next;
            next = next.getNext();
            return saveNext.getData();
        }
    }
}
