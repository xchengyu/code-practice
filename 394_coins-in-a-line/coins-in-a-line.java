/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/coins-in-a-line
@Language: Java
@Datetime: 16-07-16 05:47
*/

public class Solution {
    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {
        // write your code here
        if (n == 0) {
            return false;
        }
        if (n == 1 || n == 2) {
            return true;
        }
        boolean[] dp = new boolean[2];
        dp[0] = dp[1] = true;
        for (int i = 3; i <= n; i++) {
            dp[i % 2] = !dp[(i - 1) % 2] || !dp[(i - 2) % 2];
        }
        return dp[n % 2];
    }
}