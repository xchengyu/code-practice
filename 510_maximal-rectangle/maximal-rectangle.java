/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/maximal-rectangle
@Language: Java
@Datetime: 16-07-20 09:15
*/

public class Solution {
    /**
     * @param matrix a boolean 2D matrix
     * @return an integer
     */
    public int maximalRectangle(boolean[][] matrix) {
        // Write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] bar = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!matrix[i][j]) {
                    bar[i][j] = 0;
                } else {
                    bar[i][j] = i == 0 ? 1 : bar[i - 1][j] + 1;//第i行第j列往上数有多少个连续的1.
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < row; i++) {//这段代码就是在每一行求解一个Largest Rectangle in Histogram，然后选出最大的值。
            Stack<Integer> stack = new Stack<Integer>();//栈中存放的是index，每个index对应的bar的高度依次递增
            for (int j = 0; j <= col; j++) {
                int height = j == col ? -1 : bar[i][j];
                while (!stack.isEmpty() && height < bar[i][stack.peek()]) {
                    int index = stack.pop();
                    int tmp = bar[i][index];
                    max = Math.max(max, tmp * (stack.isEmpty() ? j : j - stack.peek() - 1));//仔细思考这两个取值，很有趣
                }//接上一话题，栈为空时说明在j之前，所有bar的高度都大于等于tmp;栈不为空时，从s.peek() + 1 到 j - 1这些bar的高度大于等于tmp。
                stack.push(j);
            }
        }
        return max;
    }
}