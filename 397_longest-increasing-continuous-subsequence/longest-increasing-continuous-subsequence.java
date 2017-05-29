/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/longest-increasing-continuous-subsequence
@Language: Java
@Datetime: 16-07-15 23:40
*/

public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
        if (A == null || A.length < 2) {
            return A == null ? 0 : A.length;
        }
        int forth = Integer.MIN_VALUE;
        int back = Integer.MIN_VALUE;
        int len = 0;
        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                len = 1;
                forth = Math.max(forth, len);
            } else {
                if (A[i] >= A[i - 1]) {
                    len++;
                    forth = Math.max(forth, len);
                } else {
                    len = 1;
                    forth = Math.max(forth, len);
                }
            }
        }
        for (int i = A.length - 1; i >= 0; i--) {
            if (i == A.length - 1) {
                len = 1;
                forth = Math.max(forth, len);
            } else {
                if (A[i] >= A[i + 1]) {
                    len++;
                    forth = Math.max(forth, len);
                } else {
                    len = 1;
                    forth = Math.max(forth, len);
                }
            }
        }
        return Math.max(forth, back);
    }
}