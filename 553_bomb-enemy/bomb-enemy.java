/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/bomb-enemy
@Language: Java
@Datetime: 16-08-05 03:08
*/

public class Solution {
    /**
     * @param grid Given a 2D grid, each cell is either 'W', 'E' or '0'
     * @return an integer, the maximum enemies you can kill using one bomb
     */
    public int maxKilledEnemies(char[][] grid) {
        // Write your code here
        // if (grid == null || grid.length == 0 || grid[0].length == 0) {
        //     return 0;
        // }
        // int row = grid.length;
        // int col = grid[0].length;
        // int[][] res = new int[row][col];
        // for (int i = 0; i < row; i++) {
        //     int index = 0;
        //     int pre = 0;
        //     int count = 0;
        //     while (index < col) {
        //         if (grid[i][index] == '0') {
        //             index++;
        //         } else if (grid[i][index] == 'E') {
        //             count++;
        //             index++;
        //         } else {
        //             for (int k = pre; k < index; k++) {
        //                 if (grid[i][k] == '0') {
        //                     res[i][k] += count;
        //                 }
        //             }
        //             index++;
        //             pre = index;
        //             count = 0;
        //         }
        //     }
        //     for (int t = pre; t < index; t++) {
        //         if (grid[i][t] == '0') {
        //             res[i][t] += count;
        //         }
        //     }
        // }
        // for (int i = 0; i < col; i++) {
        //     int index = 0;
        //     int pre = 0;
        //     int count = 0;
        //     while (index < row) {
        //         if (grid[index][i] == '0') {
        //             index++;
        //         } else if (grid[index][i] == 'E') {
        //             count++;
        //             index++;
        //         } else {
        //             for (int k = pre; k < index; k++) {
        //                 if (grid[k][i] == '0') {
        //                     res[k][i] += count;
        //                 }
        //             }
        //             index++;
        //             pre = index;
        //             count = 0;
        //         }
        //     }
        //     for (int t = pre; t < index; t++) {
        //         if (grid[t][i] == '0') {
        //             res[t][i] += count;
        //         }
        //     }
        // }
        // int max = Integer.MIN_VALUE;
        // for (int i = 0; i < row; i++) {
        //     for (int j = 0; j < col; j++) {
        //         max = Math.max(res[i][j], max);
        //     }
        // }
        // return max;
        //simpler and consizer version
        int m = grid.length;
        int n = m > 0 ? grid[0].length : 0;

        int result = 0, rows = 0;
        int[] cols = new int[n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (j == 0 || grid[i][j-1] == 'W') {
                    rows = 0;
                    for (int k = j; k < n && grid[i][k] != 'W'; ++k)
                        if (grid[i][k] == 'E')
                            rows += 1;
                }
                if (i == 0 || grid[i-1][j] == 'W') {
                    cols[j] = 0;
                    for (int k = i; k < m && grid[k][j] != 'W'; ++k)
                        if (grid[k][j] == 'E')
                            cols[j] += 1;
                }

                if (grid[i][j] == '0' && rows + cols[j] > result)
                    result = rows + cols[j];
            }
        }
        return result;
    }
}