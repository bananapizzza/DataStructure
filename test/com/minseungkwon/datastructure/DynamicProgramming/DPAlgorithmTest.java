package com.minseungkwon.datastructure.DynamicProgramming;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DPAlgorithmTest {
    @Test
    public void test_minCostClimbingStairs() {
        int[] test1 = {1, 2, 3, 4, 5, 6, 7};
        int[] test2 = {10, 15, 20};
        int[] test3 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

        long beforeTime = System.currentTimeMillis();
        assertEquals(12, DPAlgorithm.minCostClimbingStairs(test1));
        assertEquals(15, DPAlgorithm.minCostClimbingStairs(test2));
        assertEquals(6, DPAlgorithm.minCostClimbingStairs(test3));
        long afterTime = System.currentTimeMillis();
        System.out.println(afterTime - beforeTime);
    }

    @Test
    public void test_minCostClimbingStairsNotUsingDP() {
        int[] test1 = {1, 2, 3, 4, 5, 6, 7};
        int[] test2 = {10, 15, 20};
        int[] test3 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

        long beforeTime = System.currentTimeMillis();
        assertEquals(12, DPAlgorithm.minCostClimbingStairsNotUsingDP(test1));
        assertEquals(15, DPAlgorithm.minCostClimbingStairsNotUsingDP(test2));
        assertEquals(6, DPAlgorithm.minCostClimbingStairsNotUsingDP(test3));
        long afterTime = System.currentTimeMillis();
        System.out.println(afterTime - beforeTime);
    }

    @Test
    public void test_findPath() {
        boolean[][] grid = {
                {false, false, false, false},
                {false, false, false, true},
                {true, true, false, false},
                {false, false, false, false}
        };

        ArrayList<DPAlgorithm.Point> path = DPAlgorithm.findPath(grid);
        StringBuilder s = new StringBuilder();
        for (DPAlgorithm.Point p : path) {
            s.append(p.row);
            s.append(p.col);
            s.append(" ");
        }
        assertEquals("00 10 11 12 22 32 33 ", s.toString());
    }
}