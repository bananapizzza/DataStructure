class LinkedList {
    Node header;

    static class Node {
        int data;
        Node next = null;
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

    void retrieve() {
        Node n = header.next;
        while (n.next != null) {
            System.out.print(n.data + "->");
            n = n.next;
        }
        System.out.println(n.data);
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

    Node getFirst() {
        return header;
    }

    //Solution 1: Basic
  /*
  Node findKthNode(Node first, int k){
    Node n = first;
    int count = 0;
    while(n.next!=null){
      n = n.next;
      count++;
    }

    n = first;
    for(int i = 0; i < count - k + 1; i++){
      n = n.next;
    }
    return n;
  }
  */

    //Solution 2: Using recursive function
  /*
  static class Reference{
    public int count = 0;
  }
  Node findKthNode(Node n, int k, Reference r){
    if(n == null)
      return null;
    Node found = findKthNode(n.next, k, r);
    r.count++;
    if(r.count == k){
      return n;
    }
    return found;
  }
  */

    //Solution 3: Using pointer
    Node findKthNode(Node first, int k) {
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

    boolean deleteNode(Node n) {
        if (n == null || n.next == null)
            return false;
        Node next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }

    Node getNode(int k) {
        Node n = header;
        for (int i = 0; i < k; i++) {
            n = n.next;
        }
        return n;
    }
}

public class LinkedListNode {
    public static void main(String[] args) {
        int k = 1;
        LinkedList ll = new LinkedList();
        LinkedList.Node found;
        //LinkedList.Reference r = new LinkedList.Reference();
        //ll.append(1);
        //ll.append(2);
        //ll.append(3);
        //ll.append(4);
        //ll.append(5);
        //ll.retrieve();
        //found = ll.findKthNode(ll.getFirst(), k, r);
        //found = ll.findKthNode(ll.getFirst(), k);
        //System.out.println(found.data);
        //ll.deleteNode(ll.getNode(k));
        //ll.retrieve();
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        l1.append(9);
        l1.append(1);
        l1.append(4);
        l1.retrieve();
        l2.append(6);
        l2.append(4);
        l2.append(3);
        l2.retrieve();
        LinkedListNode linkedListNode = new LinkedListNode();
        LinkedList l3 = linkedListNode.getSum(l1, l2);
        l3.retrieve();
    }

    private LinkedList getSum(LinkedList l1, LinkedList l2) {
        int carry = 0;
        LinkedList l3 = new LinkedList();
        LinkedList.Node n1 = l1.header.next;
        LinkedList.Node n2 = l2.header.next;
        while (n1 != null && n2 != null) {
            int result = carry;
            carry = 0;
            if (n1 != null)
                result += n1.data;
            if (n2 != null)
                result += n2.data;
            if (result >= 10) {
                carry = result / 10;
                result = result % 10;
            }
            l3.append(result);
            n1 = n1.next;
            n2 = n2.next;
        }
        return l3;
    }
}
