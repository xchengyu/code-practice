/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/matrix-zigzag-traversal
@Language: Java
@Datetime: 17-01-12 11:08
*/

public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @return: an array of integers
     */ 
    public int[] printZMatrix(int[][] matrix) {
        // write your code here
        // int x = 0;
        // int y = 0;
        // int dx = -1;
        // int dy = 1;
        // int count = 1;
        // int m = matrix.length;
        // int n = matrix[0].length;
        // int[] z = new int[m * n];
        // z[0] = matrix[0][0];
        // while (count < m * n) {
        //     if (x + dx >= 0 && y + dy >= 0 && x + dx < m && y + dy < n) {
        //         x += dx;
        //         y += dy;
        //     } else {
        //         if (dx == -1 && dy == 1) {
        //             if (y + 1 < n) {
        //                 y++;
        //             } else {
        //                 x++;
        //             }
        //             dx = 1;
        //             dy = -1;
        //         } else {
        //             if (x + 1 < m) {
        //                 x++;
        //             } else {
        //                 y++;
        //             }
        //             dx = -1;
        //             dy = 1;
        //         }
        //     }
        //     z[count] = matrix[x][y];
        //     count++;
        // }
        // return z;
        // int x = 0;
        // int y = 0;
        // int dx = -1;
        // int dy = 1;
        // int m = matrix.length;
        // int n = matrix[0].length;
        // int[] res = new int[m * n];
        // res[0] = matrix[0][0];
        // int count = 1;
        // while (count < m * n) {
        //     if (x + dx >= 0 && y + dy >= 0 && x + dx < m && y + dy < n) {
        //         x += dx;
        //         y += dy;
        //     } else {
        //         if (dx == -1 && dy == 1) {
        //             if (y + 1 < n) {
        //                 y++;
        //             } else {
        //                 x++;
        //             }
        //             dx = 1;
        //             dy = -1;
        //         } else {
        //             if (x + 1 < m) {
        //                 x++;
        //             } else {
        //                 y++;
        //             }
        //             dx = -1;
        //             dy = 1;
        //         }
        //     }
        //     res[count++] = matrix[x][y];
        // }
        // return res;
        int x = 0;
        int y = 0;
        int dx = -1;
        int dy = 1;
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        int[] res = new int[m * n];
        while (count < m * n) {
            res[count++] = matrix[x][y];
            if (x + dx >= 0 && y + dy >= 0 && x + dx < m && y + dy < n) {
                x += dx;
                y += dy;
            } else {
                if (dx == -1 && dy == 1) {
                    if (y + 1 < n) {
                        y++;
                    } else {
                        x++;
                    }
                    dx = 1;
                    dy = -1;
                } else {
                    if (x + 1 < m) {
                        x++;
                    } else {
                        y++;
                    }
                    dx = -1;
                    dy = 1;
                }
            }
        }
        return res;
    }
}