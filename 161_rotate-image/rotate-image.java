/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/rotate-image
@Language: Java
@Datetime: 17-01-20 04:57
*/

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void rotate(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        // for (int i = 0; i < col; i++) {
        //     int start = 0;
        //     int end = row - 1;
        //     while (start < end) {
        //         int tmp = matrix[start][i];
        //         matrix[start][i] = matrix[end][i];
        //         matrix[end][i] = tmp;
        //         start++;
        //         end--;
        //     }
        // }
        // for (int i = 0; i < row; i++) {
        //     for (int j = i; j < col; j++) {
        //         int tmp = matrix[i][j];
        //         matrix[i][j] = matrix[j][i];
        //         matrix[j][i] = tmp;
        //     }
        // }
        for (int i = 0; i < row; i++) {
            for (int j = i; j < col; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int i = 0; i < row; i++) {
            int left = 0;
            int right = col - 1;
            while (left < right) {
                int tmp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = tmp;
                left++;
                right--;
            }
        }
        return;
    }
}