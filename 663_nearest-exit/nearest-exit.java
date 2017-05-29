/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/nearest-exit
@Language: Java
@Datetime: 17-05-18 07:35
*/

class Node {
    public int x;
    public int y;
    public int val;
    public Node(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
public class Solution {
    /**
     * @param rooms m x n 2D grid
     * @return nothing
     */
    public static final int INF = 2147483647;
    public void wallsAndGates(int[][] rooms) {
        // Write your code here
        if (rooms == null || rooms.length == 0) {
            return;
        }
        int row = rooms.length;
        int col = rooms[0].length;
        Queue<Node> queue = new LinkedList<Node>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new Node(i, j, 0));
                }
            }
        }
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int newX = cur.x + dx[i];
                int newY = cur.y + dy[i];
                if (newX >= 0 && newX < row && newY >= 0 && newY < col && rooms[newX][newY] == INF) {
                    int newVal = cur.val + 1;
                    rooms[newX][newY] = newVal;
                    queue.offer(new Node(newX, newY, newVal));
                }
            }
        }
        return;
    }
}