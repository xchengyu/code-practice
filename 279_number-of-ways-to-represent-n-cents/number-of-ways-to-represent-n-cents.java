/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/number-of-ways-to-represent-n-cents
@Language: Java
@Datetime: 17-01-18 04:58
*/

public class Solution {
    /**
     * @param n an integer
     * @return an integer
     */
    public int waysNCents(int n) {
        // Write your code here
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int[] cents = {1, 5, 10, 25};
        for (int i = 0; i < cents.length; i++) {
            for (int j = cents[i]; j <= n; j++) {
                dp[j] += dp[j - cents[i]];
            }
        }
        return dp[n];
    }
}