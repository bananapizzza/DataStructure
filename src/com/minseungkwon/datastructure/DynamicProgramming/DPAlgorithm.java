package com.minseungkwon.datastructure.DynamicProgramming;

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
}
