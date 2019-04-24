package com.minseungkwon.datastructure.Graph;

import java.util.ArrayList;
import java.util.LinkedList;

class Node<T> {
    T data;
    Node left;
    Node right;

    Node() {
    }

    Node(T data) {
        this.data = data;
    }
}

public class BinaryTree<T extends Comparable> {
    private Node root;
    private int size;

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
        this.size = array.length;
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

    public boolean isValidateBSTUsingInorder() {
        Integer[] arr = new Integer[size];
        Integer index = 0;
        isValidateBSTUsingInorder(root, arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    int index = 0;

    void isValidateBSTUsingInorder(Node root, Integer[] arr) {
        if (root == null) {
            return;
        }
        isValidateBSTUsingInorder(root.left, arr);
        arr[index] = (Integer) root.data;
        index++;
        isValidateBSTUsingInorder(root.right, arr);
    }

    public void addSize() {
        this.size++;
    }

    Integer previous = null;

    public boolean isValidateBSTWithoutArray() {
        return isValidateBSTWithoutArray(root);
    }

    boolean isValidateBSTWithoutArray(Node root) {
        if (root == null) {
            return true;
        }
        if (!isValidateBSTWithoutArray(root.left)) {
            return false;
        }
        if (previous != null && previous > (Integer) root.data) {
            return false;
        }
        previous = (Integer) root.data;
        if (!isValidateBSTWithoutArray(root.right)) {
            return false;
        }
        return true;
    }

    public boolean isValidateBSTWithMinMax() {
        return isValidateBSTWithMinMax(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean isValidateBSTWithMinMax(Node root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if ((Integer) root.data < min || (Integer) root.data > max) {
            return false;
        }
        if (!isValidateBSTWithMinMax(root.left, min, (Integer) root.data) || !isValidateBSTWithMinMax(root.right, (Integer) root.data, max)) {
            return false;
        }
        return true;

    //Compare max length of left and max length of right
    public boolean isBalancedUsingTwoRecursive() {
        return isBalancedUsingTwoRecursive(root);
    }

    boolean isBalancedUsingTwoRecursive(Node root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
            return false;
        }
        return isBalancedUsingTwoRecursive(root.left) && isBalancedUsingTwoRecursive(root.right);
    }

    int getHeight(Node root) {
        if (root == null) {
            return -1;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    //Compare max length of left and max length of right
    public boolean isBalancedUsingOneRecursive() {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    int checkHeight(Node root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE) {
            return leftHeight;
        }
        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE) {
            return rightHeight;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return Integer.MIN_VALUE;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    //Compare min length of tree and max length of tree
    public boolean isBalancedUsingObject() {
        Level result = new Level();
        isBalancedUsingObject(root, 0, result);
        return (Math.abs(result.max - result.min) > 1) ? false : true;
    }

    void isBalancedUsingObject(Node root, int level, Level result) {
        if (root == null) {
            if (level < result.min) {
                result.min = level;
            } else if (level > result.max) {
                result.max = level;
            }
            return;
        }
        isBalancedUsingObject(root.left, level + 1, result);
        isBalancedUsingObject(root.right, level + 1, result);
    }

    class Level {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
    }
}

