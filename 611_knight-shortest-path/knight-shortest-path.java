/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/knight-shortest-path
@Language: Java
@Datetime: 17-01-22 09:53
*/

/**
 * Definition for a point.
 * public class Point {
 *     publoc int x, y;
 *     public Point() { x = 0; y = 0; }
 *     public Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param grid a chessboard included 0 (false) and 1 (true)
     * @param source, destination a point
     * @return the shortest path 
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        Set<Integer> visited = new HashSet<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        int row = grid.length;
        int col = grid[0].length;
        int srcId = getId(source, col);
        int desId = getId(destination, col);
        if (srcId == desId) {
            return 0;
        }
        queue.offer(srcId);
        visited.add(srcId);
        int step = -1;
        int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int id = queue.poll();
                if (id == desId) {
                    return step;
                }
                int x = id / col;
                int y = id % col;
                for (int j = 0; j < 8; j++) {
                    int newX = x + dx[j];
                    int newY = y + dy[j];
                    if (newX >= 0 && newX < row && newY >= 0 && newY < col) {
                        int newId = getId(new Point(newX, newY), col);
                        if (visited.contains(newId) || grid[newX][newY]) {
                            continue;
                        } else {
                            queue.offer(newId);
                            visited.add(newId);
                        }
                    }
                }
                
            }
        }
        return -1;
    }
    public int getId(Point point, int col) {
        return point.x * col + point.y;
    }
}