/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/set-matrix-zeroes
@Language: Java
@Datetime: 17-01-20 06:08
*/

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void setZeroes(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        boolean zeroInFirstRow = false;
        boolean zeroInFirstCol = false;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                zeroInFirstCol = true;
                break;
            }
        }
        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == 0) {
                zeroInFirstRow = true;
                break;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (zeroInFirstRow) {
            for (int i = 0; i < col; i++) {
                matrix[0][i] = 0;
            }
        }
        if (zeroInFirstCol) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
        return;
    }
}