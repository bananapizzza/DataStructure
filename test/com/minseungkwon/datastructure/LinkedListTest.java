package com.minseungkwon.datastructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    LinkedList makeLinkedList(int[] data) {
        LinkedList ll = new LinkedList();
        for (int i = 0; i < data.length; i++) {
            ll.append(data[i]);
        }
        return ll;
    }

    @Test
    void test_makeLinkedList() {
        LinkedList l1 = new LinkedList();
        LinkedList l2;
        LinkedList.Node n1 = new LinkedList.Node();
        n1.data = 1;
        l1.header.next = n1;
        LinkedList.Node n2 = new LinkedList.Node();
        n2.data = 7;
        n1.next = n2;
        LinkedList.Node n3 = new LinkedList.Node();
        n3.data = 5;
        n2.next = n3;

        int[] data = {1, 7, 5};
        l2 = makeLinkedList(data);

        assertEquals(l1.toString(), l2.toString());
    }

    @Test
    void test_toString_emptyLL() {
        LinkedList l1 = new LinkedList();
        assertEquals("", l1.toString());
    }

    @Test
    void test_toString_oneNodeLL() {
        LinkedList l1 = new LinkedList();
        l1.header.next = new LinkedList.Node();
        l1.header.next.data = 1;
        assertEquals("1", l1.toString());
    }

    @Test
    void test_toString_twoMoreNodeLL() {
        LinkedList l1 = new LinkedList();
        LinkedList.Node n1 = new LinkedList.Node();
        n1.data = 1;
        l1.header.next = n1;
        LinkedList.Node n2 = new LinkedList.Node();
        n2.data = 2;
        n1.next = n2;

        assertEquals("1 -> 2", l1.toString());
    }

    @Test
    void test_append() {
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        LinkedList.Node n1 = new LinkedList.Node();
        n1.data = 1;
        l1.header.next = n1;
        LinkedList.Node n2 = new LinkedList.Node();
        n2.data = 7;
        n1.next = n2;
        LinkedList.Node n3 = new LinkedList.Node();
        n3.data = 5;
        n2.next = n3;

        l2.append(1);
        l2.append(7);
        l2.append(5);

        assertEquals(l1.toString(), l2.toString());
    }

    @Test
    void test_delete() {
        int[] data1 = {1, 3, 4, 5};
        int[] data2 = {1, 2, 3, 4, 5};
        LinkedList l1 = makeLinkedList(data1);
        LinkedList l2 = makeLinkedList(data2);

        l2.delete(2);

        assertEquals(l1.toString(), l2.toString());
    }

    @Test
    void test_removeDups() {
        int[] data1 = {2, 3, 4};
        int[] data2 = {2, 3, 2, 4, 4};
        LinkedList l1 = makeLinkedList(data1);
        LinkedList l2 = makeLinkedList(data2);

        l2.removeDups();

        assertEquals(l1.toString(), l2.toString());
    }

    @Test
    void test_getNode() {
        LinkedList l1 = new LinkedList();
        LinkedList.Node n1 = new LinkedList.Node();
        n1.data = 1;
        l1.header.next = n1;
        LinkedList.Node n2 = new LinkedList.Node();
        n2.data = 7;
        n1.next = n2;
        LinkedList.Node n3 = new LinkedList.Node();
        n3.data = 5;
        n2.next = n3;

        assertEquals(n3, l1.getNode(3));
    }

    @Test
    void test_deleteMiddleNode() {
        int[] data1 = {2, 3, 4};
        int[] data2 = {2, 3, 2, 4};
        LinkedList l1 = makeLinkedList(data1);
        LinkedList l2 = makeLinkedList(data2);

        l2.deleteMiddleNode(l2.getNode(3));

        assertEquals(l1.toString(), l2.toString());
    }

    @Test
    void test_findKthNodeBasic() {
        int[] data = {1, 7, 5};
        LinkedList l1 = makeLinkedList(data);

        assertEquals(l1.getNode(3), l1.findKthNodeBasic(l1.header, 1));
    }

    @Test
    void test_findKthNodeUsingRecursive() {
        int[] data = {1, 7, 5};
        LinkedList l1 = makeLinkedList(data);

        LinkedList.Reference r = new LinkedList.Reference();

        assertEquals(l1.getNode(3), l1.findKthNodeUsingRecursive(l1.header, 1, r));
    }

    @Test
    void test_findKthNodeUsingPointer() {
        int[] data = {1, 7, 5};
        LinkedList l1 = makeLinkedList(data);

        assertEquals(l1.getNode(3), l1.findKthNodeUsingPointer(l1.header, 1));
    }

    @Test
    void test_getSumUsingIterate() {
        int[] data1 = {9, 1, 4};
        int[] data2 = {7, 6, 4, 3};
        LinkedList l1 = makeLinkedList(data1);
        LinkedList l2 = makeLinkedList(data2);

        LinkedListNode linkedListNode = new LinkedListNode();
        LinkedList actual = linkedListNode.getSumUsingIterate(l1, l2);

        int[] data3 = {6, 8, 8, 3};
        LinkedList expected = makeLinkedList(data3);

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void test_getSumUsingRecursive_sameLength() {

        int[] data1 = {9, 1, 4};
        int[] data2 = {7, 6, 4};
        LinkedList l1 = makeLinkedList(data1);
        LinkedList l2 = makeLinkedList(data2);

        LinkedListNode linkedListNode = new LinkedListNode();
        LinkedList.Node result = linkedListNode.getSumUsingRecursive(l1.getNode(1), l2.getNode(1), 0);
        LinkedList actual = new LinkedList();
        actual.header.next = result;

        int[] data3 = {6, 8, 8};
        LinkedList expected = makeLinkedList(data3);

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void test_getSumUsingRecursive_sameLengthWithCarry() {
        int[] data1 = {9, 1, 4};
        int[] data2 = {7, 6, 9};
        LinkedList l1 = makeLinkedList(data1);
        LinkedList l2 = makeLinkedList(data2);

        LinkedListNode linkedListNode = new LinkedListNode();
        LinkedList.Node result = linkedListNode.getSumUsingRecursive(l1.getNode(1), l2.getNode(1), 0);
        LinkedList actual = new LinkedList();
        actual.header.next = result;

        int[] data3 = {6, 8, 3, 1};
        LinkedList expected = makeLinkedList(data3);

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void test_getSumUsingRecursive_differentLength() {
        int[] data1 = {9, 1, 4};
        int[] data2 = {7, 6, 4, 3};
        LinkedList l1 = makeLinkedList(data1);
        LinkedList l2 = makeLinkedList(data2);

        LinkedListNode linkedListNode = new LinkedListNode();
        LinkedList.Node result = linkedListNode.getSumUsingRecursive(l1.getNode(1), l2.getNode(1), 0);
        LinkedList actual = new LinkedList();
        actual.header.next = result;

        int[] data3 = {6, 8, 8, 3};
        LinkedList expected = makeLinkedList(data3);

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void test_getSumBackward() {
        int[] data1 = {9, 1, 4};
        int[] data2 = {7, 6, 4, 3};
        LinkedList l1 = makeLinkedList(data1);
        LinkedList l2 = makeLinkedList(data2);

        LinkedListNode linkedListNode = new LinkedListNode();
        LinkedList.Node result = linkedListNode.getSumBackward(l1, l2);
        LinkedList actual = new LinkedList();
        actual.header.next = result;

        int[] data3 = {8, 5, 5, 7};
        LinkedList expected = makeLinkedList(data3);

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void test_getSumBackwardWithCarry() {
        int[] data1 = {8, 7, 4};
        int[] data2 = {6, 8, 3};
        LinkedList l1 = makeLinkedList(data1);
        LinkedList l2 = makeLinkedList(data2);

        LinkedListNode linkedListNode = new LinkedListNode();
        LinkedList.Node result = linkedListNode.getSumBackward(l1, l2);
        LinkedList actual = new LinkedList();
        actual.header.next = result;

        int[] data3 = {1, 5, 5, 7};
        LinkedList expected = makeLinkedList(data3);

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void test_getIntersectionWithIntersection() {
        int[] data1 = {5, 7, 9, 10, 7, 6};
        int[] data2 = {6, 8};
        LinkedList l1 = makeLinkedList(data1);
        LinkedList l2 = makeLinkedList(data2);

        LinkedList.Node connect = l2.getNode(2);
        LinkedList.Node intersection = l1.getNode(4);
        connect.next = intersection;

        LinkedListNode linkedListNode = new LinkedListNode();
        LinkedList.Node result = linkedListNode.getIntersection(l1, l2);

        assertEquals(intersection, result);
    }

    @Test
    void test_getIntersectionWithoutIntersection() {
        int[] data1 = {5, 7, 9, 10, 7, 6};
        int[] data2 = {6, 8, 10, 3};
        LinkedList l1 = makeLinkedList(data1);
        LinkedList l2 = makeLinkedList(data2);

        LinkedListNode linkedListNode = new LinkedListNode();
        LinkedList.Node result = linkedListNode.getIntersection(l1, l2);

        assertEquals(null, result);
    }

    @Test
    void test_getIntersectionUsingRecursive() {
        int[] data1 = {5, 7, 9, 10, 7, 6};
        int[] data2 = {6, 8};
        LinkedList l1 = makeLinkedList(data1);
        LinkedList l2 = makeLinkedList(data2);

        LinkedList.Node connect = l2.getNode(2);
        LinkedList.Node intersection = l1.getNode(4);
        connect.next = intersection;

        LinkedListNode linkedListNode = new LinkedListNode();
        LinkedList.Node result = linkedListNode.getIntersectionUsingRecursive(l1, l2);

        assertEquals(intersection, result);
    }

    @Test
    void test_findLoopWithLoop() {
        int k = 3;
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        LinkedList ll = makeLinkedList(data);
        LinkedList.Node end = ll.getNode(9);
        end.next = ll.getNode(k);

        LinkedListNode linkedListNode = new LinkedListNode();
        LinkedList.Node result = linkedListNode.findLoop(ll);

        assertEquals(ll.getNode(k), result);
    }

    @Test
    void test_findLoopWithoutLoop() {
        int k = 3;
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        LinkedList ll = makeLinkedList(data);

        LinkedListNode linkedListNode = new LinkedListNode();
        LinkedList.Node result = linkedListNode.findLoop(ll);

        assertEquals(null, result);
    }
}