/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/search-a-2d-matrix
@Language: Java
@Datetime: 16-12-26 06:56
*/

public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int row_start = 0;
        int row_end = row - 1;
        int col_start = 0;
        int col_end = col - 1;
        while (row_start + 1 < row_end) {
            int mid = row_start + (row_end - row_start) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                row_start = mid;
            } else {
                row_end = mid;
            }
        }
        if (target < matrix[row_start][0]) {
            if (row_start == 0) {
                return false;
            } else {
                return search(matrix, row_start - 1, target);
            }
        } else if (target == matrix[row_start][0]) {
            return true;
        } else if (target < matrix[row_end][0]) {
            return search(matrix, row_end - 1, target);
        } else if (target == matrix[row_end][0]) {
            return true;
        } else {
            return search(matrix, row_end, target);
        }
    }
    
    private boolean search(int[][] matrix, int row, int target) {
        int col = matrix[0].length;
        int col_start = 0;
        int col_end = col - 1;
        while (col_start + 1 < col_end) {
            int mid = col_start + (col_end - col_start) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                col_start = mid;
            } else {
                col_end = mid;
            }
        }
        if (matrix[row][col_start] == target || matrix[row][col_end] == target) {
            return true;
        } else {
            return false;
        }
    }
}
// public class Solution {
//     /**
//      * @param matrix, a list of lists of integers
//      * @param target, an integer
//      * @return a boolean, indicate whether matrix contains target
//      */
//     public boolean searchMatrix(int[][] matrix, int target) {
//         // write your code here
//         if (matrix == null || matrix.length == 0) {
//             return false;
//         }
//         int row_start = 0;
//         int row_end = matrix.length - 1;
//         int col_start = 0;
//         int col_end = matrix[0].length - 1;
//         int row_mid = 0;
//         int col_mid = 0;
//         while (row_start <= row_end) {
//             row_mid = row_start + (row_end - row_start) / 2;
//             if (matrix[row_mid][0] == target) {
//                 return true;
//             } else if (matrix[row_mid][0] > target) {
//                 row_end = row_mid - 1;
//             } else {
//                 row_start = row_mid + 1;
//             }
//         }
//         int row_loc = 0;
//         if (matrix[row_mid][0] < target) {
//             row_loc = row_mid;
//         } else {
//             row_loc = row_mid - 1;
//         }
//         if (row_loc < 0) {
//             return false;
//         }
//         while (col_start <= col_end) {
//             col_mid = col_start + (col_end - col_start) / 2;
//             if (matrix[row_loc][col_mid] == target) {
//                 return true;
//             } else if (matrix[row_loc][col_mid] > target) {
//                 col_end = col_mid - 1;
//             } else {
//                 col_start = col_mid + 1;
//             }
//         }
//         return false;
//     }
// }
