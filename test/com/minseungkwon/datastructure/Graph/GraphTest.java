package com.minseungkwon.datastructure.Graph;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GraphTest {
    @Test
    public void test_dfs() {
        Graph g = new Graph(9);
        g.addAdjacent(0, 1);
        g.addAdjacent(1, 2);
        g.addAdjacent(1, 3);
        g.addAdjacent(2, 4);
        g.addAdjacent(2, 3);
        g.addAdjacent(3, 4);
        g.addAdjacent(3, 5);
        g.addAdjacent(5, 6);
        g.addAdjacent(5, 7);
        g.addAdjacent(6, 8);
        assertEquals("0 -> 1 -> 3 -> 5 -> 7 -> 6 -> 8 -> 4 -> 2", g.dfs());
        assertEquals("0 -> 1 -> 3 -> 5 -> 7 -> 6 -> 8 -> 4 -> 2", g.dfs());
    }

    @Test
    public void test_dfsWithIndex() {
        Graph g = new Graph(9);
        g.addAdjacent(0, 1);
        g.addAdjacent(1, 2);
        g.addAdjacent(1, 3);
        g.addAdjacent(2, 4);
        g.addAdjacent(2, 3);
        g.addAdjacent(3, 4);
        g.addAdjacent(3, 5);
        g.addAdjacent(5, 6);
        g.addAdjacent(5, 7);
        g.addAdjacent(6, 8);
        assertEquals("3 -> 5 -> 7 -> 6 -> 8 -> 4 -> 2 -> 1 -> 0", g.dfs(3));
        assertEquals("3 -> 5 -> 7 -> 6 -> 8 -> 4 -> 2 -> 1 -> 0", g.dfs(3));
    }

    @Test
    public void test_dfsRecursive() {
        Graph g = new Graph(9);
        g.addAdjacent(0, 1);
        g.addAdjacent(1, 2);
        g.addAdjacent(1, 3);
        g.addAdjacent(2, 4);
        g.addAdjacent(2, 3);
        g.addAdjacent(3, 4);
        g.addAdjacent(3, 5);
        g.addAdjacent(5, 6);
        g.addAdjacent(5, 7);
        g.addAdjacent(6, 8);
        assertEquals("0 -> 1 -> 2 -> 4 -> 3 -> 5 -> 6 -> 8 -> 7", g.dfsRecursive());
        assertEquals("0 -> 1 -> 2 -> 4 -> 3 -> 5 -> 6 -> 8 -> 7", g.dfsRecursive());
    }

    @Test
    public void test_dfsRecursiveWithIndex() {
        Graph g = new Graph(9);
        g.addAdjacent(0, 1);
        g.addAdjacent(1, 2);
        g.addAdjacent(1, 3);
        g.addAdjacent(2, 4);
        g.addAdjacent(2, 3);
        g.addAdjacent(3, 4);
        g.addAdjacent(3, 5);
        g.addAdjacent(5, 6);
        g.addAdjacent(5, 7);
        g.addAdjacent(6, 8);
        assertEquals("3 -> 1 -> 0 -> 2 -> 4 -> 5 -> 6 -> 8 -> 7", g.dfsRecursive(3));
        assertEquals("3 -> 1 -> 0 -> 2 -> 4 -> 5 -> 6 -> 8 -> 7", g.dfsRecursive(3));
    }

    @Test
    public void test_bfs() {
        Graph g = new Graph(9);
        g.addAdjacent(0, 1);
        g.addAdjacent(1, 2);
        g.addAdjacent(1, 3);
        g.addAdjacent(2, 4);
        g.addAdjacent(2, 3);
        g.addAdjacent(3, 4);
        g.addAdjacent(3, 5);
        g.addAdjacent(5, 6);
        g.addAdjacent(5, 7);
        g.addAdjacent(6, 8);
        assertEquals("0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8", g.bfs());
        assertEquals("0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8", g.bfs());
    }

    @Test
    public void test_bfsWithIndex() {
        Graph g = new Graph(9);
        g.addAdjacent(0, 1);
        g.addAdjacent(1, 2);
        g.addAdjacent(1, 3);
        g.addAdjacent(2, 4);
        g.addAdjacent(2, 3);
        g.addAdjacent(3, 4);
        g.addAdjacent(3, 5);
        g.addAdjacent(5, 6);
        g.addAdjacent(5, 7);
        g.addAdjacent(6, 8);
        assertEquals("3 -> 1 -> 2 -> 4 -> 5 -> 0 -> 6 -> 7 -> 8", g.bfs(3));
        assertEquals("3 -> 1 -> 2 -> 4 -> 5 -> 0 -> 6 -> 7 -> 8", g.bfs(3));
    }

    @Test
    public void test_searchWithConnection() {
        Graph g = new Graph(9);
        g.addAdjacent(0, 1);
        g.addAdjacent(1, 2);
        g.addAdjacent(1, 3);
        g.addAdjacent(2, 4);
        g.addAdjacent(2, 3);
        g.addAdjacent(3, 4);
        g.addAdjacent(3, 5);
        g.addAdjacent(5, 6);
        g.addAdjacent(5, 7);
        g.addAdjacent(6, 8);
        assertEquals(true, g.search(1, 8));
    }

    @Test
    public void test_searchWithoutConnection() {
        Graph g = new Graph(9);
        g.addAdjacent(0, 1);
        g.addAdjacent(1, 2);
        g.addAdjacent(1, 3);
        g.addAdjacent(2, 4);
        g.addAdjacent(2, 3);
        g.addAdjacent(3, 4);
        //g.addAdjacent(3, 5);
        g.addAdjacent(5, 6);
        g.addAdjacent(5, 7);
        g.addAdjacent(6, 8);
        assertEquals(false, g.search(1, 8));
    }
}