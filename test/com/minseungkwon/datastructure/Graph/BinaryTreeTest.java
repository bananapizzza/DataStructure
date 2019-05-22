package com.minseungkwon.datastructure.Graph;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.Assert.*;


public class BinaryTreeTest {
    public Integer[] makeArrayForTree() {
        Integer[] arr = new Integer[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public Integer[] makeArrayForTree(int size) {
        Integer[] arr = new Integer[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public Integer[] makeArrayForTree(int start, int end) {
        Integer[] arr = new Integer[end - start + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = start++;
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
        Integer[] arr = makeArrayForTree(10);
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);
        assertEquals("4102375689", bt.toString());
    }

    @Test
    public void test_searchBTreeWithExistentData() {
        Integer[] arr = makeArrayForTree(10);
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);
        assertEquals(true, bt.searchBTree(2));
    }

    @Test
    public void test_searchBTreeWithoutExistentData() {
        Integer[] arr = makeArrayForTree(10);
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);
        assertFalse(bt.searchBTree(12));
    }

    @Test
    public void test_BSTtoListRecursive() {
        Integer[] arr = makeArrayForTree(10);
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);

        assertEquals("4/17/0258/369/", bt.BSTtoListRecursive());
    }

    @Test
    public void test_BSTtoList() {
        Integer[] arr = makeArrayForTree(10);
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);

        assertEquals("4/17/0258/369/", bt.BSTtoList());
    }

    @Test
    public void test_isValidateBSTUsingInorderTrueCase() {
        Integer[] arr = makeArrayForTree(10);
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);

