/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/interleaving-string
@Language: Java
@Datetime: 16-08-07 07:49
*/

public class Solution {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        // if (s1.length() + s2.length() != s3.length()) {
        //     return false;
        // }
        // int m = s1.length();
        // int n = s2.length();
        // boolean[][] res = new boolean[m + 1][n + 1];
        // res[0][0] = true;
        // for (int i = 1; i <= m; i++) {
        //     if (s1.charAt(i - 1) == s3.charAt(i - 1) && res[i - 1][0]) {
        //         res[i][0] = true;
        //     }
        // }
        // for (int i = 1; i <= n; i++) {
        //     if (s2.charAt(i - 1) == s3.charAt(i - 1) && res[0][i - 1]) {
        //         res[0][i] = true;
        //     }
        // }
        // for (int i = 1; i <= m; i++) {
        //     for (int j = 1; j <= n; j++) {
        //         if ((s1.charAt(i - 1) == s3.charAt(i + j - 1) && res[i - 1][j]) || (s2.charAt(j - 1) == s3.charAt(i + j - 1) && res[i][j - 1])) {
        //             res[i][j] = true;
        //         }
        //     }
        // }
        // return res[m][n];
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int m = s1.length();
        int n = s2.length();
        boolean[][] res = new boolean[m + 1][n + 1];
        res[0][0] = true;
        for (int i = 1; i <= m; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1) && res[i - 1][0]) {
                res[i][0] = true;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1) && res[0][i - 1]) {
                res[0][i] = true;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if ((s1.charAt(i - 1) == s3.charAt(i + j - 1) && res[i - 1][j]) || (s2.charAt(j - 1) == s3.charAt(i + j - 1) && res[i][j - 1])) {
                    res[i][j] = true;
                }
            }
        }
        return res[m][n];
    }
}