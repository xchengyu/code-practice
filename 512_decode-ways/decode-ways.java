/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/decode-ways
@Language: Java
@Datetime: 17-05-04 01:32
*/

public class Solution {
    /**
     * @param s a string,  encoded message
     * @return an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (i >= 2 && isValid(s.substring(i - 2, i))) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
    
    public boolean isValid(String str) {
        if (str.charAt(0) == '0') {
            return false;
        }
        int num = Integer.parseInt(str);
        if (num > 26 || num < 1) {
            return false;
        }
        return true;
    }
}