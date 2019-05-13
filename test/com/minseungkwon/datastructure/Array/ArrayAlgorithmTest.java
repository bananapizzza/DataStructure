package com.minseungkwon.datastructure.Array;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayAlgorithmTest {
    @Test
    public void test_rotateImage() {
        int[][] image = {
                {1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        int[][] test1 = {
                {1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {1, 0, 0, 0, 0}
        };
        int[][] test2 = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {1, 0, 0, 0, 1}
        };
        int[][] test3 = {
                {0, 0, 0, 0, 1},
                {0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1}
        };

        ArrayAlgorithm aa = new ArrayAlgorithm();
        assertArrayEquals(test1, aa.rotateImage(image));
        assertArrayEquals(test2, aa.rotateImage(image));
        assertArrayEquals(test3, aa.rotateImage(image));
        assertArrayEquals(image, aa.rotateImage(image));
    }

    @Test
    public void test_setZeroToAllZero() {
        int[][] matrix = {
                {1, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 1, 0},
                {1, 0, 1, 1}
        };
        int[][] result = {
                {1, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        ArrayAlgorithm aa = new ArrayAlgorithm();
        assertArrayEquals(result, aa.setZeroToAllZero(matrix));
    }

    @Test
    public void test_setZeroToAllZeroWithoutZero() {
        int[][] matrix = {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };

        ArrayAlgorithm aa = new ArrayAlgorithm();
        assertArrayEquals(matrix, aa.setZeroToAllZero(matrix));
    }
}