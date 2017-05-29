/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/copy-books
@Language: Java
@Datetime: 16-07-16 07:31
*/

public class Solution {
    /**
     * @param pages: an array of integers
     * @param k: an integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        if (pages == null || pages.length == 0) {
            return 0;
        }
        int m = pages.length;
        int[] sum = new int[m + 1];
        int[] max = new int[m + 1];
        sum[0] = 0;
        max[0] = 0;
        for (int i = 1; i <= m; i++) {
            sum[i] = sum[i - 1] + pages[i - 1];
            max[i] = Math.max(max[i - 1], pages[i - 1]);
        }
        int[][] dp = new int[m + 1][k + 1];
        int[][] flag = new int[m + 1][k + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= k; j++) {
                if (i == 0) {
                    dp[i][j] = 0;
                    flag[i][j] = 1;
                } else if (i != 0 && j == 0){
                    dp[i][j] = Integer.MAX_VALUE;
                    flag[i][j] = 1;
                } else if (i <= j) {
                    dp[i][j] = max[i];
                    flag[i][j] = 1;
                }
            }
        }
        return search(m, k, dp, flag, sum);
    }
    public int search(int book, int people, int[][] dp, int[][] flag, int[] sum) {
        if (flag[book][people] == 1) {
            return dp[book][people];
        }
        flag[book][people] = 1;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < book; i++) {
            int tmp = Math.max(search(i, people - 1, dp, flag, sum), sum[book] - sum[i]);
            ans = Math.min(ans, tmp);
        }
        dp[book][people] = ans;
        return dp[book][people];
    }
}