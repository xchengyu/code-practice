/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/perfect-squares
@Language: Java
@Datetime: 16-07-31 08:06
*/

public class Solution {
    /**
     * @param n a positive integer
     * @return an integer
     */
    public int numSquares(int n) {
        // Write your code here
        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                if (res[i - j * j] < min) {
                    min = res[i - j * j];
                }
            }
            res[i] = 1 + min;
        }
        return res[n];
    }
}