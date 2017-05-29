/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/unique-paths-ii
@Language: Java
@Datetime: 16-07-01 03:51
*/

public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        int m = obstacleGrid.length;
        if (m <= 0) {
            return 0;
        }
        int n = obstacleGrid[0].length;
        int[][] res = new int[m][n];
        boolean flag = false;
        for (int i = 0; i < m; i++) {
            if (flag || obstacleGrid[i][0] == 1) {
                flag = true;
                res[i][0] = 0;
            } else {
                res[i][0] = 1;
            }
        }
        flag = false;
        for (int i = 0; i < n; i++) {
            if (flag || obstacleGrid[0][i] == 1) {
                flag = true;
                res[0][i] = 0;
            } else {
                res[0][i] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    res[i][j] = 0;
                } else {
                    res[i][j] = res[i - 1][j] + res[i][j - 1];
                }
            }
        }
        return res[m - 1][n - 1];
    }
}