        assertTrue(bt.isValidateBSTUsingInorder());
    }

    @Test
    public void test_isValidateBSTUsingInorderFalseCase() {
        Integer[] arr = makeArrayForTree(10);
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);
        bt.getRoot().right.right.right.left = new Node(10);
        bt.addSize();

        assertFalse(bt.isValidateBSTUsingInorder());
    }

    @Test
    public void test_isValidateBSTWithoutArrayTrueCase() {
        Integer[] arr = makeArrayForTree(10);
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);

        assertTrue(bt.isValidateBSTWithoutArray());
    }

    @Test
    public void test_isValidateBSTWithoutArrayFalseCase() {
        Integer[] arr = makeArrayForTree(10);
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);
        bt.getRoot().right.right.right.left = new Node(10);
        bt.addSize();

        assertFalse(bt.isValidateBSTWithoutArray());
    }

    @Test
    public void test_isValidateBSTWithMinMaxTrueCase() {
        Integer[] arr = makeArrayForTree(10);
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);

        assertTrue(bt.isValidateBSTWithMinMax());
    }

    @Test
    public void test_isValidateBSTWithMinMaxFalseCase() {
        Integer[] arr = makeArrayForTree(10);
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);
        bt.getRoot().right.right.right.left = new Node(10);
        bt.addSize();

        assertFalse(bt.isValidateBSTWithMinMax());
    }

    @Test
    public void test_isBalancedUsingTwoRecursiveTrueCase1() {
        Integer[] arr = makeArrayForTree(10);
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);
        bt.getRoot().right.right.right.right = new Node(10);
        bt.getRoot().right.right.left = new Node(11);

        assertTrue(bt.isBalancedUsingTwoRecursive());
    }

    @Test
    public void test_isBalancedUsingTwoRecursiveTrueCase2() {
        Integer[] arr = makeArrayForTree(10);
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);

        assertTrue(bt.isBalancedUsingTwoRecursive());
    }

    @Test
    public void test_isBalancedUsingTwoRecursiveFalseCase() {
        Integer[] arr = makeArrayForTree(10);
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);
        bt.getRoot().right.right.right.right = new Node(10);

        assertFalse(bt.isBalancedUsingTwoRecursive());
    }

    @Test
    public void test_isBalancedUsingOneRecursiveTrueCase1() {
        Integer[] arr = makeArrayForTree(10);
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);

        assertTrue(bt.isBalancedUsingOneRecursive());
    }

    @Test
    public void test_isBalancedUsingOneRecursiveTrueCase2() {
        Integer[] arr = makeArrayForTree(10);
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);
        bt.getRoot().right.right.right.right = new Node(10);
        bt.getRoot().right.right.left = new Node(11);

        assertTrue(bt.isBalancedUsingOneRecursive());
    }

    @Test
    public void test_isBalancedUsingOneRecursiveFalseCase() {
        Integer[] arr = makeArrayForTree(10);
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);
        bt.getRoot().right.right.right.right = new Node(10);

        assertFalse(bt.isBalancedUsingOneRecursive());
    }

    @Test
    public void test_isBalancedUsingObjectTrueCase() {
        Integer[] arr = makeArrayForTree(10);
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);

        assertTrue(bt.isBalancedUsingObject());
    }

    @Test
    public void test_isBalancedUsingObjectFalseCase() {
        Integer[] arr = makeArrayForTree(10);
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);
        bt.getRoot().right.right.right.right = new Node(10);
        bt.getRoot().right.right.left = new Node(11);

        assertFalse(bt.isBalancedUsingObject());
    }

    @Test
    public void test_findNext() {
        Integer[] arr = makeArrayForTree(10);
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
        Integer[] arr = makeArrayForTree(10);
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
        Integer[] arr = makeArrayForTree(10);
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
        Integer[] arr = makeArrayForTree(10);
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
        Integer[] arr = makeArrayForTree(10);
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);

        assertEquals(1, bt.findCommonAncestorUsingPostOrder(0, 3).data);
        assertEquals(4, bt.findCommonAncestorUsingPostOrder(2, 8).data);
        assertEquals(4, bt.findCommonAncestorUsingPostOrder(4, 5).data);
        assertEquals(7, bt.findCommonAncestorUsingPostOrder(6, 9).data);
        assertEquals(7, bt.findCommonAncestorUsingPostOrder(7, 9).data);
        assertEquals(null, bt.findCommonAncestorUsingPostOrder(7, 11));
    }

    @Test
    public void test_findAllCombination() {
        Integer[] arr = makeArrayForTree(5);
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);
        ArrayList<LinkedList<Node>> result = bt.findAllCombination(bt.getRoot());
        StringBuilder s = new StringBuilder();
        for (LinkedList<Node> ll : result) {
            for (Node n : ll) {
                s.append(n.data);
            }
            s.append(" ");
        }
        assertEquals("20134 20314 20341 23014 23041 23401 ", s.toString());
    }

    @Test
    public void test_findAllCombination2() {
        Integer[] arr = makeArrayForTree(5);
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);
        ArrayList<LinkedList<Node>> results = bt.findAllCombination2(bt.getRoot());
        LinkedList<String> expected = new LinkedList<>();
        expected.add("20134");
        expected.add("20314");
        expected.add("20341");
        expected.add("23014");
        expected.add("23041");
        expected.add("23401");
        int index = 0;

        for (LinkedList<Node> ll : results) {
            StringBuilder s = new StringBuilder();
            for (Node n : ll) {
                s.append(n.data);
            }
            assertEquals(expected.get(index), s.toString());
            index++;
        }
    }

    @Test
    public void test_weaveList2() {
        Integer[] arr = makeArrayForTree(5);
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);

        LinkedList<Node> left = new LinkedList<>();
        left.add(new Node(0));
        left.add(new Node(1));
        LinkedList<Node> right = new LinkedList<>();
        right.add(new Node(3));
        right.add(new Node(4));
        ArrayList<LinkedList<Node>> results = new ArrayList<>();
        LinkedList<Node> prefix = new LinkedList<>();
        prefix.add(new Node(2));

        bt.weaveList2(left, right, results, prefix);

        LinkedList<String> expected = new LinkedList<>();
        expected.add("20134");
        expected.add("20314");
        expected.add("20341");
        expected.add("23014");
        expected.add("23041");
        expected.add("23401");
        int index = 0;

        for (LinkedList<Node> ll : results) {
            StringBuilder s = new StringBuilder();
            for (Node n : ll) {
                s.append(n.data);
            }
            assertEquals(expected.get(index), s.toString());
            index++;
        }
    }

    @Test
    public void test_containSubtreeTrueCase() {
        Integer[] arr = makeArrayForTree(10);
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);

        Integer[] arr2 = makeArrayForTree(5, 9);
        BinaryTree<Integer> bt2 = new BinaryTree<>();
        bt2.makeTree(arr2);

        assertTrue(bt.containSubtree(bt2));
    }

    @Test
    public void test_containSubtreeFalseCase() {
        Integer[] arr = makeArrayForTree(10);
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);

        Integer[] arr2 = makeArrayForTree(7, 9);
        BinaryTree<Integer> bt2 = new BinaryTree<>();
        bt2.makeTree(arr2);

        assertFalse(bt.containSubtree(bt2));
    }

    @Test
    public void test_countPathWithSumUsingTwoRecursive() {
        Integer[] arr = makeArrayForTree(10);
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);

        assertEquals(2, bt.countPathWithSumUsingTwoRecursive(3));
        assertEquals(4, bt.countPathWithSumUsingTwoRecursive(5));
    }

    @Test
    public void test_countPathWithSumUsingArray() {
        Integer[] arr = makeArrayForTree(10);
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);

        assertEquals(2, bt.countPathWithSumUsingArray(3));
        assertEquals(4, bt.countPathWithSumUsingArray(5));
    }

    @Test
    public void test_countPathWithSumUsingHashMap() {
        Integer[] arr = makeArrayForTree(10);
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.makeTree(arr);

        assertEquals(2, bt.countPathWithSumUsingHashMap(3));
        assertEquals(4, bt.countPathWithSumUsingHashMap(5));
    }

    @Test
    public void test_buildTreeByInPre() {
        int[] pre = {4, 2, 1, 3, 6, 5, 7};
        int[] in = {1, 2, 3, 4, 5, 6, 7};
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.buildTreeByInPre(in, pre);

        assertEquals("4213657", bt.toString());
    }

    @Test
    public void test_buildTreeByInPost() {
        int[] in = {1, 2, 3, 4, 5, 6, 7};
        int[] post = {1, 3, 2, 5, 7, 6, 4};
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.buildTreeByInPost(in, post);

        assertEquals("4213657", bt.toString());
    }
}