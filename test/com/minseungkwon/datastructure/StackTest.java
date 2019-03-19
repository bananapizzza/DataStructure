package com.minseungkwon.datastructure;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;


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
    public void test_peekStack() {
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
    public void test_getSizeQueue(){
        Queue<Integer> queue = new Queue<>();
        Queue.Node<Integer> n1 = new Queue.Node<>(1);
        Queue.Node<Integer> n2 = new Queue.Node<>(2);
        n1.setNext(n2);
        Queue.Node<Integer> n3 = new Queue.Node<>(3);
        n2.setNext(n3);
        Queue.Node<Integer> n4 = new Queue.Node<>(4);
        n3.setNext(n4);
        Queue.Node<Integer> n5 = new Queue.Node<>(5);
        n4.setNext(n5);
        queue.setFirst(n1);
        queue.setLast(n5);

        assertEquals(5, queue.getSizeQueue());
    }

    @Test
    public void test_add() {
        Queue<Integer> expected = new Queue<>();
        Queue.Node<Integer> n1 = new Queue.Node<>(1);
        Queue.Node<Integer> n2 = new Queue.Node<>(2);
        n1.setNext(n2);
        Queue.Node<Integer> n3 = new Queue.Node<>(3);
        n2.setNext(n3);
        Queue.Node<Integer> n4 = new Queue.Node<>(4);
        n3.setNext(n4);
        Queue.Node<Integer> n5 = new Queue.Node<>(5);
        n4.setNext(n5);
        expected.setFirst(n1);
        expected.setLast(n5);

        Queue<Integer> actual = new Queue<>();
        actual.add(1);
        actual.add(2);
        actual.add(3);
        actual.add(4);
        actual.add(5);

        assertEquals(expected, actual);
    }

    @Test
    public void test_remove() {
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        Queue.Node<Integer> expected = queue.getFirst();
        Queue.Node<Integer> actual = queue.remove();

        assertEquals(expected, actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void test_removeException() {
        Queue<Integer> queue = new Queue<>();
        queue.remove();
    }

    @Test
    public void test_peekQueue() {
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        Queue.Node<Integer> expected = queue.getFirst();
        Queue.Node<Integer> actual = queue.peek();

        assertEquals(expected, actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void test_peekExceptionQueue() {
        Queue<Integer> queue = new Queue<>();
        queue.peek();
    }

    @Test
    public void isEmptyWithEmptyQueue() {
        Queue<Integer> queue = new Queue<>();
        assertEquals(true, queue.isEmpty());
    }

    @Test
    public void isEmptyWithFilledQueue() {
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        assertEquals(false, queue.isEmpty());
    }
}