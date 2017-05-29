/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/spiral-matrix-ii
@Language: Java
@Datetime: 16-08-01 07:10
*/

public class Solution {
    /**
     * @param n an integer
     * @return a square matrix
     */
    public int[][] generateMatrix(int n) {
        // Write your code here
        int[][] res = new int[n][n];
        int count = 0;
        int row = n;
        int col = n;
        int num = 1;
        while (count * 2 < row && count * 2 < col) {
            for (int j = count; j < col - count; j++) {
                res[count][j] = num++;
            }
            for (int i = count + 1; i < row - count; i++) {
                res[i][col - count - 1] = num++;
            }
            if (count * 2 + 1 == row || count * 2 + 1 == col) {
                break;
            }
            for (int j = col - count - 2; j >= count; j--) {
                res[row - count - 1][j] = num++;
            }
            for (int i = row - count - 2; i >= count + 1; i--) {
                res[i][count] = num++;
            }
            count++;
        }
        return res;
    }
}