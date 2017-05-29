/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/trapping-rain-water-ii
@Language: Java
@Datetime: 16-09-01 08:41
*/

class Cell {
    public int x;
    public int y;
    public int h;
    public Cell(int x, int y, int h) {
        this.x = x;
        this.y = y;
        this.h = h;
    }
}
class Order implements Comparator<Cell> {
    public int compare(Cell a, Cell b) {
        return a.h - b.h;
    }
}
public class Solution {
    /**
     * @param heights: a matrix of integers
     * @return: an integer
     */
    private int[] dx = {1, -1, 0, 0};
    private int[] dy = {0, 0, 1, -1};
    public int trapRainWater(int[][] heights) {
        // write your code here
        int row = heights.length;
        int col = heights[0].length;
        int[][] visited = new int[row][col];
        Queue<Cell> queue = new PriorityQueue<Cell>(row * col, new Order());
        for (int i = 0; i < row; i++) {
            visited[i][0] = 1;
            visited[i][col - 1] = 1;
            queue.offer(new Cell(i, 0, heights[i][0]));
            queue.offer(new Cell(i, col - 1, heights[i][col - 1]));
        }
        for (int i = 0; i < col; i++) {
            visited[0][i] = 1;
            visited[row - 1][i] = 1;
            queue.offer(new Cell(0, i, heights[0][i]));
            queue.offer(new Cell(row - 1, i, heights[row - 1][i]));
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            Cell cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = cur.x + dx[i];
                int newY = cur.y + dy[i];
                if (newX >= 0 && newX < row && newY >= 0 && newY < col && visited[newX][newY] != 1) {
                    visited[newX][newY] = 1;
                    queue.offer(new Cell(newX, newY, Math.max(cur.h, heights[newX][newY])));
                    ans += Math.max(0, cur.h - heights[newX][newY]);
                }
            }
        }
        return ans;
    }
};