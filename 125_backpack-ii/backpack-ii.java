/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/backpack-ii
@Language: Java
@Datetime: 16-07-01 06:20
*/

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        int f[][] = new int[A.length + 1][m + 1];
        for (int i = 0; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                f[i][j] = Integer.MIN_VALUE;
            }
        }
        f[0][0] = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j <= m; j++) {
                f[i + 1][j] = f[i][j];
                if (j >= A[i] && f[i][j - A[i]] != Integer.MIN_VALUE) {
                    f[i + 1][j] = Math.max(f[i + 1][j], f[i][j - A[i]] + V[i]);
                }
            } // for j
        } // for i
        int max = 0;
        for (int i = m; i >= 0; i--) {
            if (f[A.length][i] != Integer.MIN_VALUE) {
                max = Math.max(max, f[A.length][i]);
            }
        }
        return max;
    }
}