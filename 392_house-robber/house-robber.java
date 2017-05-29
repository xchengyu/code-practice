/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/house-robber
@Language: Java
@Datetime: 16-07-16 05:14
*/

public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return Long.valueOf(0);
        }
        if (A.length == 1) {
            return Long.valueOf(A[0]);
        }
        long[] dp = new long[2];
        dp[0] = Long.valueOf(A[0]);
        dp[1] = max(Long.valueOf(A[0]), Long.valueOf(A[1]));
        for (int i = 2 ; i < A.length; i++) {
            dp[i % 2] = max(dp[(i - 1) % 2], dp[(i - 2) % 2] + Long.valueOf(A[i]));
        }
        return dp[(A.length - 1) % 2];
    }
    public long max(long x, long y) {
        return x > y ? x : y;
    }
}