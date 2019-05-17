package com.minseungkwon.datastructure.DynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.*;

public class DPAlgorithmTest {
    @Test
    public void test_minCostClimbingStairs() {
        int[] test1 = {1, 2, 3, 4, 5, 6, 7};
        int[] test2 = {10, 15, 20};
        int[] test3 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

        assertEquals(12, DPAlgorithm.minCostClimbingStairs(test1));
        assertEquals(15, DPAlgorithm.minCostClimbingStairs(test2));
        assertEquals(6, DPAlgorithm.minCostClimbingStairs(test3));
    }
}