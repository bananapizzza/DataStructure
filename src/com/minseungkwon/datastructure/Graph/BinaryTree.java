package com.minseungkwon.datastructure.Graph;

import java.util.ArrayList;
import java.util.LinkedList;

class Node<T> {
    T data;
    Node left;
    Node right;
}

public class BinaryTree<T extends Comparable> {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node makeNode(Node left, T data, Node right) {
        Node n = new Node();
        n.data = data;
        n.left = left;
        n.right = right;
        return n;
    }

    public StringBuilder inorder(Node n, StringBuilder s) {
        if (n != null) {
            inorder(n.left, s);
            s.append(n.data);
            inorder(n.right, s);
        }
        return s;
    }

    public StringBuilder preoder(Node n, StringBuilder s) {
        if (n != null) {
            s.append(n.data);
            preoder(n.left, s);
            preoder(n.right, s);
        }
        return s;
    }

    public StringBuilder postorder(Node n, StringBuilder s) {
        if (n != null) {
            postorder(n.left, s);
            postorder(n.right, s);
            s.append(n.data);
        }
        return s;
    }

    public void makeTree(T[] array) {
        this.root = makeTreeR(array, 0, array.length - 1);
    }

    Node makeTreeR(T[] array, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node n = new Node();
        n.data = array[mid];
        n.left = makeTreeR(array, start, mid - 1);
        n.right = makeTreeR(array, mid + 1, end);
        return n;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        return preoder(this.root, s).toString();
    }

    public boolean searchBTree(T data) {
        return searchBTree(this.root, data);
    }

    boolean searchBTree(Node n, T find) {
        if (n == null) {
            return false;
        }
        if (find.compareTo(n.data) < 0) {
            return searchBTree(n.left, find);
        } else if (find.compareTo(n.data) > 0) {
            return searchBTree(n.right, find);
        } else {
            return true;
        }
    }

    public String BSTtoListRecursive() {
        ArrayList<LinkedList<Node>> result = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        char separator = '/';
        BSTtoListRecursive(result, root, 0);
        for (LinkedList<Node> ll : result) {
            for (Node n : ll) {
                s.append(n.data);
            }
            s.append(separator);
        }
        return s.toString();
    }

    ArrayList<LinkedList<Node>> BSTtoListRecursive(ArrayList<LinkedList<Node>> result, Node current, int level) {
        LinkedList<Node> list = null;
        if (current == null) {
            return null;
        }

        if (result.size() == level) {
            list = new LinkedList<>();
            result.add(list);
        } else {
            list = result.get(level);
        }
        list.add(current);
        BSTtoListRecursive(result, current.left, level + 1);
        BSTtoListRecursive(result, current.right, level + 1);
        return result;
    }

    public String BSTtoList() {
        ArrayList<LinkedList<Node>> result = new ArrayList<>();
        LinkedList<Node> current = new LinkedList<>();
        char separator = '/';
        if (root != null) {
            current.add(root);
        }

        while (current.size() > 0) {
            result.add(current);
            LinkedList<Node> parents = current;
            current = new LinkedList<>();
            for (Node parent : parents) {
                if (parent.left != null) {
                    current.add(parent.left);
                }
                if (parent.right != null) {
                    current.add(parent.right);
                }
            }
        }

        StringBuilder s = new StringBuilder();
        for (LinkedList<Node> ll : result) {
            for (Node n : ll) {
                s.append(n.data);
            }
            s.append(separator);
        }
        return s.toString();
    }
}

