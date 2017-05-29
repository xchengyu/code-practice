/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/build-post-office-ii
@Language: Java
@Datetime: 16-09-18 19:33
*/

public class Solution {
    /**
     * @param grid a 2D grid
     * @return an integer
     */
    public int shortestDistance(int[][] grid) {
        // Write your code here
        if (grid == null) {
            return -1;
        }
        int row = grid.length;
        if (row == 0) {
            return -1;
        }
        int col = grid[0].length;
        if (col == 0) {
            return -1;
        }
        int houseNumber = 0;
        int[][] dist = new int[row][col];
        int[][] reach = new int[row][col];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    houseNumber++;
                    int level = 0;
                    Set<Integer> visited = new HashSet<Integer>();
                    Queue<Integer> queue = new LinkedList<Integer>();
                    queue.offer(i * col + j);
                    visited.add(i * col + j);
                    while (!queue.isEmpty()) {
                        level++;
                        int size = queue.size();
                        for (int s = 0; s < size; s++) {
                            int index = queue.poll();
                            int curX = index / col;
                            int curY = index % col;
                            for (int t = 0; t < 4; t++) {
                                int newX = curX + dx[t];
                                int newY = curY + dy[t];
                                if (newX >= 0 && newX < row && newY >= 0 && 
                                    newY < col && grid[newX][newY] == 0 && 
                                    !visited.contains(newX * col + newY)) {
                                        dist[newX][newY] += level;
                                        reach[newX][newY]++;
                                        queue.offer(newX * col + newY);
                                        visited.add(newX * col + newY);
                                    }
                            }
                        }
                    }
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 && reach[i][j] == houseNumber) {
                    result = Math.min(result, dist[i][j]);
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}