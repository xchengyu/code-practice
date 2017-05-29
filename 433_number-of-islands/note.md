```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/number-of-islands
@Language: Markdown
@Datetime: 17-05-18 06:46
```

public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public int numIslands(boolean[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j]) {
                    removeIsland(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    public void removeIsland(boolean[][] grid, int x, int y) {
        grid[x][y] = false;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY= y + dy[i];
            if (nextX >= 0 && nextX < row && nextY >= 0 && nextY < col) {
                if (grid[nextX][nextY]) {
                    removeIsland(grid, nextX, nextY);
                }
            }
        }
        return;
    }
}