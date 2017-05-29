```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/trapping-rain-water-ii
@Language: Markdown
@Datetime: 16-09-01 08:41
```

class Cell {
    public int x;
    public int y;
    public int h;
    public Cell (int x, int y, int h) {
        this.x = x;
        this.y = y;
        this.h = h;
    }
}
class Order implements Comparator<Cell> {
    public int compare(Cell a, Cell b) {
        if (a.h > b.h) {
            return 1;
        }
        if (a.h == b.h) {
            return 0;
        }
        return -1;
    }
}
public class Solution {
    /**
     * @param heights: a matrix of integers
     * @return: an integer
     */
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public int trapRainWater(int[][] heights) {
        // write your code here
        if(heights.length == 0)  
        return 0;
        PriorityQueue<Cell> q =  new PriorityQueue<Cell>(1,new Order());
        int n = heights.length;
        int m = heights[0].length;
        int [][]visit = new int[n][m];
        for (int i = 0; i < n; i++) {
            visit[i][0] = 1;
            q.offer(new Cell(i, 0, heights[i][0]));
            visit[i][m - 1] = 1;
            q.offer(new Cell(i, m - 1, heights[i][m - 1]));
        }
        for (int i = 0; i < m; i++) {
            visit[0][i] = 1;
            q.offer(new Cell(0, i, heights[0][i]));
            visit[n - 1][i] = 1;
            q.offer(new Cell(n - 1, i, heights[n - 1][i]));
        }
        int ans = 0;
        while (!q.isEmpty()) {
            Cell now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && visit[nx][ny] == 0) {
                    q.offer(new Cell(nx, ny, Math.max(now.h, heights[nx][ny])));
                    visit[nx][ny] = 1;
                    ans += Math.max(0, now.h - heights[nx][ny]);
                }
            }
        }
        return ans;
    }
};