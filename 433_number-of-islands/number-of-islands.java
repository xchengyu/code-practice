/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/number-of-islands
@Language: Java
@Datetime: 17-05-18 06:46
*/

public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j]) {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    private void dfs(boolean[][] grid, int x, int y) {
        int row = grid.length;
        int col = grid[0].length;
        if (x < 0 || x >= row || y < 0 || y >= col) {
            return;
        }
        if (!grid[x][y]) {
            return;
        }
        grid[x][y] = false;
        for (int i = 0; i < dx.length; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            dfs(grid, newX, newY);
        }
        return;
    }
}