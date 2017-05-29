/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/climbing-stairs-ii
@Language: Java
@Datetime: 16-10-06 23:09
*/

public class Solution {
    /**
     * @param n an integer
     * @return an integer
     */
    public int climbStairs2(int n) {
        // Write your code here
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i <= n; i++) {
            if (i - 3 >= 0) {
                dp[i] += dp[i - 3];
            }
            if (i - 2 >= 0) {
                dp[i] += dp[i - 2];
            }
            if (i - 1 >= 0) {
                dp[i] += dp[i - 1];
            }
        }
        return dp[n];
    }
}