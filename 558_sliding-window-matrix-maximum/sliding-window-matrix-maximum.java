/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/sliding-window-matrix-maximum
@Language: Java
@Datetime: 16-08-05 06:05
*/

public class Solution {
    /**
     * @param matrix an integer array of n * m matrix
     * @param k an integer
     * @return the maximum number
     */
    public int maxSlidingWindow2(int[][] matrix, int k) {
        // Write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || k == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        if (k > row || k > col) {
            return 0;
        }
        int[][] rectangleSum = new int[row + 1][col + 1];
        for (int i = 0; i <= row; i++) {
            rectangleSum[i][0] = 0;
        }
        for (int i = 0; i <= col; i++) {
            rectangleSum[0][i] = 0;
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                rectangleSum[i][j] = matrix[i - 1][j - 1] + rectangleSum[i][j - 1] 
                + rectangleSum[i - 1][j] - rectangleSum[i - 1][j - 1];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i + k - 1 <= row; i++) {
            for (int j = 1; j + k - 1 <= col; j++) {
                int sum = rectangleSum[i + k - 1][j + k - 1] + rectangleSum[i - 1][j - 1]
                - rectangleSum[i + k - 1][j - 1] - rectangleSum[i - 1][j + k - 1];
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}