package com.minseungkwon.datastructure;

import java.util.EmptyStackException;

public class Stack<T> {
    private Node<T> top = null;

    public void push(T data) {
        Node<T> node = new Node<>(data);

        node.setNext(top);
        top = node;
    }

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        Node<T> node = top;
        top = top.getNext();

        return node.getData();
    }

    public T peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.getData();
    }

    public boolean isEmpty() {
        return top == null;
    }

    public String toString() {
        if (this.top == null)
            return "";
        Node<T> copy = this.top;
        StringBuilder s = new StringBuilder();
        while (copy.getNext() != null) {
            s.append(copy.getData().toString());
            s.append(" -> ");
            copy = copy.getNext();
        }
        s.append(copy.getData().toString());
        return s.toString();
    }

    public Node<T> getTop() {
        return top;
    }

    public void setTop(Node<T> top) {
        this.top = top;
    }

    public int getSize() {
        Node<T> n = this.top;
        int size = 0;
        while(n != null){
            size++;
            n = n.getNext();
        }
        return size;
    }
}
