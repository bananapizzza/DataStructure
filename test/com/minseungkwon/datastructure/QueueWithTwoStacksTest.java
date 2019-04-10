package com.minseungkwon.datastructure;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class QueueWithTwoStacksTest {

    @Test
    public void test_equals() {
        QueueWithTwoStacks<Integer> q1 = new QueueWithTwoStacks<>();
        QueueWithTwoStacks<Integer> q2 = new QueueWithTwoStacks<>();

        q1.add(1);
        q1.add(2);
        q1.add(3);
        q2.add(1);
        q2.add(2);
        q2.add(3);
        assertEquals(q1, q2);
    }

    @Test
    public void test_equalsWithPeek() {
        QueueWithTwoStacks<Integer> q1 = new QueueWithTwoStacks<>();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.peek();

        QueueWithTwoStacks<Integer> q2 = new QueueWithTwoStacks<>();
        q2.add(1);
        q2.add(2);
        q2.add(3);

        assertEquals(q1, q2);
    }

    @Test
    public void test_equalsWithRemove() {
        QueueWithTwoStacks<Integer> q1 = new QueueWithTwoStacks<>();
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(4);
        q1.remove();

        QueueWithTwoStacks<Integer> q2 = new QueueWithTwoStacks<>();
        q2.add(2);
        q2.add(3);
        q2.add(4);

        assertEquals(q1, q2);
    }

    @Test
    public void test_equalsAddAfterPeek() {
        QueueWithTwoStacks<Integer> q1 = new QueueWithTwoStacks<>();
        q1.add(1);
        q1.add(2);
        q1.peek();
        q1.add(3);
        q1.add(4);
        QueueWithTwoStacks<Integer> q2 = new QueueWithTwoStacks<>();
        q2.add(1);
        q2.add(2);
        q2.add(3);
        q2.add(4);
        assertEquals(q1, q2);
    }

    @Test
    public void test_equalsAddAfterRemove() {
        QueueWithTwoStacks<Integer> q1 = new QueueWithTwoStacks<>();
        q1.add(1);
        q1.add(2);
        q1.remove();
        q1.add(3);
        q1.add(4);
        QueueWithTwoStacks<Integer> q2 = new QueueWithTwoStacks<>();
        q2.add(2);
        q2.add(3);
        q2.add(4);
        assertEquals(q1, q2);
    }

    @Test
    public void test_compareQueueWithTwoStacksWithQueue() {
        QueueWithTwoStacks<Integer> q1 = new QueueWithTwoStacks<>();
        Queue<Integer> q2 = new Queue<>();

        q1.add(1);
        q1.add(2);
        q1.add(3);
        q2.add(1);
        q2.add(2);
        q2.add(3);

        assertEquals(q1, q2);
    }

    @Test
    public void test_compareQueueWithTwoStacksWithQueueReverse() {
        Queue<Integer> q1 = new Queue<>();
        QueueWithTwoStacks<Integer> q2 = new QueueWithTwoStacks<>();

        q1.add(1);
        q1.add(2);
        q1.add(3);
        q2.add(1);
        q2.add(2);
        q2.add(3);

        assertEquals(q1, q2);
    }

    @Test
    public void test_compareQueueWithTwoStacksWithQueueWithPeek() {
        QueueWithTwoStacks<Integer> q1 = new QueueWithTwoStacks<>();
        Queue<Integer> q2 = new Queue<>();

        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.peek();
        q2.add(1);
        q2.add(2);
        q2.add(3);

        assertEquals(q1, q2);
    }

    @Test
    public void test_compareQueueWithTwoStacksWithQueueWithRemove() {
        QueueWithTwoStacks<Integer> q1 = new QueueWithTwoStacks<>();
        Queue<Integer> q2 = new Queue<>();

        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.remove();
        q2.add(2);
        q2.add(3);

        assertEquals(q1, q2);
    }

    @Test
    public void test_compareQueueWithTwoStacksWithQueueWithAddAfterPeek() {
        QueueWithTwoStacks<Integer> q1 = new QueueWithTwoStacks<>();
        Queue<Integer> q2 = new Queue<>();

        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.peek();
        q1.add(4);
        q2.add(1);
        q2.add(2);
        q2.add(3);
        q2.add(4);

        assertEquals(q1, q2);
    }

    @Test
    public void test_compareQueueWithTwoStacksWithQueueWithAddAfterRemove() {
        QueueWithTwoStacks<Integer> q1 = new QueueWithTwoStacks<>();
        Queue<Integer> q2 = new Queue<>();

        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.remove();
        q1.add(4);
        q2.add(2);
        q2.add(3);
        q2.add(4);

        assertEquals(q1, q2);
    }

    @Test
    public void test_hasNext() {
        QueueWithTwoStacks<Integer> q1 = new QueueWithTwoStacks<>();
        QueueIterator<Integer> integerQueueIterator = q1.queueIterator();
        assertFalse(integerQueueIterator.hasNext());

        q1.add(1);
        integerQueueIterator = q1.queueIterator();
        assertTrue(integerQueueIterator.hasNext());
    }

    @Test
    public void test_next() {
        QueueWithTwoStacks<Integer> q1 = new QueueWithTwoStacks<>();
        QueueIterator<Integer> integerQueueIterator = q1.queueIterator();
        assertEquals(null, integerQueueIterator.next());

        q1.add(1);
        integerQueueIterator = q1.queueIterator();
        assertEquals((Integer) 1, integerQueueIterator.next());

        q1.add(2);
        assertEquals((Integer) 2, integerQueueIterator.next());

        q1.add(3);
        assertEquals((Integer) 3, integerQueueIterator.next());
    }
}