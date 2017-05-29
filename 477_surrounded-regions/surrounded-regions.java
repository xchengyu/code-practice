/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/surrounded-regions
@Language: Java
@Datetime: 17-05-26 08:43
*/

class Solution {
    static final int[] directionX = {+1, -1, 0, 0};
    static final int[] directionY = {0, 0, +1, -1};
    
    static final char FREE = 'F';
    
    public void surroundedRegions(char[][] board) {
        if (board.length == 0) {
            return;
        }
        
        int row = board.length;
        int col = board[0].length;
        
        for (int i = 0; i < row; i++) {
            // bfs(board, i, 0);
            // bfs(board, i, col - 1);
            dfs(board, i, 0);
            dfs(board, i, col - 1);
        }
        
        for (int j = 1; j < col - 1; j++) {
            // bfs(board, 0, j);
            // bfs(board, row - 1, j);
            dfs(board, 0, j);
            dfs(board, row - 1, j);
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                switch(board[i][j]) {
                    case 'O': 
                        board[i][j] = 'X';
                        break;
                    case 'F':
                        board[i][j] = 'O';
                }
            }
        }
    }
    public void dfs(char[][] board, int x, int y) {
        if (board[x][y] != 'O') {
            return;
        }
        int row = board.length;
        int col = board[0].length;
        board[x][y] = FREE;
        for (int i = 0; i < directionX.length; i++) {
            int newX = x + directionX[i];
            int newY = y + directionY[i];
            if (newX < 0 || newX >= row || newY < 0 || newY >= col || board[newX][newY] != 'O') {
                continue;
            } else {
                dfs(board, newX, newY);
            }
        }
        return;
    }
    // public void bfs(char[][] board, int i, int j) {
    //     if (board[i][j] != 'O') {
    //         return;
    //     }
        
    //     Queue<Node> queue = new LinkedList<Node>();
    //     queue.offer(new Node(i, j));
        
    //     while (!queue.isEmpty()) {
    //         Node crt = queue.poll();
    //         board[crt.x][crt.y] = FREE;
            
    //         for (Node node : expand(board, crt)) {
    //             queue.offer(node);
    //         }
    //     }
    // }
    
    // private List<Node> expand(char[][] board, Node node) {
    //     List<Node> expansion = new ArrayList<Node>();
        
    //     for (int i = 0; i < directionX.length; i++) {
    //         int x = node.x + directionX[i];
    //         int y = node.y + directionY[i];
            
    //         // check validity
    //         if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 'O') {
    //             expansion.add(new Node(x, y));
    //         }
    //     }
        
    //     return expansion;
    // }
    
    static class Node {
        int x;
        int y;
        
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}