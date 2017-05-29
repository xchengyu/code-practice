/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/triangle
@Language: Java
@Datetime: 16-07-01 04:19
*/

public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if (triangle == null || triangle.length == 0) {
            return -1;
        }
        if (triangle[0] == null || triangle[0].length == 0) {
            return -1;
        }
        int n = triangle.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = triangle[n - 1][i];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                res[j] = triangle[i][j] + Math.min(res[j], res[j + 1]);
            }
        }
        return res[0];
    }
}
