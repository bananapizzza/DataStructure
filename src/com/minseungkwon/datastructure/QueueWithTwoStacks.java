package com.minseungkwon.datastructure;

import java.util.NoSuchElementException;

public class QueueWithTwoStacks<T extends Comparable<T>> extends QueueInterface<T> {
    private Stack<T> oldest;
    private Stack<T> newest;

    QueueWithTwoStacks() {
        oldest = new Stack<>();
        newest = new Stack<>();
    }

    public void add(T data) {
        newest.push(data);
    }

    private void shiftStack() {
        if (oldest.isEmpty()) {
            while (!newest.isEmpty()) {
                oldest.push(newest.pop());
            }
        }
    }

    public Stack<T> getNewest() {
        return newest;
    }

    public Stack<T> getOldest() {
        return oldest;
    }

    public Node<T> getFirstNode() {
        shiftStack();
        return oldest.getTop();
    }

    public T remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        shiftStack();
        return oldest.pop();
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        shiftStack();
        return oldest.peek();
    }

    public boolean isEmpty() {
        if (oldest.isEmpty() && newest.isEmpty())
            return true;
        return false;
    }

    public int getSize() {
        int size = 0;
        Node<T> node = oldest.getTop();
        while (node != null) {
            size++;
            node = node.getNext();
        }
        node = newest.getTop();
        while (node != null) {
            size++;
            node = node.getNext();
        }
        return size;
    }

    public QueueIterator<T> queueIterator() {
        return new QueueItr();
    }

    class QueueItr implements QueueIterator<T> {
        Node<T> next;
        boolean isOldest = false;

        QueueItr() {
            if (isEmpty()) {
                next = null;
            } else {
                if (oldest.isEmpty()) {
                    shiftStack();
                }
                next = oldest.getTop();
                isOldest = true;
            }
        }

        public boolean hasNext() {
            if (isOldest && next == null) {
                if (newest.isEmpty()) {
                    return false;
                } else {
                    return true;
                }
            }
            if (!isOldest) {
                if (newest.isEmpty()) {
                    return false;
                }
                if (newest.getSize() == 1 && next == null) {
                    return false;
                }
                if (newest.getTop().getNext() == next) {
                    return false;
                }
            }
            return true;
        }

        public T next() {
            if (isOldest && next == null) {
                if (newest.isEmpty()) {
                    return null;
                }
                Node<T> n = newest.getTop();
                while (n != null && n.getNext() != null) {
                    n = n.getNext();
                }
                next = n;
                isOldest = false;
            } else if (!isOldest) {
                if (newest.isEmpty()) {
                    return null;
                }
                Node<T> n = newest.getTop();
                while (n.getNext() != next && n.getNext().getNext() != next) {
                    n = n.getNext();
                }
                next = n;
            }
            Node<T> saveNext = next;
            next = next.getNext();

            return saveNext.getData();
        }
    }
}
