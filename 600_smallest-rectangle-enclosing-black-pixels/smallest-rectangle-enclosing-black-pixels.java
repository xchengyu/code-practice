/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/smallest-rectangle-enclosing-black-pixels
@Language: Java
@Datetime: 17-01-22 10:14
*/

public class Solution {
    /**
     * @param image a binary matrix with '0' and '1'
     * @param x, y the location of one of the black pixels
     * @return an integer
     */
    int left;
    int right;
    int up;
    int down;
    public int minArea(char[][] image, int x, int y) {
        // Write your code here
        if (image == null || image.length == 0 || image[0].length == 0) {
            return 0;
        }
        left = y;
        right = y;
        up = x;
        down = x;
        Set<Integer> visited = new HashSet<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        int row = image.length;
        int col = image[0].length;
        queue.offer(getId(x, y, col));
        visited.add(getId(x, y, col));
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        boolean findZero = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (image[i][j] == '0') {
                    findZero = true;
                    break;
                }
            }
        }
        if (!findZero) {
            return row * col;
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int id = queue.poll();
                int tmp_x = id / col;
                int tmp_y = id % col;
                for (int j = 0; j < 4; j++) {
                    int newX = tmp_x + dx[j];
                    int newY = tmp_y + dy[j];
                    if (newX >= 0 && newX < row && newY >= 0 && newY < col) {
                        int newId = getId(newX, newY, col);
                        if (!visited.contains(newId) && image[newX][newY] == '1') {
                            queue.offer(newId);
                            visited.add(newId);
                            left = Math.min(left, newY);
                            right = Math.max(right, newY);
                            up = Math.min(up, newX);
                            down = Math.max(down, newX);
                        }
                    }
                }
            }
        }
        return (right - left + 1) * (down - up + 1);
    }
    public int getId(int x, int y, int col) {
        return x * col + y;
    }
}