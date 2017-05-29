```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/word-search
@Language: Markdown
@Datetime: 17-01-25 07:08
```

是否超时与helper函数中的搜索顺序有关
public boolean exist(char[][] board, String word) {
        // write your code here
        if (board == null || board.length == 0) {
            return false;
        }
        if (word.length() == 0) {
                return true;
        }
        if (board[0].length == 0) 
        {
            return false;
        }
        int row = board.length;
        int col = board[0].length;
        if (row * col < word.length()) {
            return false;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if(helper(board, i, j, 0, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean helper(char[][] board, int x, int y, int index, String word) {
        if (index == word.length()) {
            return true;
        }
        int row = board.length;
        int col = board[0].length;
        if (x < 0 || x >= row || y < 0 || y >= col || board[x][y] != word.charAt(index)) {
            return false;
        }
        board[x][y] = '#';
        boolean result = (helper(board, x + 1, y, index + 1, word) || helper(board, x - 1, y, index + 1, word) || helper(board, x, y + 1, index + 1, word) || helper(board, x, y - 1, index + 1, word));
        board[x][y] = word.charAt(index);
        return result;
    }
    //     public boolean exist(char[][] board, String word) {
    //     // write your code here
    //     if (board == null || board.length == 0) {
    //         return false;
    //     }
    //     if (board[0].length == 0) 
    //     {
    //         return false;
    //     }
    //     if (word.length() == 0) {
    //         return true;
    //     }
    //     int row = board.length;
    //     int col = board[0].length;
    //     if (row * col < word.length()) {
    //         return false;
    //     }
    //     int[][] visit = new int[row][col];
    //     for (int i = 0; i < row; i++) {
    //         for (int j = 0; j < col; j++) {
    //             if (board[i][j] == word.charAt(0)) {
    //                 if(helper(board, visit, i, j, 0, word)) {
    //                     return true;
    //                 }
    //             }
    //         }
    //     }
    //     return false;
    // }
    // public boolean helper(char[][] board, int[][] visit, int x, int y, int index, String word) {
    //     if (index == word.length()) {
    //         return true;
    //     }
    //     int row = board.length;
    //     int col = board[0].length;
    //     if (x < 0 || x >= row || y < 0 || y >= col || visit[x][y] == 1 || board[x][y] != word.charAt(index)) {
    //         return false;
    //     }
    //     visit[x][y] = 1;
    //     int[] dx = {0, 0, 1, -1};
    //     int[] dy = {1, -1, 0, 0};
    //     for (int i = 0; i < 4; i++) {
    //         int nx = x + dx[i];
    //         int ny = y + dy[i];
    //         if(helper(board, visit, nx, ny, index + 1, word)) {
    //             return true;
    //         }
    //     }
    //     visit[x][y] = 0;
    //     return false;
    // }