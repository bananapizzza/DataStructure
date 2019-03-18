package com.minseungkwon.datastructure;

import java.util.EmptyStackException;

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


public class StackAndQueue {
}
