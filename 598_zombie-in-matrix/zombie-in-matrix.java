/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/zombie-in-matrix
@Language: Java
@Datetime: 17-01-22 08:54
*/

public class Solution {
    /**
     * @param grid  a 2D integer grid
     * @return an integer
     */
    public int zombie(int[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> people = new HashSet<Integer>();
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(getId(i, j, col));
                } else if (grid[i][j] == 0) {
                    people.add(getId(i, j, col));
                } else {
                    continue;
                }
            }
        }
        int step = 0;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int id = queue.poll();
                int x = id / col;
                int y = id % col;
                for (int j = 0; j < 4; j++) {
                    int newX = x + dx[j];
                    int newY = y + dy[j];
                    if (newX >= 0 && newX < row && newY >= 0 && newY < col) {
                        int newId = getId(newX, newY, col);
                        if (people.contains(newId)) {
                            queue.offer(newId);
                            people.remove(newId);
                        }
                    }
                }
            }
            if (people.size() == 0) {
                return step;
            }
        }
        return -1;
    }
    
    public int getId(int row, int col, int total_col) {
        return row * total_col + col;
    }
}