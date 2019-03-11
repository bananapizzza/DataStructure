package com.minseung.datastructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

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
        //l1.size++;
        assertEquals("1", l1.toString());
    }

    @Test
    void test_toString_twoMoreNodeLL() {
        LinkedList l1 = new LinkedList();
        LinkedList.Node n1 = new LinkedList.Node();
        n1.data = 1;
        l1.header.next = n1;
        //l1.size++;
        LinkedList.Node n2 = new LinkedList.Node();
        n2.data = 2;
        n1.next = n2;
        //l1.size++;

        assertEquals("1 -> 2", l1.toString());
    }

    @Test
    void test_append() {
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        LinkedList.Node n1 = new LinkedList.Node();
        n1.data = 1;
        l1.header.next = n1;
        //l1.size++;
        LinkedList.Node n2 = new LinkedList.Node();
        n2.data = 7;
        n1.next = n2;
        //l1.size++;
        LinkedList.Node n3 = new LinkedList.Node();
        n3.data = 5;
        n2.next = n3;
        //l1.size++;

        l2.append(1);
        l2.append(7);
        l2.append(5);

        assertEquals(l1.toString(), l2.toString());
    }

    @Test
    void test_delete() {
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        l1.append(1);
        l1.append(3);
        l1.append(4);
        l1.append(5);

        l2.append(1);
        l2.append(2);
        l2.append(3);
        l2.append(4);
        l2.append(5);
        l2.delete(2);

        assertEquals(l1.toString(), l2.toString());
    }

    @Test
    void test_removeDups() {
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        l1.append(2);
        l1.append(3);
        l1.append(4);

        l2.append(2);
        l2.append(3);
        l2.append(2);
        l2.append(4);
        l2.append(4);
        l2.removeDups();

        assertEquals(l1.toString(), l2.toString());
    }

    @Test
    void test_getNode() {
        LinkedList l1 = new LinkedList();
        LinkedList.Node n1 = new LinkedList.Node();
        n1.data = 1;
        l1.header.next = n1;
        //l1.size++;
        LinkedList.Node n2 = new LinkedList.Node();
        n2.data = 7;
        n1.next = n2;
        //l1.size++;
        LinkedList.Node n3 = new LinkedList.Node();
        n3.data = 5;
        n2.next = n3;
        //l1.size++;

        assertEquals(n3, l1.getNode(3));
    }

    @Test
    void test_deleteMiddleNode() {
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        l1.append(2);
        l1.append(3);
        l1.append(4);

        l2.append(2);
        l2.append(3);
        l2.append(2);
        l2.append(4);
        l2.deleteMiddleNode(l2.getNode(3));

        assertEquals(l1.toString(), l2.toString());
    }

    @Test
    void test_findKthNodeBasic() {
        LinkedList l1 = new LinkedList();
        LinkedList.Node n1 = new LinkedList.Node();
        n1.data = 1;
        l1.header.next = n1;
        //l1.size++;
        LinkedList.Node n2 = new LinkedList.Node();
        n2.data = 7;
        n1.next = n2;
        //l1.size++;
        LinkedList.Node n3 = new LinkedList.Node();
        n3.data = 5;
        n2.next = n3;
        //l1.size++;

        assertEquals(n3, l1.findKthNodeBasic(l1.header, 1));
    }

    @Test
    void test_findKthNodeUsingRecursive() {
        LinkedList l1 = new LinkedList();
        LinkedList.Node n1 = new LinkedList.Node();
        n1.data = 1;
        l1.header.next = n1;
        //l1.size++;
        LinkedList.Node n2 = new LinkedList.Node();
        n2.data = 7;
        n1.next = n2;
        //l1.size++;
        LinkedList.Node n3 = new LinkedList.Node();
        n3.data = 5;
        n2.next = n3;
        //l1.size++;

        LinkedList.Reference r = new LinkedList.Reference();

        assertEquals(n3, l1.findKthNodeUsingRecursive(l1.header, 1, r));
    }

    @Test
    void test_findKthNodeUsingPointer() {
        LinkedList l1 = new LinkedList();
        LinkedList.Node n1 = new LinkedList.Node();
        n1.data = 1;
        l1.header.next = n1;
        //l1.size++;
        LinkedList.Node n2 = new LinkedList.Node();
        n2.data = 7;
        n1.next = n2;
        //l1.size++;
        LinkedList.Node n3 = new LinkedList.Node();
        n3.data = 5;
        n2.next = n3;
        //l1.size++;

        assertEquals(n3, l1.findKthNodeUsingPointer(l1.header, 1));
    }

    @Test
    void test_getSumUsingIterate() {
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        l1.append(9);
        l1.append(1);
        l1.append(4);

        l2.append(7);
        l2.append(6);
        l2.append(4);
        l2.append(3);

        LinkedListNode linkedListNode = new LinkedListNode();
        LinkedList l3 = linkedListNode.getSumUsingIterate(l1, l2);

        LinkedList l4 = new LinkedList();
        l4.append(6);
        l4.append(8);
        l4.append(8);
        l4.append(3);
//        l4.append(5);
//        l4.append(6);
//        l4.append(7);

        assertEquals(l4.toString(), l3.toString());
    }

    @Test
    void test_getSumUsingRecursive_sameLength() {
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        l1.append(9);
        l1.append(1);
        l1.append(4);

        l2.append(7);
        l2.append(6);
        l2.append(4);

        LinkedListNode linkedListNode = new LinkedListNode();
        LinkedList.Node result = linkedListNode.getSumUsingRecursive(l1.getNode(1), l2.getNode(1), 0);
        LinkedList l3 = new LinkedList();
        l3.header.next = result;

        LinkedList l4 = new LinkedList();
        l4.append(6);
        l4.append(8);
        l4.append(8);

        assertEquals(l4.toString(), l3.toString());
    }

    @Test
    void test_getSumUsingRecursive_sameLengthWithCarry() {
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        l1.append(9);
        l1.append(1);
        l1.append(4);

        l2.append(7);
        l2.append(6);
        l2.append(9);

        LinkedListNode linkedListNode = new LinkedListNode();
        LinkedList.Node result = linkedListNode.getSumUsingRecursive(l1.getNode(1), l2.getNode(1), 0);
        LinkedList l3 = new LinkedList();
        l3.header.next = result;

        LinkedList l4 = new LinkedList();
        l4.append(6);
        l4.append(8);
        l4.append(3);
        l4.append(1);


        assertEquals(l4.toString(), l3.toString());
    }

    @Test
    void test_getSumUsingRecursive_differentLength() {
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        l1.append(9);
        l1.append(1);
        l1.append(4);

        l2.append(7);
        l2.append(6);
        l2.append(4);
        l2.append(3);

        LinkedListNode linkedListNode = new LinkedListNode();
        LinkedList.Node result = linkedListNode.getSumUsingRecursive(l1.getNode(1), l2.getNode(1), 0);
        LinkedList l3 = new LinkedList();
        l3.header.next = result;

        LinkedList l4 = new LinkedList();
        l4.append(6);
        l4.append(8);
        l4.append(8);
        l4.append(3);

        assertEquals(l4.toString(), l3.toString());
    }

    @Test
    void test_getSumBackward(){
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        l1.append(9);
        l1.append(1);
        l1.append(4);

        l2.append(7);
        l2.append(6);
        l2.append(4);
        l2.append(3);

        LinkedListNode linkedListNode = new LinkedListNode();
        LinkedList.Node result = linkedListNode.getSumBackward(l1, l2);
        LinkedList l3 = new LinkedList();
        l3.header.next = result;

        LinkedList l4 = new LinkedList();
        l4.append(8);
        l4.append(5);
        l4.append(5);
        l4.append(7);

        assertEquals(l4.toString(), l3.toString());
    }

    @Test
    void test_getSumBackwardWithCarry(){
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        l1.append(9);
        l1.append(1);
        l1.append(4);

        l2.append(6);
        l2.append(4);
        l2.append(3);

        LinkedListNode linkedListNode = new LinkedListNode();
        LinkedList.Node result = linkedListNode.getSumBackward(l1, l2);
        LinkedList l3 = new LinkedList();
        l3.header.next = result;

        LinkedList l4 = new LinkedList();
        l4.append(1);
        l4.append(5);
        l4.append(5);
        l4.append(7);

        assertEquals(l4.toString(), l3.toString());
    }
}