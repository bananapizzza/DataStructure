package com.minseungkwon.datastructure;

public class Node<T> {
    private T data;
    private Node<T> next = null;

    Node(T data) {
        this.data = data;
    }

    public void setNext(Node<T> node) {
        this.next = node;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
