/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/longest-common-subsequence
@Language: Java
@Datetime: 17-01-10 07:35
*/

public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        // int m = A.length();
        // int n = B.length();
        // int[][] dp = new int[m + 1][n + 1];
        // dp[0][0] = 0;
        // for (int i = 1; i <= m; i++) {
        //     for (int j = 1; j <= n; j++) {
        //         dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        //         if (A.charAt(i - 1) == B.charAt(j - 1)) {
        //             dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
        //         }
        //     }
        // }
        // return dp[m][n];
        int m = A.length();
        int n = B.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = 0;
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                } else {
                    dp[i][j] = Math.max(dp[i][j], Math.max(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[m][n];
    }
}
