package com.minseungkwon.datastructure;

import org.junit.Test;
import java.util.NoSuchElementException;
import static org.junit.Assert.assertEquals;

public class QueueTest {
    @Test
    public void test_getSizeQueue(){
        Queue<Integer> queue = new Queue<>();
        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        n1.setNext(n2);
        Node<Integer> n3 = new Node<>(3);
        n2.setNext(n3);
        Node<Integer> n4 = new Node<>(4);
        n3.setNext(n4);
        Node<Integer> n5 = new Node<>(5);
        n4.setNext(n5);
        queue.setFirst(n1);
        queue.setLast(n5);

        assertEquals(5, queue.getSize());
    }

    @Test
    public void test_add() {
        Queue<Integer> expected = new Queue<>();
        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(2);
        n1.setNext(n2);
        Node<Integer> n3 = new Node<>(3);
        n2.setNext(n3);
        Node<Integer> n4 = new Node<>(4);
        n3.setNext(n4);
        Node<Integer> n5 = new Node<>(5);
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
        Integer expected = queue.getFirstNode().getData();
        Integer actual = queue.remove();

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
        Integer expected = queue.getFirstNode().getData();
        Integer actual = queue.peek();

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