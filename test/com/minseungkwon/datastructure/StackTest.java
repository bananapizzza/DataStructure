package com.minseungkwon.datastructure;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.EmptyStackException;


public class StackTest {

    @Test
    public void test_toString() {
        Stack<Integer> stack = new Stack<>();
        Stack.Node<Integer> n1 = new Stack.Node<>(1);
        n1.setNext(stack.getTop());
        stack.setTop(n1);
        Stack.Node<Integer> n2 = new Stack.Node<>(2);
        n2.setNext(stack.getTop());
        stack.setTop(n2);
        Stack.Node<Integer> n3 = new Stack.Node<>(3);
        n3.setNext(stack.getTop());
        stack.setTop(n3);
        Stack.Node<Integer> n4 = new Stack.Node<>(4);
        n4.setNext(stack.getTop());
        stack.setTop(n4);

        assertEquals("4 -> 3 -> 2 -> 1", stack.toString());
    }

    @Test
    public void test_push() {
        Stack<Integer> expected = new Stack<>();
        Stack.Node<Integer> n1 = new Stack.Node<>(1);
        n1.setNext(expected.getTop());
        expected.setTop(n1);
        Stack.Node<Integer> n2 = new Stack.Node<>(2);
        n2.setNext(expected.getTop());
        expected.setTop(n2);
        Stack.Node<Integer> n3 = new Stack.Node<>(3);
        n3.setNext(expected.getTop());
        expected.setTop(n3);
        Stack.Node<Integer> n4 = new Stack.Node<>(4);
        n4.setNext(expected.getTop());
        expected.setTop(n4);

        Stack<Integer> actual = new Stack<>();
        actual.push(1);
        actual.push(2);
        actual.push(3);
        actual.push(4);

        assertEquals("4 -> 3 -> 2 -> 1", expected.toString());
    }

    @Test
    public void test_pop() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        Stack.Node<Integer> expected = stack.getTop();
        Stack.Node<Integer> actual = stack.pop();

        assertEquals(expected, actual);
    }


    @Test(expected = EmptyStackException.class)
    public void test_popException() {
        Stack<Integer> stack = new Stack<>();
        stack.pop();
    }

    @Test
    public void test_peek() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        Stack.Node<Integer> expected = stack.getTop();
        Stack.Node<Integer> actual = stack.peek();
        assertEquals(expected, actual);

        stack.pop();
        expected = stack.getTop();
        actual = stack.peek();

        assertEquals(expected, actual);
    }

    @Test(expected = EmptyStackException.class)
    public void test_peekException() {
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
}