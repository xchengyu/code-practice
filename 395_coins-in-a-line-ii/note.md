```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/coins-in-a-line-ii
@Language: Markdown
@Datetime: 17-01-18 07:25
```

        //definition of dp[i]: player A and player B play this game, player A plays first. dp[i] means When there are i coins left, the maximum value player can get from these i coins. If dp[n] > total value of these n coins / 2, then player A will win.
        if (values.length < 3) {
            return true;
        }
        int[] sum = new int[values.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + values[values.length - i];
        }
        int[] dp = new int[values.length + 1];
        dp[0] = sum[0];
        dp[1] = sum[1];
        dp[2] = sum[2];
        for (int i = 3; i < dp.length; i++) {
            dp[i] = Math.max(sum[i] - dp[i - 1], sum[i] - dp[i - 2]);
        }
        return dp[values.length] > sum[values.length] / 2;