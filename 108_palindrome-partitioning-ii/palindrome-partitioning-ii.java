/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/palindrome-partitioning-ii
@Language: Java
@Datetime: 16-08-17 01:14
*/

public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        // write your code here
        if (s == null || s.length() < 2) {
            return 0;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                }
            }
        }
        int[] res = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            res[i] = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                if (dp[j][i]) {
                    if (j == 0) {
                        res[i] = 0;
                    } else {
                        res[i] = Math.min(res[i], 1 + res[j - 1]);
                    }
                }
            }
        }
        return res[s.length() - 1];
    }
};