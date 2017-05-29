/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/paint-house-ii
@Language: Java
@Datetime: 16-08-01 03:15
*/

public class Solution {
    /**
     * @param costs n x k cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] costs) {
        // Write your code here
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int[][] result = new int[2][costs[0].length];
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        int firstMinIndex = 0;
        for (int i = 0; i < costs[0].length; i++) {
            result[0][i] = costs[0][i];
            if (result[0][i] < firstMin) {
                secondMin = firstMin;
                firstMin = result[0][i];
                firstMinIndex = i;
            } else if (result[0][i] < secondMin) {
                secondMin = result[0][i];
            } else {
                continue;
            }
        }
        for (int i = 1; i < costs.length; i++) {
            int nextFirstMin = Integer.MAX_VALUE;
            int nextSecondMin = Integer.MAX_VALUE;
            int nextFirstMinIndex = 0;
            for (int j = 0; j < costs[0].length; j++) {
                result[i % 2][j] = j == firstMinIndex ? costs[i][j] + secondMin :
                costs[i][j] + firstMin;
                if (result[i % 2][j] < nextFirstMin) {
                    nextSecondMin = nextFirstMin;
                    nextFirstMin = result[i % 2][j];
                    nextFirstMinIndex = j;
                } else if (result[i % 2][j] < nextSecondMin) {
                    nextSecondMin = result[i % 2][j];
                } else {
                    continue;
                }
            }
            firstMin = nextFirstMin;
            firstMinIndex = nextFirstMinIndex;
            secondMin = nextSecondMin;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < costs[0].length; i++) {
            if (result[(costs.length - 1) % 2][i] < min) {
                min = result[(costs.length - 1) % 2][i];
            }
        }
        return min;
    }
}