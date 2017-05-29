```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/longest-repeating-subsequence
@Language: Markdown
@Datetime: 17-01-13 07:55
```

public class Solution {
    /**
     * @param str a string
     * @return the length of the longest repeating subsequence
     */
    public int longestRepeatingSubsequence(String str) {
        // Write your code here
        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = 0;
            }
        }
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1); 
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][n];
    }
}