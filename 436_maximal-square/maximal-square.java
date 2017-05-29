/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/maximal-square
@Language: Java
@Datetime: 16-07-16 00:14
*/

public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] res = new int[2][col];
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < 2; i++) {
            res[i][0] = matrix[i][0] == 1 ? 1 : 0;
            ans = Math.max(ans, res[i][0]);
        }
        for (int i = 0; i < col; i++) {
            res[0][i] = matrix[0][i] == 1 ? 1 : 0;
            ans = Math.max(ans, res[0][i]);
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    res[i % 2][j] = 0;
                } else {
                    res[i % 2][j] = Math.min(res[(i - 1) % 2][j - 1], Math.min(res[(i - 1) % 2][j], res[i % 2][j - 1])) + 1;
                }
                ans = Math.max(ans, res[i % 2][j]);
            }
        }
        return ans * ans;
    }
}