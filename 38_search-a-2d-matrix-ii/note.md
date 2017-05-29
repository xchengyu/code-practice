```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/search-a-2d-matrix-ii
@Language: Markdown
@Datetime: 17-01-31 09:51
```

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        
        // from bottom left to top right
        int n = matrix.length;
        int m = matrix[0].length;
        int x = n - 1;
        int y = 0;
        int count = 0;
        
        while (x >= 0 && y < m) {
            if (matrix[x][y] < target) {
                y++;
            } else if (matrix[x][y] > target) {
                x--;
            } else {
                count++;
                x--;
                y++;
            }
        }
        return count;
    }
}
// public class Solution {
//     /**
//      * @param matrix: A list of lists of integers
//      * @param: A number you want to search in the matrix
//      * @return: An integer indicate the occurrence of target in the given matrix
//      */
//     public int searchMatrix(int[][] matrix, int target) {
//         // write your code here
//         if (matrix == null || matrix.length == 0) {
//             return 0;
//         }
//         return helper(matrix, matrix.length - 1, 0, target);
//     }
    
//     private int helper(int[][] matrix, int row_end, int col_start, int target) {
//         if (row_end < 0 || col_start >= matrix[0].length) {
//             return 0;
//         }
//         if (row_end == 0 && col_start == matrix[0].length - 1) {
//             return matrix[row_end][col_start] == target? 1 : 0;
//         }
//         if (row_end == 0) {
//             return searchRow(matrix, row_end, col_start, target);
//         }
//         if (col_start == matrix[0].length - 1) {
//             return searchCol(matrix, row_end, col_start, target);
//         }
//         int up = 0;
//         int bottom = row_end;
//         while (up + 1 < bottom) {
//             int mid = up + (bottom - up) / 2;
//             if (matrix[mid][col_start] == target) {
//                 return 1 + helper(matrix, row_end - 1, col_start + 1, target);
//             } else if (matrix[mid][col_start] < target) {
//                 up = mid;
//             } else {
//                 bottom = mid;
//             }
//         }
//         if (matrix[bottom][col_start] < target) {
//             return helper(matrix, bottom, col_start + 1, target);
//         } else if (matrix[bottom][col_start] == target) {
//             return 1 + helper(matrix, bottom - 1, col_start + 1, target);
//         } else if (matrix[up][col_start] < target) {
//             return helper(matrix, up, col_start + 1, target);
//         } else if (matrix[up][col_start] == target) {
//             return 1 + helper(matrix, up - 1, col_start + 1, target);
//         } else {
//             return helper(matrix, up - 1, col_start, target);
//         }
//     }
    
//     private int searchRow(int[][] matrix, int row_end, int col_start, int target) {
//         int left = col_start;
//         int right = matrix[0].length - 1;
//         while (left + 1 < right) {
//             int mid = left + (right - left) / 2;
//             if (matrix[row_end][mid] == target) {
//                 return 1;
//             } else if (matrix[row_end][mid] < target) {
//                 left = mid;
//             } else {
//                 right = mid;
//             }
//         }
//         return (matrix[row_end][left] == target || matrix[row_end][right] == target) ? 1 : 0;
//     }
    
//     private int searchCol(int[][] matrix, int row_end, int col_start, int target) {
//         int up = 0;
//         int bottom = row_end;
//         while (up + 1 < bottom) {
//             int mid = up + (bottom - up) / 2;
//             if (matrix[mid][col_start] == target) {
//                 return 1;
//             } else if (matrix[mid][col_start] < target) {
//                 up = mid;
//             } else {
//                 bottom = mid;
//             }
//         }
//         return (matrix[up][col_start] == target || matrix[bottom][col_start] == target) ? 1 : 0;
//     }
// }
// public class Solution {
//     /**
//      * @param matrix: A list of lists of integers
//      * @param: A number you want to search in the matrix
//      * @return: An integer indicate the occurrence of target in the given matrix
//      */
//     public int searchMatrix(int[][] matrix, int target) {
//         // write your code here
//         if (matrix == null || matrix.length == 0) {
//             return 0;
//         }
//         int row_start = 0;
//         int row_end = matrix.length - 1;
//         int row_mid = 0;
//         while (row_start <= row_end) {
//             row_mid = row_start + (row_end - row_start) / 2;
//             if (matrix[row_mid][0] == target) {
//                 break;
//             } else if (matrix[row_mid][0] > target) {
//                 row_end = row_mid - 1;
//             } else {
//                 row_start = row_mid + 1;
//             }
//         }
//         int row_loc = 0;
//         if (matrix[row_mid][0] <= target) {
//             row_loc = row_mid;
//         } else {
//             row_loc = row_mid - 1;
//         }
//         if (row_loc < 0) {
//             return 0;
//         }
//         int occur = 0;
//         int col_start = 0;
//         int col_end = matrix[0].length - 1;
//         int col_mid = 0;
//         for (int i = 0; i <= row_loc; i++) {
//             col_start = 0;
//             col_end = matrix[0].length - 1;
//             while (col_start <= col_end) {
//                 col_mid = col_start + (col_end - col_start) / 2;
//                 if (matrix[i][col_mid] == target) {
//                     occur++;
//                     break;
//                 } else if (matrix[i][col_mid] > target) {
//                     col_end = col_mid - 1;
//                 } else {
//                     col_start = col_mid + 1;
//                 }
//             }
//         }
//         return occur;
//     }
// }
