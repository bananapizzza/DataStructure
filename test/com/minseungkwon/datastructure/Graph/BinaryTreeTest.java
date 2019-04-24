package com.minseungkwon.datastructure.Graph;

import org.junit.Test;

import static org.junit.Assert.*;


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
    public void test_isValidateBSTUsingInorderTrueCase() {
        Integer[] arr = new Integer[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);

        assertTrue(bt.isValidateBSTUsingInorder());
    }

    @Test
    public void test_isValidateBSTUsingInorderFalseCase() {
        Integer[] arr = new Integer[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);
        bt.getRoot().right.right.right.left = new Node(10);
        bt.addSize();

        assertFalse(bt.isValidateBSTUsingInorder());
    }

    @Test
    public void test_isValidateBSTWithoutArrayTrueCase() {
        Integer[] arr = new Integer[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);

        assertTrue(bt.isValidateBSTWithoutArray());
    }

    @Test
    public void test_isValidateBSTWithoutArrayFalseCase() {
        Integer[] arr = new Integer[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);
        bt.getRoot().right.right.right.left = new Node(10);
        bt.addSize();

        assertFalse(bt.isValidateBSTWithoutArray());
    }

    @Test
    public void test_isValidateBSTWithMinMaxTrueCase() {
        Integer[] arr = new Integer[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);

        assertTrue(bt.isValidateBSTWithMinMax());
    }

    @Test
    public void test_isValidateBSTWithMinMaxFalseCase() {
        Integer[] arr = new Integer[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);
        bt.getRoot().right.right.right.left = new Node(10);
        bt.addSize();

        assertFalse(bt.isValidateBSTWithMinMax());
    }
}