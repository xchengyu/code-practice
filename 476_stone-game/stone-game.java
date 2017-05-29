/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/stone-game
@Language: Java
@Datetime: 17-01-16 07:28
*/

public class Solution {
    /**
     * @param A an integer array
     * @return an integer
     */
    public int stoneGame(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int len = A.length;
        int[][] dp = new int[len][len];
        int[] sum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j] = i == j ? 0 :Integer.MAX_VALUE;
            }
        }
        sum[0] = 0;
        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + A[i - 1];
        }
        return search(A, sum, dp, 0, len - 1);
    }
    public int search(int[] A, int[] sum, int[][] dp, int left, int right) {
        if (dp[left][right] != Integer.MAX_VALUE) {
            return dp[left][right];
        }
        int min = Integer.MAX_VALUE;
        for (int i = left; i < right; i++) {
            int leftsum = search(A, sum, dp, left, i);
            int rightsum = search(A, sum, dp, i + 1, right);
            int total = sum[right + 1] - sum[left];
            min = Math.min(min, leftsum + rightsum + total);
        }
        dp[left][right] = min;
        return dp[left][right];
    }
}
// public class Solution {
//     /**
//      * @param A an integer array
//      * @return an integer
//      */
//     public int stoneGame(int[] A) {
//         // Write your code here
//         int n = A.length;
//         if (n <= 1)
//             return 0;

//         int[][] dp = new int[n][n];

//         int[] sum = new int[n + 1];

//         for (int i = 1; i <= n; ++i) {
//             sum[i] = sum[i - 1] + A[(i - 1) % n];
//         }

//         for (int i = 0; i < n; ++i) {
//             dp[i][i] = 0;
//         }

//         for(int len = 2; len <= n; ++len)
//             for(int i= 0; i < n && i + len - 1 < n; ++i) {
//                 int j = i + len - 1;
//                 dp[i][j] = Integer.MAX_VALUE;
//                 for (int k = i; k < j; ++k) {
//                     if (dp[i][k] + dp[k+1][j] + sum[j + 1] - sum[i] < dp[i][j])
//                         dp[i][j] = dp[i][k] + dp[k+1][j] + sum[j + 1] - sum[i];
//                 }
//         }

//         // int ans = Integer.MAX_VALUE;
//         // for (int i = 0; i < n; ++i)
//         //     if (dp[i][i + n - 1] < ans)
//         //         ans = dp[i][i + n - 1];
//         // return ans;
//         return dp[0][n- 1];
//     }
// }