```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/decode-ways
@Language: Markdown
@Datetime: 17-05-04 01:32
```

public class Solution {
    /**
     * @param s a string,  encoded message
     * @return an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        // int[] dp = new int[s.length() + 1];
        // dp[0] = 1;
        // for (int i = 1; i < s.length() + 1; i++) {
        //     if (s.charAt(i - 1) != '0') {
        //         dp[i] += dp[i - 1];
        //     }
        //     if (i >= 2 && isValid(s.substring(i - 2, i))) {
        //         dp[i] += dp[i - 2];
        //     }
        // }
        // return dp[s.length()];
        int preways = 0;
        int curways = 1;
        for (int i = 1; i < s.length() + 1; i++) {
            int newways = 0;
            if (s.charAt(i - 1) != '0') {
                newways += curways;
            }
            if (i >= 2 && isValid(s.substring(i - 2, i))) {
                newways += preways;
            }
            preways = curways;
            curways = newways;
        }
        return curways;
    }
    private boolean isValid(String s) {
        if (s.charAt(0) == '0') {
            return false;
        }
        int num = Integer.parseInt(s);
        if (num < 1 || num > 26) {
            return false;
        }
        return true;
    }
}