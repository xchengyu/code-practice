/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/minimum-path-sum
@Language: Java
@Datetime: 16-07-01 04:00
*/

public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        int m = grid.length;
        if (m <= 0) {
            return 0;
        }
        int n = grid[0].length;
        int[][] res = new int[m][n];
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += grid[i][0];
            res[i][0] = sum;
        }
        sum = 0;
        for (int i = 0; i < n; i++) {
            sum += grid[0][i];
            res[0][i] = sum;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = grid[i][j] + Math.min(res[i - 1][j], res[i][j - 1]);
            }
        }
        return res[m - 1][n - 1];
    }
}
