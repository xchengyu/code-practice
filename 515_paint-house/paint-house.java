/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/paint-house
@Language: Java
@Datetime: 16-07-31 06:43
*/

public class Solution {
    /**
     * @param costs n x 3 cost matrix
     * @return an integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // Write your code here
        if (costs.length == 0) {
            return 0;
        }
        int[][] result = new int[costs.length][3];
        for (int i = 0; i < 3; i++) {
            result[0][i] = costs[0][i];
        }
        for (int i = 1; i < costs.length; i++) {
            result[i][0] = costs[i][0] + Math.min(result[i - 1][1] , result[i - 1][2]);
            result[i][1] = costs[i][1] + Math.min(result[i - 1][0] , result[i - 1][2]);
            result[i][2] = costs[i][2] + Math.min(result[i - 1][0] , result[i - 1][1]);
        }
        return Math.min(result[costs.length - 1][0], Math.min(result[costs.length - 1][1], result[costs.length - 1][2]));
    }
}