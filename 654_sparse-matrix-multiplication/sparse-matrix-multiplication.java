/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/sparse-matrix-multiplication
@Language: Java
@Datetime: 17-05-19 09:15
*/

public class Solution {
    /**
     * @param A a sparse matrix
     * @param B a sparse matrix
     * @return the result of A * B
     */
    public int[][] multiply(int[][] A, int[][] B) {
        // Write your code here
        int row = A.length;
        int col = B[0].length;
        int k = B.length;
        int[][] C = new int[row][col];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < k; ++j) {
                if (A[i][j] != 0) {
                    for (int l = 0; l < col; ++l) {
                        C[i][l] += A[i][j] * B[j][l];
                    }
                }
            }
        }
        return C;
    }
}