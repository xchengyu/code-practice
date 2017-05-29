/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/longest-palindromic-substring
@Language: Java
@Datetime: 17-01-18 06:34
*/

public class Solution {
    /**
     * @param s input string
     * @return the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int max = Integer.MIN_VALUE;
        String res = "";
        for (int i = 0; i < len; i++) {
            for (int j = i; j >= Math.max(0, i - 1000 + 1); j--) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (i - j + 1 >= max) {
                        max = i - j + 1;
                        res = s.substring(j, i + 1);
                    }
                }
            }
        }
        return res;
    }
}