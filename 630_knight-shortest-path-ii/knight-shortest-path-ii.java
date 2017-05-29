/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/knight-shortest-path-ii
@Language: Java
@Datetime: 17-03-03 08:50
*/

// public class Solution {
//     /**
//      * @param grid a chessboard included 0 and 1
//      * @return the shortest path
//      */
//     int[] dx = {1, -1, 2, -2};
//     int[] dy = {2, 2, 1, 1};
//     public int shortestPath2(boolean[][] grid) {
//         // Write your code here
//         if (grid == null || grid.length == 0 || grid[0].length == 0) {
//             return -1;
//         }
//         int row = grid.length;
//         int col = grid[0].length;
//         int[][] steps = new int[row][col];
//         for (int i = 0; i < row; i++) {
//             for (int j = 0; j < col; j++) {
//                 if (isLastStep(i, j, row - 1, col - 1)) {
//                     steps[i][j] = 1;
//                 } else {
//                     steps[i][j] = Integer.MAX_VALUE;
//                 }
//             }
//         }
//         helper(0, 0, steps, grid);
//         return steps[0][0] == Integer.MAX_VALUE ? -1 : steps[0][0];
//     }
//     private boolean isLastStep(int x, int y, int last_x, int last_y) {
//         if (x + 1 == last_x && y + 2 == last_y) {
//             return true;
//         }
//         if (x - 1 == last_x && y + 2 == last_y) {
//             return true;
//         }
//         if (x + 2 == last_x && y + 1 == last_y) {
//             return true;
//         }
//         if (x - 2 == last_x && y + 1 == last_y) {
//             return true;
//         }
//         return false;
//     }
//     private int helper(int x, int y, int[][] steps, boolean[][] grid) {
//         int row = grid.length;
//         int col = grid[0].length;
//         if (x < 0 || x >= row || y < 0 || y >= col || grid[x][y] == true) {
//             return Integer.MAX_VALUE;
//         }
//         if (steps[x][y] != Integer.MAX_VALUE) {
//             return steps[x][y];
//         }
//         int min = Integer.MAX_VALUE;
//         for (int i = 0; i < 4; i++) {
//             int nextX = x + dx[i];
//             int nextY = y + dy[i];
//             min = Math.min(min, helper(nextX, nextY, steps, grid));
//         }
//         steps[x][y] = min == Integer.MAX_VALUE ? min : 1 + min;
//         return steps[x][y];
//     }
// }
class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Solution {
    int n, m; // size of the chessboard
    int[] deltaX = {1, -1, 2, -2};
    int[] deltaY = {2, 2, 1, 1};
    /**
     * @param grid a chessboard included 0 (false) and 1 (true)
     * @param source, destination a point
     * @return the shortest path 
     */
    public int shortestPath2(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int row = grid.length;
        int col = grid[0].length;
        return shortestPath(grid, new Point(0, 0), new Point(row - 1, col - 1));
    }
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        n = grid.length;
        m = grid[0].length;
        
        Queue<Point> queue = new LinkedList<>();
        queue.offer(source);
        
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                if (point.x == destination.x && point.y == destination.y) {
                    return steps;
                }
                
                for (int direction = 0; direction < 4; direction++) {
                    Point nextPoint = new Point(
                        point.x + deltaX[direction],
                        point.y + deltaY[direction]
                    );
                    
                    if (!inBound(nextPoint, grid)) {
                        continue;
                    }
                    
                    queue.offer(nextPoint);
                    // mark the point not accessible
                    grid[nextPoint.x][nextPoint.y] = true;
                }
            }
            steps++;
        }
        
        return -1;
    }
    
    private boolean inBound(Point point, boolean[][] grid) {
        if (point.x < 0 || point.x >= n) {
            return false;
        }
        if (point.y < 0 || point.y >= m) {
            return false;
        }
        return (grid[point.x][point.y] == false);
    }
}