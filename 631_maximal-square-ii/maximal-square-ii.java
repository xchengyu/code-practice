/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/maximal-square-ii
@Language: Java
@Datetime: 17-03-03 09:43
*/

public class Solution {
    /**
     * @param matrix a matrix of 0 and 1
     * @return an integer
     */
    public int maxSquare2(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] up = new int[row][col];
        int[][] left = new int[row][col];
        int[][] res = new int[row][col];
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0) {
                    up[i][j] = matrix[i][j] == 0 ? 1 : 0;
                } else {
                    up[i][j] = matrix[i][j] == 0 ? up[i - 1][j] + 1 : 0;
                }
                if (matrix[i][j] != 0) {
                    max = 1;
                }
            }
        }
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (i == 0) {
                    left[j][i] = matrix[j][i] == 0 ? 1 : 0;
                } else {
                    left[j][i] = matrix[j][i] == 0 ? left[j][i - 1] + 1 : 0;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            res[i][0] = matrix[i][0] == 1 ? 1 : 0;
        }
        for (int j = 0; j < col; j++) {
            res[0][j] = matrix[0][j] == 1 ? 1 : 0;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 1) {
                    res[i][j] = 1 + Math.min(res[i - 1][j - 1], Math.min(up[i - 1][j], left[i][j - 1]));
                    max = Math.max(max, res[i][j]);
                } else {
                    continue;
                }
            }
        }
        return max * max;
    }
}