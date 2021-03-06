package com.minseungkwon.datastructure.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

class Node<T> {
    T data;
    Node left;
    Node right;
    Node parent;


    Node() {
    }

    Node(T data) {
        this.data = data;
    }
}

public class BinaryTree<T extends Comparable> {
    private Node root;
    private int size;
    private HashMap<Integer, Node> rootMap;

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
        this.rootMap = new HashMap<>();
        this.root = makeTreeR(array, 0, array.length - 1, null);
        this.size = array.length;
    }

    Node makeTreeR(T[] array, int start, int end, Node parent) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node n = new Node();
        n.data = array[mid];
        n.parent = parent;
        n.left = makeTreeR(array, start, mid - 1, n);
        n.right = makeTreeR(array, mid + 1, end, n);
        rootMap.put((Integer) n.data, n);
        return n;
    }

    public Node getNode(Integer i) {
        return rootMap.get(i);
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
    }

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

    public Node findNext(Node node) {
        if (node == null) {
            return null;
        }
        if (node.right == null) {
            return findAbove(node.parent, node);
        } else {
            return findBelow(node.right);
        }
    }

    Node findAbove(Node root, Node child) {
        if (root == null) {
            return null;
        }
        if (child == root.left) {
            return root;
        }
        return findAbove(root.parent, root);
    }

    Node findBelow(Node root) {
        if (root.left == null) {
            return root;
        }
        return findBelow(root.left);
    }

    public Node findCommonAncestorUsingDepth(int d1, int d2) {
        Node n1 = getNode(d1);
        Node n2 = getNode(d2);
        int depth1 = findDepth(n1);
        int depth2 = findDepth(n2);

        if (depth1 > depth2) {
            n1 = goUpward(n1, depth1 - depth2);
        }
        if (depth2 > depth1) {
            n2 = goUpward(n2, depth2 - depth1);
        }
        while (n1 != n2 && n1 != null && n2 != null) {
            n1 = n1.parent;
            n2 = n2.parent;
        }
        return n1 == null || n2 == null ? null : n1;
    }

    int findDepth(Node n) {
        int depth = 0;
        while (n != null) {
            n = n.parent;
            depth++;
        }
        return depth;
    }

    Node goUpward(Node n, int depth) {
        for (int i = 0; i < depth; i++) {
            n = n.parent;
        }
        return n;
    }

    public Node findCommonAncestorUsingSibling(int d1, int d2) {
        Node n1 = getNode(d1);
        Node n2 = getNode(d2);
        if (!covers(root, n1) || !covers(root, n2)) {
            return null;
        } else if (covers(n1, n2)) {
            return n1;
        } else if (covers(n2, n1)) {
            return n2;
        }
        Node sibling = getSibling(n1);
        Node parent = n1.parent;
        while (!covers(sibling, n2)) {
            sibling = getSibling(parent);
            parent = parent.parent;
        }
        return parent;
    }

    Node getSibling(Node n) {
        if (n == null || n.parent == null) {
            return null;
        }
        Node parent = n.parent;
        return parent.left == n ? parent.right : parent.left;
    }

    boolean covers(Node root, Node find) {
        if (root == null) {
            return false;
        }
        if (root == find) {
            return true;
        }
        return covers(root.left, find) || covers(root.right, find);
    }

    public Node findCommonAncestorWithParent(int d1, int d2) {
        Node n1 = getNode(d1);
        Node n2 = getNode(d2);
        if (!covers(root, n1) || !covers(root, n2)) {
            return null;
        }
        return ancestorHelper(root, n1, n2);
    }

    Node ancestorHelper(Node root, Node n1, Node n2) {
        if (root == null || root == n1 || root == n2) {
            return root;
        }

        boolean nodeOneInLeft = covers(root.left, n1);
        boolean nodeTwoInLeft = covers(root.left, n2);
        if (nodeOneInLeft != nodeTwoInLeft) {
            return root;
        }
        return nodeOneInLeft ? ancestorHelper(root.left, n1, n2) : ancestorHelper(root.right, n1, n2);
    }

    class Result {
        Node node;
        boolean foundAncestor;

        Result(Node n, boolean found) {
            node = n;
            foundAncestor = found;
        }
    }

    public Node findCommonAncestorUsingPostOrder(int d1, int d2) {
        Node n1 = getNode(d1);
        Node n2 = getNode(d2);

        Result r = findCommonAncestorUsingPostOrder(root, n1, n2);
        if (r.foundAncestor) {
            return r.node;
        }
        return null;
    }

    Result findCommonAncestorUsingPostOrder(Node root, Node n1, Node n2) {
        if (root == null) {
            return new Result(null, false);
        }
        if (root == n1 && root == n2) {
            return new Result(n1, true);
        }
        Result rLeft = findCommonAncestorUsingPostOrder(root.left, n1, n2);
        if (rLeft.foundAncestor) {
            return rLeft;
        }
        Result rRight = findCommonAncestorUsingPostOrder(root.right, n1, n2);
        if (rRight.foundAncestor) {
            return rRight;
        }
        if (rLeft.node != null && rRight.node != null) {
            return new Result(root, true);
        } else if (root == n1 || root == n2) {
            boolean isAncestor = rLeft.node != null || rRight.node != null;
            return new Result(root, isAncestor);
        } else {
            return new Result(rLeft.node != null ? rLeft.node : rRight.node, false);
        }
    }

    public ArrayList<LinkedList<Node>> findAllCombination(Node root) {
        ArrayList<LinkedList<Node>> results = new ArrayList<>();
        if (root == null) {
            results.add(new LinkedList<>());
            return results;
        }
        LinkedList<Node> prefix = new LinkedList<>();
        prefix.add(root);
        ArrayList<LinkedList<Node>> leftSeq = findAllCombination(root.left);
        ArrayList<LinkedList<Node>> rightSeq = findAllCombination(root.right);

        for (LinkedList<Node> left : leftSeq) {
            for (LinkedList<Node> right : rightSeq) {
                ArrayList<LinkedList<Node>> weaved = new ArrayList<>();
                weaveLists(left, right, weaved, prefix);
                results.addAll(weaved);
            }
        }
        return results;
    }

    void weaveLists(LinkedList<Node> left, LinkedList<Node> right, ArrayList<LinkedList<Node>> weaved, LinkedList<Node> prefix) {
        if (left.size() == 0 || right.size() == 0) {
            LinkedList<Node> result = new LinkedList<>();
            for (Node n : prefix) {
                result.add(n);
            }
            result.addAll(left);
            result.addAll(right);
            weaved.add(result);
            return;
        }
        Node headLeft = left.removeFirst();
        prefix.addLast(headLeft);
        weaveLists(left, right, weaved, prefix);
        prefix.removeLast();
        left.addFirst(headLeft);

        Node headRight = right.removeFirst();
        prefix.addLast(headRight);
        weaveLists(left, right, weaved, prefix);
        prefix.removeLast();
        right.addFirst(headRight);
    }

    public ArrayList<LinkedList<Node>> findAllCombination2(Node root) {
        ArrayList<LinkedList<Node>> results = new ArrayList<>();
        if (root == null) {
            LinkedList<Node> result = new LinkedList<>();
            results.add(result);
            return results;
        }
        LinkedList<Node> prefix = new LinkedList<>();
        prefix.add(root);
        ArrayList<LinkedList<Node>> leftSeq = findAllCombination2(root.left);
        ArrayList<LinkedList<Node>> rightSeq = findAllCombination2(root.right);
        for (LinkedList<Node> left : leftSeq) {
            for (LinkedList<Node> right : rightSeq) {
                weaveList2(left, right, results, prefix);
            }
        }
        return results;
    }

    void weaveList2(LinkedList<Node> left, LinkedList<Node> right, ArrayList<LinkedList<Node>> results, LinkedList<Node> prefix) {
        if (left.size() == 0 || right.size() == 0) {
            LinkedList<Node> result = new LinkedList<>();

            result.addAll(prefix);
            result.addAll(left);
            result.addAll(right);
            results.add(result);
            return;
        }
        Node leftNode = left.removeFirst();
        prefix.add(leftNode);
        weaveList2(left, right, results, prefix);
        prefix.removeLast();
        left.addFirst(leftNode);

        Node rightNode = right.removeFirst();
        prefix.add(rightNode);
        weaveList2(left, right, results, prefix);
        prefix.removeLast();
        right.addFirst(rightNode);
    }

    public boolean containSubtree(BinaryTree t) {
        if (this.root == null) {
            return false;
        }
        if (t == null) {
            return true;
        }
        return findSubtree(this.root, t.getRoot());
    }

    boolean findSubtree(Node t1, Node t2) {
        if (t1 == null) {
            return false;
        }
        if (t1.data == t2.data && matchTree(t1, t2)) {
            return true;
        }
        return findSubtree(t1.left, t2) || findSubtree(t1.right, t2);
    }

    boolean matchTree(Node t1, Node t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2 == null) {
            return false;
        } else if (t1.data != t2.data) {
            return false;
        }
        return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
    }

    public int countPathWithSumUsingTwoRecursive(int targetSum) {
        if (this.root == null) {
            return 0;
        }
        return countPathWithSumUsingTwoRecursive(root, targetSum);
    }

    int countPathWithSumUsingTwoRecursive(Node root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int countPath = countPathWithSumFromNode(root, targetSum, 0);
        countPath += countPathWithSumUsingTwoRecursive(root.left, targetSum);
        countPath += countPathWithSumUsingTwoRecursive(root.right, targetSum);
        return countPath;
    }

    int countPathWithSumFromNode(Node root, int targetSum, int curSum) {
        if (root == null) {
            return 0;
        }
        curSum += (int) root.data;
        int countPath = 0;
        if (curSum == targetSum) {
            countPath++;
        }
        countPath += countPathWithSumFromNode(root.left, targetSum, curSum);
        countPath += countPathWithSumFromNode(root.right, targetSum, curSum);
        return countPath;
    }

    public int countPathWithSumUsingArray(int targetSum) {
        if (this.root == null) {
            return 0;
        }
        ArrayList<Integer> array = new ArrayList<>();
        return countPathWithSumUsingArray(root, targetSum, array);
    }

    int countPathWithSumUsingArray(Node root, int targetSum, ArrayList<Integer> array) {
        if (this.root == null) {
            return 0;
        }
        addDataToArray(array, (int) root.data);
        int countPath = searchDataFromArray(array, targetSum);
        countPath += countPathWithSumUsingArray(root.left, targetSum, array);
        countPath += countPathWithSumUsingArray(root.right, targetSum, array);
        removeDataFromArray(array);
        return countPath;
    }

    void addDataToArray(ArrayList<Integer> array, int data) {
        for (int i = 0; i < array.size(); i++) {
            array.set(i, array.get(i) + data);
        }
        array.add(data);
    }

    int searchDataFromArray(ArrayList<Integer> array, int targetSum) {
        int count = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == targetSum) {
                count++;
            }
        }
        return count;
    }

    void removeDataFromArray(ArrayList<Integer> array) {
        int data = array.remove(array.size() - 1);
        for (int i = 0; i < array.size(); i++) {
            array.set(i, array.get(i) - data);
        }
    }

    public int countPathWithSumUsingHashMap(int targetSum) {
        if (this.root == null) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return countPathWithSumUsingHashMap(root, targetSum, 0, map);
    }

    int countPathWithSumUsingHashMap(Node root, int targetSum, int curSum, HashMap<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        curSum += (int) root.data;
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        int countPath = map.getOrDefault(curSum - targetSum, 0);
        countPath += countPathWithSumUsingHashMap(root.left, targetSum, curSum, map);
        countPath += countPathWithSumUsingHashMap(root.right, targetSum, curSum, map);
        map.put(curSum, map.get(curSum) - 1);
        if (map.get(curSum) == 0) {
            map.remove(curSum);
        }
        return countPath;
    }


    public void buildTreeByInPre(int[] in, int[] pre) {
        root = buildTreeByInPre(in, pre, 0, pre.length - 1, 0, in.length - 1);
    }

    private Node buildTreeByInPre(int[] in, int[] pre, int preStart, int preEnd, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        Node node = new Node(pre[preStart++]);
        if (inStart == inEnd) {
            return node;
        }
        int mid = searchNodeIndex(in, (int) node.data, inStart, inEnd);
        node.left = buildTreeByInPre(in, pre, preStart, preStart + mid - inStart - 1, inStart, mid - 1);
        node.right = buildTreeByInPre(in, pre, preStart + mid - inStart, preEnd, mid + 1, inEnd);
        return node;
    }

    private int searchNodeIndex(int[] in, int data, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (in[i] == data) {
                return i;
            }
        }
        return -1;
    }


    public void buildTreeByInPost(int[] in, int[] post) {
        root = buildTreeByInPost(in, post, 0, post.length - 1, 0, in.length - 1);
    }

    private Node buildTreeByInPost(int[] in, int[] post, int postStart, int postEnd, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        Node node = new Node(post[postEnd--]);
        if (inStart == inEnd) {
            return node;
        }
        int mid = searchNodeIndex(in, (int) node.data, inStart, inEnd);
        node.left = buildTreeByInPost(in, post, postStart, postStart + mid - inStart - 1, inStart, mid - 1);
        node.right = buildTreeByInPost(in, post, postStart + mid - inStart, postEnd, mid + 1, inEnd);
        return node;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < (int) root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    public void delete(int data) {
        root = delete(root, data);
    }

    private Node delete(Node root, int data) {
        if (root == null) {
            return null;
        }
        if (data < (int) root.data) {
            root.left = delete(root.left, data);
        } else if (data > (int) root.data) {
            root.right = delete(root.right, data);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                root.data = findMin(root.right);
                root.right = delete(root.right, (int) root.data);
            }
        }
        return root;
    }

    private int findMin(Node root) {
        int min = 0;
        if (root != null) {
            min = (int) root.data;
            root = root.left;
        }
        return min;
    }
}

