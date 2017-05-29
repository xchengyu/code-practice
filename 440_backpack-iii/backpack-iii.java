/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/backpack-iii
@Language: Java
@Datetime: 16-07-17 10:38
*/

public class Solution {
    /**
     * @param A an integer array
     * @param V an integer array
     * @param m an integer
     * @return an array
     */
    public int backPackIII(int[] A, int[] V, int m) {
        // Write your code here
        //注意，每个物品可以买很多个, dp[j]的意思是当还有j的size时所能装的物品价值的最大值
        int len = A.length;
        int[] dp = new int[m + 1];
        for (int i = 1; i < len + 1; i++) {
            for (int j = A[i - 1]; j < m + 1; j++) {
                dp[j] = Math.max(V[i - 1] + dp[j - A[i - 1]], dp[j]);
            }
        }
        return dp[m];
    }
}