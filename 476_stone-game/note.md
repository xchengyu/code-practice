```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/stone-game
@Language: Markdown
@Datetime: 17-01-16 07:28
```

public class Solution {
    /**
     * @param A an integer array
     * @return an integer
     */
    public int stoneGame(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int[] sum = new int[A.length + 1];
        int[][] dp = new int[A.length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < A.length; i++) {
            dp[i][i] = 0;
            sum[i + 1] = sum[i] + A[i];
        }
        return search(0, A.length - 1, A, dp, sum);
    }
    public int search(int start, int end, int[] A, int[][] dp, int[] sum) {
        if (dp[start][end] != Integer.MAX_VALUE) {
            return dp[start][end];
        }
        int min = Integer.MAX_VALUE;
        for (int k = start; k < end; k++) {
            int left = search(start, k, A, dp, sum);
            int right = search(k + 1, end, A, dp, sum);
            int total = sum[end + 1] - sum[start];
            min = Math.min(min, left + right + total);
        }
        dp[start][end] = min;
        return dp[start][end];
    }
}