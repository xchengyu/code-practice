/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/minimum-adjustment-cost
@Language: Java
@Datetime: 17-01-27 10:01
*/

public class Solution {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        if (A == null || A.size() < 2) {
            return 0;
        }
        int size = A.size();
        int[][] dp = new int[size + 1][101];
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j < 101; j++) {
                if (i == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 1; i <= size; i++) {
            for (int j = 0; j < 101; j++) {
                for (int k = 0; k < 101; k++) {
                    if (Math.abs(j - k) <= target) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.abs(A.get(i - 1) - j));
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 101; i++) {
            ans = Math.min(ans, dp[size][i]);
        }
        return ans;
        // if (A == null || A.size() < 2) {
        //     return 0;
        // }
        // int size = A.size();
        // int[][] dp = new int[size + 1][101];
        // for (int i = 0; i <= size; i++) {
        //     for (int j = 0; j < 101; j++) {
        //         if (i == 0) {
        //             dp[i][j] = 0;
        //         } else {
        //             dp[i][j] = Integer.MAX_VALUE;
        //         }
        //     }
        // }
        // for (int i = 1; i <= size; i++) {
        //     for (int j = 0; j < 101; j++) {
        //         for (int k = 0; k < 101; k++) {
        //             if (Math.abs(j - k) > target) {
        //                 continue;
        //             } else {
        //                 dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.abs(A.get(i - 1) - j));
        //             }
        //         }
        //     }
        // }
        // int min = Integer.MAX_VALUE;
        // for (int i = 0; i < 101; i++) {
        //     min = Math.min(min, dp[size][i]);
        // }
        // return min;
        // if (A == null || A.size() == 0) {
        //     return 0;
        // }
        // int len = A.size();
        // int[][] dp = new int[len + 1][101];
        // for (int i = 0; i <= len; i++) {
        //     for (int j = 0; j < 101; j++) {
        //         if (i == 0) {
        //             dp[i][j] = 0;
        //         } else {
        //             dp[i][j] = Integer.MAX_VALUE;
        //         }
        //     }
        // }
        // for (int i = 1; i <= len; i++) {
        //     for (int j = 0; j < 101; j++) {
        //         for (int k = 0; k < 101; k++) {
        //             if (Math.abs(j - k) > target) {
        //                 continue;
        //             } else {
        //                 dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.abs(A.get(i - 1) - j));
        //             }
        //         }
        //     }
        // }
        // int min = Integer.MAX_VALUE;
        // for (int i = 0; i < 101; i++) {
        //     min = Math.min(min, dp[len][i]);
        // }
        // return min;
    }
}