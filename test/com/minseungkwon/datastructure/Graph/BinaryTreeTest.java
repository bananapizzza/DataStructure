package com.minseungkwon.datastructure.Graph;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class BinaryTreeTest {
    @Test
    public void test_inorder() {
        BinaryTree<Integer> bt = new BinaryTree();
        Node n4 = bt.makeNode(null, 4, null);
        Node n5 = bt.makeNode(null, 5, null);
        Node n2 = bt.makeNode(n4, 2, n5);
        Node n3 = bt.makeNode(null, 3, null);
        Node n1 = bt.makeNode(n2, 1, n3);
        bt.setRoot(n1);

        StringBuilder expected = new StringBuilder();
        expected.append("42513");
        StringBuilder actual = new StringBuilder();
        bt.inorder(bt.getRoot(), actual);

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void test_preorder() {
        BinaryTree<Integer> bt = new BinaryTree();
        Node n4 = bt.makeNode(null, 4, null);
        Node n5 = bt.makeNode(null, 5, null);
        Node n2 = bt.makeNode(n4, 2, n5);
        Node n3 = bt.makeNode(null, 3, null);
        Node n1 = bt.makeNode(n2, 1, n3);
        bt.setRoot(n1);

        StringBuilder expected = new StringBuilder();
        expected.append("12453");
        StringBuilder actual = new StringBuilder();
        bt.preoder(bt.getRoot(), actual);

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void test_postorder() {
        BinaryTree<Integer> bt = new BinaryTree();
        Node n4 = bt.makeNode(null, 4, null);
        Node n5 = bt.makeNode(null, 5, null);
        Node n2 = bt.makeNode(n4, 2, n5);
        Node n3 = bt.makeNode(null, 3, null);
        Node n1 = bt.makeNode(n2, 1, n3);
        bt.setRoot(n1);

        StringBuilder expected = new StringBuilder();
        expected.append("45231");
        StringBuilder actual = new StringBuilder();
        bt.postorder(bt.getRoot(), actual);

        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void test_makeTree() {
        Integer[] arr = new Integer[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);
        assertEquals("4102375689", bt.toString());
    }

    @Test
    public void test_searchBTreeWithExistentData() {
        Integer[] arr = new Integer[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);
        assertEquals(true, bt.searchBTree(2));
    }

    @Test
    public void test_searchBTreeWithoutExistentData() {
        Integer[] arr = new Integer[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);
        assertEquals(false, bt.searchBTree(12));
    }

    @Test
    public void test_BSTtoListRecursive() {
        Integer[] arr = new Integer[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);

        assertEquals("4/17/0258/369/", bt.BSTtoListRecursive());
    }

    @Test
    public void test_BSTtoList() {
        Integer[] arr = new Integer[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);

        assertEquals("4/17/0258/369/", bt.BSTtoList());
    }

    @Test
    public void test_isBalancedUsingTwoRecursiveTrueCase() {
        Integer[] arr = new Integer[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);

        assertEquals(true, bt.isBalancedUsingTwoRecursive());
    }

    @Test
    public void test_isBalancedUsingTwoRecursiveFalseCase() {
        Integer[] arr = new Integer[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);
        bt.getRoot().right.right.right.right = new Node(10);

        assertEquals(false, bt.isBalancedUsingTwoRecursive());
    }

    @Test
    public void test_isBalancedUsingOneRecursiveTrueCase() {
        Integer[] arr = new Integer[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);

        assertEquals(true, bt.isBalancedUsingOneRecursive());
    }

    @Test
    public void test_isBalancedUsingOneRecursiveFalseCase() {
        Integer[] arr = new Integer[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);
        bt.getRoot().right.right.right.right = new Node(10);

        assertEquals(false, bt.isBalancedUsingOneRecursive());
    }

    @Test
    public void test_isBalancedUsingObjectTrueCase() {
        Integer[] arr = new Integer[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);

        assertEquals(true, bt.isBalancedUsingObject());
    }

    @Test
    public void test_isBalancedUsingObjectFalseCase() {
        Integer[] arr = new Integer[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);
        bt.getRoot().right.right.right.right = new Node(10);
        bt.getRoot().right.right.left = new Node(11);

        assertEquals(false, bt.isBalancedUsingObject());
    }
}