package com.minseungkwon.datastructure.DynamicProgramming;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DPAlgorithm {
    //Let's assume that there is a staircase of which length is the given array's length
    //Each data in the given array represents the cost to climb the stair
    //Once you pay the cost, you can choose to climb one or two steps
    //You can start from index 0 or index 1
    //Return the minimum cost of climbing stairs
    public static int minCostClimbingStairs(int[] cost) {
        //Calculate the minimum cost of each step from the end
        //case1 means the case of climbing one step
        //case2 means the case of climbing two steps
        //current is the minimum cost of the current step
        int case1 = 0;
        int case2 = 0;
        int current;
        for (int i = cost.length - 1; i >= 0; i--) {
            current = Math.min(case1, case2) + cost[i];
            case2 = case1;
            case1 = current;
        }
        return Math.min(case1, case2);
    }

    public static int minCostClimbingStairsNotUsingDP(int[] cost) {
        int case1 = minCostClimbingStairsNotUsingDP(cost, 0, 0);
        int case2 = minCostClimbingStairsNotUsingDP(cost, 1, 0);
        return case1 < case2 ? case1 : case2;
    }

    private static int minCostClimbingStairsNotUsingDP(int[] cost, int index, int sum) {
        if (index >= cost.length) {
            return sum;
        }
        sum += cost[index];
        int case1 = minCostClimbingStairsNotUsingDP(cost, index + 1, sum);
        int case2 = minCostClimbingStairsNotUsingDP(cost, index + 2, sum);
        return case1 < case2 ? case1 : case2;
    }

    //A robot is in the grid at first row and first col
    //He wants to go to the last row and last col
    //Grid array is given as boolean type. True means there is a wall so the robot cannot go to the spot
    //Return the path of the robot from the start point to the end point

    //Class for saving the path
    static class Point {
        int row;
        int col;

        Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static ArrayList<Point> findPath(boolean[][] grid) {
        if (grid == null || grid.length == 0) {
            return null;
        }
        ArrayList<Point> path = new ArrayList<>();
        //Since it uses a recursive function, it starts from the end point.
        //Therefore it can add path from the start point when it arrives to start point
        if (findPath(grid, grid.length - 1, grid[0].length - 1, path)) {
            return path;
        } else {
            return null;
        }
    }

    private static boolean findPath(boolean[][] grid, int row, int col, ArrayList<Point> path) {
        if (!isInRange(grid, row, col) || grid[row][col]) {
            return false;
        }
        if ((row == 0 && col == 0) || findPath(grid, row, col - 1, path) || findPath(grid, row - 1, col, path)) {
            Point p = new Point(row, col);
            path.add(p);
            return true;
        }
        return false;
    }

    private static boolean isInRange(boolean[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[row].length;
    }
}
