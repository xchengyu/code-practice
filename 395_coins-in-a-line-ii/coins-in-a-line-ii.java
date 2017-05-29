/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/coins-in-a-line-ii
@Language: Java
@Datetime: 17-01-18 07:25
*/

public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if (values == null || values.length < 3) {
            return true;
        }
        int len = values.length;
        int[] sum = new int[len + 1];
        sum[0] = 0;
        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + values[len - i]; 
        }
        int[] dp = new int[len + 1];
        dp[0] = sum[0];
        dp[1] = sum[1];
        dp[2] = sum[2];
        for (int i = 3; i < len + 1; i++) {
            dp[i] = Math.max(sum[i] - dp[i - 1], sum[i] - dp[i - 2]);
        }
        return dp[len] > (sum[len] / 2);
    }
}