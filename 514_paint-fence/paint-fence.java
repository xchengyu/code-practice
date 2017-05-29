/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/paint-fence
@Language: Java
@Datetime: 16-08-06 02:00
*/

public class Solution {
    /**
     * @param n non-negative integer, n posts
     * @param k non-negative integer, k colors
     * @return an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        // Write your code here
        if (n <= 1 || k <= 0) {
            return n * k;
        }
        int dp[] = new int[n + 1];
        dp[0] = k;
        dp[1] = k;
        dp[2] = k * (k - 1) + k;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = (k - 1) * dp[i - 1] + (k - 1) * dp[i - 2];
        }
        return dp[n];
    }
}