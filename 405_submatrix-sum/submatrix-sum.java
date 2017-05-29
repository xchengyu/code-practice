/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/submatrix-sum
@Language: Java
@Datetime: 17-01-17 09:39
*/

public class Solution {
    /**
     * @param matrix an integer matrix
     * @return the coordinate of the left-up and right-down number
     */
    public int[][] submatrixSum(int[][] matrix) {
        // Write your code here
        int[][] res = new int[2][2];
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] sum = new int[row + 1][col + 1];
        for (int i = 0; i < row + 1; i++) {
            sum[i][0] = 0;
        }
        for (int i = 0; i < col + 1; i++) {
            sum[0][i] = 0;
        }
        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < col + 1; j++) {
                sum[i][j] += sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j < row + 1; j++) {
                Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                for (int k = 0; k < col + 1; k++) {
                    int diff = sum[j][k] - sum[i][k];
                    if (map.containsKey(diff)) {
                        res[0][0] = i;
                        res[1][0] = j - 1;
                        res[0][1] = map.get(diff);
                        res[1][1] = k - 1;
                        return res;
                    } else {
                        map.put(diff, k);
                    }
                }
            }
        }
        return res;
    }
}