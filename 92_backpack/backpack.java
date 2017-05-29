/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/backpack
@Language: Java
@Datetime: 17-01-27 08:57
*/

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        // boolean dp[][] = new boolean[A.length + 1][m + 1];
        // for (int i = 0; i <= A.length; i++) {
        //     for (int j = 0; j < m; j++) {
        //         dp[i][j] = false;
        //     }
        // }
        // dp[0][0] = true;
        // for (int i = 0; i <= A.length - 1; i++) {
        //     for (int j = 0; j <= m; j++) {
        //         dp[i + 1][j] = dp[i][j];
        //         if (j >= A[i] && dp[i][j - A[i]]) {
        //             dp[i + 1][j] = true;
        //         }
        //     }
        // }
        // for (int i = m; i >= 0; i--) {
        //     if (dp[A.length][i]) {
        //         return i;
        //     }
        // }
        // return 0;
        // boolean dp[] = new boolean[m + 1];
        // dp[0] = true;
        // for (int i = 0; i < A.length; i++) {
        //     for (int j = m; j >= 0; j--) {
        //         if (j >= A[i] && dp[j - A[i]]) {
        //             dp[j] = true;
        //         }
        //     }
        // }
        // for (int i = m; i >= 0; i--) {
        //     if (dp[i]) {
        //         return i;
        //     }
        // }
        // return 0;
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        for (int i = 0; i < A.length; i++) {
            for (int j = m; j >= A[i]; j--) {
                if (dp[j - A[i]]) {
                    dp[j] = true;
                }
            }
        }
        for (int i = m; i >= 0; i--) {
            if (dp[i]) {
                return i;
            }
        }
        return 0;
    }
}