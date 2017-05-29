/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/regular-expression-matching
@Language: Java
@Datetime: 16-08-30 09:38
*/

public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
    // public boolean isMatch(String s, String p) {
    //     // write your code here
    //     if (s == null || p == null) {
    //         return false;
    //     }
    //     boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    //     //dp[0][0] = true;
    //     for (int i = 0; i <= s.length(); i++) {
    //         for (int j = 0; j <= p.length(); j++) {
    //             if (j == 0) {
    //                 dp[i][j] = i == 0 ? true : false;
    //             } else if (p.charAt(j - 1) == '*') {
    //                 if(j < 2) {
    //                     return false;
    //                 }
    //                 for (int k = 0; k <= i; k++) {
    //                     if (k != 0 && !isSame(s.charAt(i - k), p.charAt(j - 2))) {
    //                         dp[i][j] = false;
    //                         break;
    //                     }
    //                     if (dp[i - k][j - 2]) {
    //                         dp[i][j] = true;
    //                         break;
    //                     }
    //                 }
    //             } else {
    //                 dp[i][j] = i >= 1 && isSame(s.charAt(i - 1), p.charAt(j - 1)) && dp[i - 1][j - 1];
    //             }
    //         }
    //     }
    //     return dp[s.length()][p.length()];
    // }
    
    // public boolean isSame(char a, char b) {
    //     return b == '.' || a == b;
    // }
    ////////////////////////////////////////////////////////////////////////////
    public boolean isMatch(String s, String p) {
        //Java note: s.substring(n) will be "" if n == s.length(), but if n > s.length(), index oob error
        
        int i = 0, j = 0;
        //you don't have to construct a state machine for this problem
 
        if (s.length() == 0) {
            return checkEmpty(p);
        }
 
        if (p.length() == 0) {
            return false;
        }
 
        char c1 = s.charAt(0);
        char d1 = p.charAt(0), d2 = '0'; //any init value except '*'for d2 will do
 
        if (p.length()>1){
            d2 = p.charAt(1);
        }
 
        if (d2 == '*') {
            if (compare(c1, d1)) {
                //fork here: 1. consume the character, and use the same pattern again.
                //2. keep the character, and skip 'd1*' pattern
                 
                //Here is also an opportunity to use DP, but the idea is the same
                return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
            }
            else {
                return isMatch(s, p.substring(2));
            }
        }
        else {
            if (compare(c1, d1)) {
                return isMatch(s.substring(1), p.substring(1));
            }
            else {
                return false;
            }
        }
    }
    
    public boolean compare(char c1, char d1){
        return d1 == '.' || c1 == d1;
    }
 
    public boolean checkEmpty(String p) {
        if (p.length() % 2 != 0) {
            return false;  
        }
 
        for (int i = 1; i < p.length(); i += 2) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }
}