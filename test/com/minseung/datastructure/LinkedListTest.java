package com.minseung.datastructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void test_toString_emptyLL(){
        LinkedList l1 = new LinkedList();
        assertEquals("", l1.toString());
    }

    @Test
    void test_toString_oneNodeLL(){
        LinkedList l1 = new LinkedList();
        l1.header.next = new LinkedList.Node();
        l1.header.next.data = 1;
        l1.size++;
        assertEquals("1", l1.toString());
    }

    @Test
    void test_toString_twoMoreNodeLL(){
        LinkedList l1 = new LinkedList();
        LinkedList.Node n1 = new LinkedList.Node();
        n1.data = 1;
        l1.header.next = n1;
        l1.size++;
        LinkedList.Node n2 = new LinkedList.Node();
        n2.data = 2;
        n1.next = n2;
        l1.size++;

        assertEquals("1 -> 2", l1.toString());
    }

    @Test
    void test_append() {
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        LinkedList.Node n1 = new LinkedList.Node();
        n1.data = 1;
        l1.header.next = n1;
        l1.size++;
        LinkedList.Node n2 = new LinkedList.Node();
        n2.data = 7;
        n1.next = n2;
        l1.size++;
        LinkedList.Node n3 = new LinkedList.Node();
        n3.data = 5;
        n2.next = n3;
        l1.size++;

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
    void test_removeDups(){
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


}