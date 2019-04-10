package com.minseungkwon.datastructure;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.EmptyStackException;

public class StackTest {

    @Test
    public void test_toString() {
        Stack<Integer> stack = new Stack<>();
        Node<Integer> n1 = new Node<>(1);
        n1.setNext(stack.getTop());
        stack.setTop(n1);
        Node<Integer> n2 = new Node<>(2);
        n2.setNext(stack.getTop());
        stack.setTop(n2);
        Node<Integer> n3 = new Node<>(3);
        n3.setNext(stack.getTop());
        stack.setTop(n3);
        Node<Integer> n4 = new Node<>(4);
        n4.setNext(stack.getTop());
        stack.setTop(n4);

        assertEquals("4 -> 3 -> 2 -> 1", stack.toString());
    }

    @Test
    public void test_push() {
        Stack<Integer> expected = new Stack<>();
        Node<Integer> n1 = new Node<>(1);
        n1.setNext(expected.getTop());
        expected.setTop(n1);
        Node<Integer> n2 = new Node<>(2);
        n2.setNext(expected.getTop());
        expected.setTop(n2);
        Node<Integer> n3 = new Node<>(3);
        n3.setNext(expected.getTop());
        expected.setTop(n3);
        Node<Integer> n4 = new Node<>(4);
        n4.setNext(expected.getTop());
        expected.setTop(n4);

        Stack<Integer> actual = new Stack<>();
        actual.push(1);
        actual.push(2);
        actual.push(3);
        actual.push(4);

        assertEquals("4 -> 3 -> 2 -> 1", actual.toString());
    }

    @Test
    public void test_pop() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        Integer expected = stack.getTop().getData();
        Integer actual = stack.pop();

        assertEquals(expected, actual);
    }


    @Test(expected = EmptyStackException.class)
    public void test_popException() {
        Stack<Integer> stack = new Stack<>();
        stack.pop();
    }

    @Test
    public void test_peekStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        Integer expected = stack.getTop().getData();
        Integer actual = stack.peek();
        assertEquals(expected, actual);

        stack.pop();
        expected = stack.getTop().getData();
        actual = stack.peek();

        assertEquals(expected, actual);
    }

    @Test(expected = EmptyStackException.class)
    public void test_peekExceptionStack() {
        Stack<Integer> stack = new Stack<>();
        stack.peek();
    }

    @Test
    public void test_isEmptyWithEmptyStack() {
        Stack<Integer> stack = new Stack<>();
        assertEquals(true, stack.isEmpty());
    }

    @Test
    public void test_isEmptyWithFilledStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        assertEquals(false, stack.isEmpty());
    }

    @Test
    public void test_sortUsingAnotherStack() {
        Stack<Integer> actual = new Stack<>();
        actual.push(2);
        actual.push(6);
        actual.push(8);
        actual.push(5);
        actual.push(3);
        actual.sortUsingAnotherStack();

        assertEquals("2 -> 3 -> 5 -> 6 -> 8", actual.toString());
    }
}