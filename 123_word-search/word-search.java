/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/word-search
@Language: Java
@Datetime: 17-01-25 07:08
*/

public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // write your code here
        if (word == null || word.length() == 0) {
            return true;
        }
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (search(board, word, i, j, 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public boolean search(char[][] board, String word, int x, int y, int index) {
        if (index == word.length()) {
            return true;
        }
        // if (word.charAt(index) != board[x][y]) {
        //     return false;
        // }
        int row = board.length;
        int col = board[0].length;
        char origin = board[x][y];
        board[x][y] = '#';
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < row && nextX >= 0 && nextY < col && nextY >= 0 && word.charAt(index) == board[nextX][nextY]) {
                if (search(board, word, nextX, nextY, index + 1)) {
                    board[x][y] = origin;
                    return true;
                }
            }
        }
        board[x][y] = origin;
        return false;
    }
}