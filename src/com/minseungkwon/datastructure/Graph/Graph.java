package com.minseungkwon.datastructure.Graph;

import com.minseungkwon.datastructure.Queue;

import java.util.LinkedList;
import java.util.Stack;

public class Graph {

    class Node {
        int data;
        LinkedList<Node> adjacent;
        boolean marked;

        Node(int data) {
            this.data = data;
            adjacent = new LinkedList<>();
            marked = false;
        }
    }

    Node[] nodes;

    Graph(int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    public void addAdjacent(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }

    public String dfs() {
        return dfs(0);
    }

    public String dfs(int index) {
        StringBuilder result = new StringBuilder();
        Stack<Node> stack = new Stack<>();
        Node root = nodes[index];
        root.marked = true;
        stack.push(root);
        while (!stack.isEmpty()) {
            Node r = stack.pop();
            for (Node n : r.adjacent) {
                if (n.marked == false) {
                    n.marked = true;
                    stack.push(n);
                }
            }
            result.append(r.data);
            if (!stack.isEmpty()) {
                result.append(" -> ");
            }
        }
        return result.toString();
    }

    private StringBuilder dfsRecursive(Node r, StringBuilder s) {
        if (r == null) {
            return s;
        }
        r.marked = true;
        s.append(r.data);
        for (Node n : r.adjacent) {
            if (n.marked == false) {
                s.append(" -> ");
                dfsRecursive(n, s);
            }
        }
        return s;
    }

    public String dfsRecursive(int index) {
        Node r = nodes[index];
        StringBuilder s = new StringBuilder();
        return dfsRecursive(r, s).toString();
    }

    public String dfsRecursive() {
        return dfsRecursive(0);
    }

    public String bfs() {
        return bfs(0);
    }

    public String bfs(int index) {
        StringBuilder result = new StringBuilder();
        Queue<Node> queue = new Queue<>();
        Node root = nodes[index];
        root.marked = true;
        queue.add(root);
        while (!queue.isEmpty()) {
            Node r = queue.remove();
            for (Node n : r.adjacent) {
                if (n.marked == false) {
                    n.marked = true;
                    queue.add(n);
                }
            }
            result.append(r.data);
            if (!queue.isEmpty()) {
                result.append(" -> ");
            }
        }
        return result.toString();
    }

}
