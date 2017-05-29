/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/spiral-matrix
@Language: Java
@Datetime: 17-01-18 09:37
*/

public class Solution {
    /**
     * @param matrix a matrix of m x n elements
     * @return an integer list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // Write your code here
        List<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int indent = 0;
        while (indent * 2 < row && indent * 2 < col) {
            for (int i = indent; i < col - indent; i++) {
                res.add(matrix[indent][i]);
            }
            for (int i = indent + 1; i <= row - indent - 1; i++) {
                res.add(matrix[i][col - 1 - indent]);
            }
            
            if (indent * 2 + 1 == row || indent * 2 + 1 == col) {
                return res;
            }
            
            for (int i = col - indent - 2; i >= indent; i--) {
                res.add(matrix[row - 1 - indent][i]);
            }
            for (int i = row - indent - 2; i >= indent + 1; i--) {
                res.add(matrix[i][indent]);
            }
            
            indent++;
        }
        return res;
    }
}