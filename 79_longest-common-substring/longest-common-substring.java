/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/longest-common-substring
@Language: Java
@Datetime: 17-01-27 10:13
*/

// public class Solution {
//     /**
//      * @param A, B: Two string.
//      * @return: the length of the longest common substring.
//      */
//     public int longestCommonSubstring(String A, String B) {
//         // write your code here
//         int max = 0;
//         if (A == null || A.length() == 0 || B == null || B.length() == 0) {
//             return max;
//         }
//         int xlen = A.length();
//         int ylen = B.length();
//         for (int i = 0; i < xlen; i++) {
//             for (int j = 0; j < ylen; j++) {
//                 int len = 0;
//                 while (i + len < xlen && j + len < ylen && A.charAt(i + len) == B.charAt(j + len)) {
//                     len++;
//                     max = Math.max(len, max);
//                 }
//             }
//         }
//         return max;
//     }
// }
public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        // if (A == null || A.length() == 0 || B == null || B.length() == 0) {
        //     return 0;
        // }
        // int max = 0;
        // for (int i = 0; i < A.length(); i++) {
        //     for (int j = 0; j < B.length(); j++) {
        //         int len = 0;
        //         while (i + len < A.length() && j + len < B.length() && A.charAt(i + len) == B.charAt(j + len)) {
        //             len++;
        //             max = Math.max(max, len);
        //         }
        //     }
        // }
        // return max;
        if (A == null || A.length() == 0 || B == null || B.length() == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < B.length(); j++) {
                int len = 0;
                while (i + len < A.length() && j + len < B.length() && A.charAt(i + len) == B.charAt(j + len)) {
                    len++;
                    max = Math.max(max, len);
                }
            }
        }
        return max;
        // //method 2 dp, time and space: O(m * n)
        // if (A == null || A.length() == 0 || B == null || B.length() == 0) {
        //     return 0;
        // }
        // int[][] dp = new int[A.length() + 1][B.length() + 1];
        // int max = 0;
        // for (int i = 0; i < A.length() + 1; i++) {
        //     dp[i][0] = 0;
        // }
        // for (int i = 0; i < B.length() + 1; i++) {
        //     dp[0][i] = 0;
        // }
        // for (int i = 1; i < A.length() + 1; i++) {
        //     for (int j = 1; j < B.length() + 1; j++) {
        //         if (A.charAt(i - 1) == B.charAt(j - 1)) {
        //             dp[i][j] = Math.max(1 + dp[i - 1][j - 1], dp[i][j]);
        //             max = Math.max(dp[i][j], max);
        //         }
        //     }
        // }
        // return max;
    }
}