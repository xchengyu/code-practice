/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/stone-game-ii
@Language: Java
@Datetime: 17-01-13 10:00
*/

public class Solution {
    /**
     * @param A an integer array
     * @return an integer
     */
    public int stoneGame2(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int len = A.length;
        int[][] dp = new int[2 * len][2 * len];
        int[] sum = new int[2 * len + 1];
        sum[0] = A[0];
        for (int i = 1; i < 2 * len; i++) {
            sum[i] = sum[i - 1] + A[(i - 1) % len];
        }
        for (int i = 0; i < 2 * len; i++) {
            dp[i][i] = 0;
        }
        for (int group = 2; group <= len; group++) {
            for (int i = 0; i < 2 * len && i + group - 1 < 2 * len; i++) {
                int j = i + group - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int temp = dp[i][k] + dp[k + 1][j] + sum[j + 1] - sum[i];
                    dp[i][j] = Math.min(dp[i][j], temp);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            ans = Math.min(ans, dp[i][i + len - 1]);
        }
        return ans;
    }
}