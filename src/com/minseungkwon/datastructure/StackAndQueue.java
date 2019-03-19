package com.minseungkwon.datastructure;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

class Stack<T> {

    //TODO: Could I make Node class in a different file, and use the class in Stack class & LinkedList class too?
    static class Node<T> {
        private T data;
        private Node<T> next = null;

        Node(T data) {
            this.data = data;
        }

        void setNext(Node<T> node) {
            this.next = node;
        }
    }

    private Node<T> top = null;

    public void push(T data) {
        Node<T> node = new Node<>(data);

        node.next = top;
        top = node;
    }

    public Node<T> pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        Node<T> node = top;
        top = top.next;

        return node;
    }

    public Node<T> peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public String toString() {
        if (this.top == null)
            return "";
        Stack<T> copy = this;
        StringBuilder s = new StringBuilder();
        while (copy.top.next != null) {
            s.append(copy.top.data.toString());
            s.append(" -> ");
            copy.top = copy.top.next;
        }
        s.append(copy.top.data.toString());
        return s.toString();
    }

    public Node<T> getTop() {
        return top;
    }

    public void setTop(Node<T> top) {
        this.top = top;
    }
}

class Queue<T> {
    static class Node<T> {
        private T data;
        private Node<T> next = null;

        Node(T data) {
            this.data = data;
        }

        public void setNext(Node<T> node) {
            this.next = node;
        }
    }

    private Node<T> first = null;
    private Node<T> last = null;

    public Node<T> getFirst() {
        return first;
    }

    public Node<T> getLast() {
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
            last.next = node;
        }
        last = node;
        if (first == null) {
            first = last;
        }
    }

    public Node<T> remove() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        Node<T> node = first;
        first = first.next;

        if (first == null) {
            last = null;
        }
        return node;
    }

    public Node<T> peek() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int getSizeQueue() {
        int size = 0;
        Node<T> node = first;
        if (node != null) {
            while (node != null) {
                size++;
                node = node.next;
            }
        }
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Queue)) {
            return false;
        }
        Queue<T> queue = (Queue) obj;
        if (this.getSizeQueue() != queue.getSizeQueue()) {
            return false;
        }
        Node<T> thisQueue = this.first;
        Node<T> compareQueue = queue.first;
        while (thisQueue != null) {
            if (thisQueue.data != compareQueue.data) {
                return false;
            }
            thisQueue = thisQueue.next;
            compareQueue = compareQueue.next;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.getSizeQueue();
        Node<T> t = this.first;
        while (t != null) {
            hash += t.data.hashCode();
            t = t.next;
        }
        return hash;
    }
}


public class StackAndQueue {
}
