/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/longest-increasing-continuous-subsequence-ii
@Language: Java
@Datetime: 16-07-16 04:51
*/

public class Solution {
    int[][] visit;
    int[][] dp;
    int row;
    int col;
    /**
     * @param A an integer matrix
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        row = A.length;
        col = A[0].length;
        visit = new int[row][col];
        dp = new int[row][col];
        int ans = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = search(A, i, j);
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
    int[] dx = {1, -1, 0 ,0};
    int[] dy = {0, 0, 1, -1};
    public int search(int[][] A, int x, int y) {
        if (visit[x][y] == 1) {
            return dp[x][y];
        }
        int ans = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < row && ny >= 0 && ny < col && A[nx][ny] > A[x][y]) {
                ans = Math.max(ans, search(A, nx, ny) + 1);
            }
        }
        dp[x][y] = ans;
        visit[x][y] = 1;
        return dp[x][y];
    }
}