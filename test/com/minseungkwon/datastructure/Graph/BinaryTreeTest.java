package com.minseungkwon.datastructure.Graph;

import org.junit.Test;

import static org.junit.Assert.*;


public class BinaryTreeTest {
    public Integer[] makeArrayForTree() {
        Integer[] arr = new Integer[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        return arr;
    }

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
        Integer[] arr = makeArrayForTree();
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);
        assertEquals("4102375689", bt.toString());
    }

    @Test
    public void test_searchBTreeWithExistentData() {
        Integer[] arr = makeArrayForTree();
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);
        assertEquals(true, bt.searchBTree(2));
    }

    @Test
    public void test_searchBTreeWithoutExistentData() {
        Integer[] arr = makeArrayForTree();
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);
        assertFalse(bt.searchBTree(12));
    }

    @Test
    public void test_BSTtoListRecursive() {
        Integer[] arr = makeArrayForTree();
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);

        assertEquals("4/17/0258/369/", bt.BSTtoListRecursive());
    }

    @Test
    public void test_BSTtoList() {
        Integer[] arr = makeArrayForTree();
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);

        assertEquals("4/17/0258/369/", bt.BSTtoList());
    }

    @Test
    public void test_isValidateBSTUsingInorderTrueCase() {
        Integer[] arr = makeArrayForTree();
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);

        assertTrue(bt.isValidateBSTUsingInorder());
    }

    @Test
    public void test_isValidateBSTUsingInorderFalseCase() {
        Integer[] arr = makeArrayForTree();
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);
        bt.getRoot().right.right.right.left = new Node(10);
        bt.addSize();

        assertFalse(bt.isValidateBSTUsingInorder());
    }

    @Test
    public void test_isValidateBSTWithoutArrayTrueCase() {
        Integer[] arr = makeArrayForTree();
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);

        assertTrue(bt.isValidateBSTWithoutArray());
    }

    @Test
    public void test_isValidateBSTWithoutArrayFalseCase() {
        Integer[] arr = makeArrayForTree();
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);
        bt.getRoot().right.right.right.left = new Node(10);
        bt.addSize();

        assertFalse(bt.isValidateBSTWithoutArray());
    }

    @Test
    public void test_isValidateBSTWithMinMaxTrueCase() {
        Integer[] arr = makeArrayForTree();
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);

        assertTrue(bt.isValidateBSTWithMinMax());
    }

    @Test
    public void test_isValidateBSTWithMinMaxFalseCase() {
        Integer[] arr = makeArrayForTree();
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);
        bt.getRoot().right.right.right.left = new Node(10);
        bt.addSize();

        assertFalse(bt.isValidateBSTWithMinMax());
    }

    @Test
    public void test_isBalancedUsingTwoRecursiveTrueCase1() {
        Integer[] arr = makeArrayForTree();
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);
        bt.getRoot().right.right.right.right = new Node(10);
        bt.getRoot().right.right.left = new Node(11);

        assertTrue(bt.isBalancedUsingTwoRecursive());
    }

    @Test
    public void test_isBalancedUsingTwoRecursiveTrueCase2() {
        Integer[] arr = makeArrayForTree();
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);

        assertTrue(bt.isBalancedUsingTwoRecursive());
    }

    @Test
    public void test_isBalancedUsingTwoRecursiveFalseCase() {
        Integer[] arr = makeArrayForTree();
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);
        bt.getRoot().right.right.right.right = new Node(10);

        assertFalse(bt.isBalancedUsingTwoRecursive());
    }

    @Test
    public void test_isBalancedUsingOneRecursiveTrueCase1() {
        Integer[] arr = makeArrayForTree();
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);

        assertTrue(bt.isBalancedUsingOneRecursive());
    }

    @Test
    public void test_isBalancedUsingOneRecursiveTrueCase2() {
        Integer[] arr = makeArrayForTree();
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);
        bt.getRoot().right.right.right.right = new Node(10);
        bt.getRoot().right.right.left = new Node(11);

        assertTrue(bt.isBalancedUsingOneRecursive());
    }

    @Test
    public void test_isBalancedUsingOneRecursiveFalseCase() {
        Integer[] arr = makeArrayForTree();
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);
        bt.getRoot().right.right.right.right = new Node(10);

        assertFalse(bt.isBalancedUsingOneRecursive());
    }

    @Test
    public void test_isBalancedUsingObjectTrueCase() {
        Integer[] arr = makeArrayForTree();
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);

        assertTrue(bt.isBalancedUsingObject());
    }

    @Test
    public void test_isBalancedUsingObjectFalseCase() {
        Integer[] arr = makeArrayForTree();
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);
        bt.getRoot().right.right.right.right = new Node(10);
        bt.getRoot().right.right.left = new Node(11);

        assertFalse(bt.isBalancedUsingObject());
    }

    @Test
    public void test_findNext() {
        Integer[] arr = makeArrayForTree();
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);

        Node next = bt.getNode(0);

        for (int i = 1; i < arr.length; i++) {
            next = bt.findNext(next);
            assertEquals(i, next.data);
        }
    }

    @Test
    public void test_findCommonAncestorUsingDepth() {
        Integer[] arr = makeArrayForTree();
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);

        assertEquals(1, bt.findCommonAncestorUsingDepth(0, 3).data);
        assertEquals(4, bt.findCommonAncestorUsingDepth(2, 8).data);
        assertEquals(4, bt.findCommonAncestorUsingDepth(4, 5).data);
        assertEquals(7, bt.findCommonAncestorUsingDepth(6, 9).data);
        assertEquals(7, bt.findCommonAncestorUsingDepth(7, 9).data);
        assertEquals(null, bt.findCommonAncestorUsingDepth(7, 11));
    }

    @Test
    public void test_findCommonAncestorUsingSibling() {
        Integer[] arr = makeArrayForTree();
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);

        assertEquals(1, bt.findCommonAncestorUsingSibling(0, 3).data);
        assertEquals(4, bt.findCommonAncestorUsingSibling(2, 8).data);
        assertEquals(4, bt.findCommonAncestorUsingSibling(4, 5).data);
        assertEquals(7, bt.findCommonAncestorUsingSibling(6, 9).data);
        assertEquals(7, bt.findCommonAncestorUsingSibling(7, 9).data);
        assertEquals(null, bt.findCommonAncestorUsingSibling(7, 11));
    }

    @Test
    public void test_findCommonAncestorWithoutParent() {
        Integer[] arr = makeArrayForTree();
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);

        assertEquals(1, bt.findCommonAncestorWithParent(0, 3).data);
        assertEquals(4, bt.findCommonAncestorWithParent(2, 8).data);
        assertEquals(4, bt.findCommonAncestorWithParent(4, 5).data);
        assertEquals(7, bt.findCommonAncestorWithParent(6, 9).data);
        assertEquals(7, bt.findCommonAncestorWithParent(7, 9).data);
        assertEquals(null, bt.findCommonAncestorWithParent(7, 11));
    }

    @Test
    public void test_findCommonAncestorUsingPostOrder() {
        Integer[] arr = makeArrayForTree();
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);

        assertEquals(1, bt.findCommonAncestorUsingPostOrder(0, 3).data);
        assertEquals(4, bt.findCommonAncestorUsingPostOrder(2, 8).data);
        assertEquals(4, bt.findCommonAncestorUsingPostOrder(4, 5).data);
        assertEquals(7, bt.findCommonAncestorUsingPostOrder(6, 9).data);
        assertEquals(7, bt.findCommonAncestorUsingPostOrder(7, 9).data);
        assertEquals(null, bt.findCommonAncestorUsingPostOrder(7, 11));
    }
}