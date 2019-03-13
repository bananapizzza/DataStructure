package com.minseung.datastructure;

class LinkedList {
    Node header;

    static class Node {
        int data;
        Node next = null;

        Node() {
        }

        Node(int data) {
            this.data = data;
        }
    }


    LinkedList() {
        header = new Node();
    }

    void append(int d) {
        Node n = header;
        Node end = new Node();
        end.data = d;

        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    void delete(int d) {
        Node n = header;
        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    void printData() {
        String s = this.toString();
        System.out.println(s);
    }

    @Override
    public String toString() {
        String s = "";
        if (getSize() == 0)
            return s;
        Node n = header.next;
        while (n.next != null) {
            s = s + Integer.toString(n.data) + " -> ";
            n = n.next;
        }
        s = s + Integer.toString(n.data);
        return s;
    }

    int getSize() {
        Node n = this.header;
        int size = 0;
        while (n.next != null) {
            size++;
            n = n.next;
        }
        return size;
    }

    void removeDups() {
        Node n = header;
        while (n != null && n.next != null) {
            Node r = n;
            while (r.next != null) {
                if (n.data == r.next.data) {
                    r.next = r.next.next;
                } else {
                    r = r.next;
                }
            }
            n = n.next;
        }
    }

    Node getHeader() {
        return header;
    }

    Node getNode(int k) {
        Node n = header;
        for (int i = 0; i < k; i++) {
            n = n.next;
        }
        return n;
    }


    boolean deleteMiddleNode(Node n) {
        if (n == null || n.next == null)
            return false;

        Node next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }

    //Solution 1: Basic
    Node findKthNodeBasic(Node first, int k) {
        Node n = first;
        int count = 0;

        while (n.next != null) {
            count++;
            n = n.next;
        }

        n = first;
        for (int i = 0; i < count - k + 1; i++) {
            n = n.next;
        }
        return n;
    }

    //Solution 2: Using recursive function
    static class Reference {
        int count = 0;
    }

    Node findKthNodeUsingRecursive(Node n, int k, Reference r) {
        if (n == null)
            return null;
        Node found = findKthNodeUsingRecursive(n.next, k, r);
        r.count++;
        if (r.count == k) {
            return n;
        }
        return found;
    }

    //Solution 3: Using pointer
    Node findKthNodeUsingPointer(Node first, int k) {
        Node p1 = first;
        Node p2 = first;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

}

class Storage {
    int carry = 0;
    LinkedList.Node result = null;
}


public class LinkedListNode {
    public static void main(String[] args) {
        int k = 2;
        LinkedList ll = new LinkedList();
        LinkedList.Node found;
        LinkedList.Reference r = new LinkedList.Reference();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.append(5);
        ll.printData();
        found = ll.findKthNodeBasic(ll.getHeader(), k);
        System.out.println(found.data);

        found = ll.findKthNodeUsingRecursive(ll.getHeader(), k, r);
        System.out.println(found.data);

        found = ll.findKthNodeUsingPointer(ll.getHeader(), k);
        System.out.println(found.data);
        ll.deleteMiddleNode(ll.getNode(k));
        ll.printData();

        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        l1.append(9);
        l1.append(1);
        l1.append(4);
        l1.printData();
        l2.append(6);
        l2.append(4);
        l2.append(9);
        l2.printData();
        LinkedListNode linkedListNode = new LinkedListNode();
        LinkedList l3 = linkedListNode.getSumUsingIterate(l1, l2);
        l3.printData();


    }

    public LinkedList getSumUsingIterate(LinkedList l1, LinkedList l2) {
        int carry = 0;
        LinkedList l3 = new LinkedList();
        LinkedList.Node n1 = l1.header.next;
        LinkedList.Node n2 = l2.header.next;
        while (n1 != null || n2 != null) {
            int result = carry;
            carry = 0;
            if (n1 != null) {
                result += n1.data;
                n1 = n1.next;
            }

            if (n2 != null) {
                result += n2.data;
                n2 = n2.next;

            }
            if (result >= 10) {
                carry = result / 10;
                result = result % 10;
            }
            l3.append(result);
        }

        if (carry != 0) {
            l3.append(carry);
        }

        return l3;
    }

    public LinkedList.Node getSumUsingRecursive(LinkedList.Node n1, LinkedList.Node n2, int carry) {
        if (n1 == null && n2 == null && carry == 0)
            return null;

        LinkedList.Node result = new LinkedList.Node();
        int value = carry;

        if (n1 != null) {
            value += n1.data;
        }
        if (n2 != null) {
            value += n2.data;
        }
        result.data = value % 10;

        if (n1 != null || n2 != null) {
            LinkedList.Node next = getSumUsingRecursive(n1 == null ? null : n1.next, n2 == null ? null : n2.next, value >= 10 ? value / 10 : 0);
            result.next = next;
        }
        return result;
    }

    //TODO: Create test case
    public LinkedList.Node insertBefore(LinkedList.Node n, int data) {
        LinkedList.Node n1 = new LinkedList.Node(data);
        if (n != null)
            n1.next = n;

        return n1;
    }

    //TODO: Create test case
    public LinkedList.Node lPadList(LinkedList.Node current, int size) {
        LinkedList.Node n = current;
        for (int i = 0; i < size; i++) {
            n = insertBefore(n, 0);
        }
        return n;
    }

    public LinkedList.Node getSumBackward(LinkedList l1, LinkedList l2) {

        int size1 = l1.getSize();
        int size2 = l2.getSize();

        if (size1 < size2) {
            l1.header.next = lPadList(l1.header.next, size2 - size1);
        }
        if (size1 > size2) {
            l2.header.next = lPadList(l2.header.next, size1 - size2);
        }

        Storage storage = addList(l1.header.next, l2.header.next);

        if (storage.carry != 0) {
            storage.result = insertBefore(storage.result, storage.carry);
        }
        return storage.result;
    }

    public Storage addList(LinkedList.Node n1, LinkedList.Node n2) {
        if (n1 == null && n2 == null) {
            Storage storage = new Storage();
            return storage;
        }

        Storage storage = addList(n1.next, n2.next);
        int value = storage.carry;
        value += n1.data;
        value += n2.data;

        storage.result = insertBefore(storage.result, value % 10);
        storage.carry = value / 10;

        return storage;
    }

    //Find intersection node of two different linked lists and return the node
    public LinkedList.Node getIntersection(LinkedList l1, LinkedList l2) {
        int size1 = l1.getSize();
        int size2 = l2.getSize();
        LinkedList.Node n1 = l1.header.next;
        LinkedList.Node n2 = l2.header.next;

        if (size1 < size2) {
            n2 = l2.getNode(size2 - size1 + 1);
        } else if (size1 > size2) {
            n1 = l1.getNode(size1 - size2 + 1);
        }

        while (n1 != null && n2 != null) {
            if (n1 == n2) {
                return n1;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return null;
    }

    public LinkedList.Node getIntersectionUsingRecursive(LinkedList l1, LinkedList l2){
        int size1 = l1.getSize();
        int size2 = l2.getSize();
        if(size1 < size2){
            l1.header.next = lPadList(l1.header.next, size2 - size1);
        }
        if(size1 > size2){
            l2.header.next = lPadList(l2.header.next, size1 - size2);
        }
        LinkedList.Node found = getIntersectionNode(l1.header.next, l2.header.next);
        return found;
    }

    public LinkedList.Node getIntersectionNode(LinkedList.Node n1, LinkedList.Node n2){
        if(n1 == null && n2 == null){
            return null;
        }
        LinkedList.Node n = getIntersectionNode(n1 == null? null : n1.next, n2 == null? null : n2.next);
        if(n1 != null && n2 != null && n1 == n2){
            return n1;
        }
        return n;
    }
}
