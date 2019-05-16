package com.minseungkwon.datastructure.Sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortAlgorithmTest {
    @Test
    public void test_quickSort() {
        int[] arr = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
        int[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        SortAlgorithm.quickSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void test_mergeSort() {
        int[] arr = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
        int[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        SortAlgorithm.mergeSort(arr);
        assertArrayEquals(expected, arr);
    }
}