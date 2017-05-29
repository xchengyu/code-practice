```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/minimum-adjustment-cost
@Language: Markdown
@Datetime: 17-01-27 10:01
```

最小调整代价
state：f【i】【k】, 前i个数，当第i个树调整为k并且满足相邻两数差小于target的时候所需的最小调整代价
function： f【i】【k】= min{f【i-1】【k1】+ Math.abs(A[i] - k)}, 其中Math.abs(k - k1) <= target
answer：min f【A.length】【k】k from 1 to 100.
target不会超过100，因为数组中的数都为正数且都不超过100
        // 最小调整代价
        // state：f【i】【k】, 前i个数，当第i个树调整为k并且满足相邻两数差小于target的时候所需的最小调整代价
        // function： f【i】【k】= min{f【i-1】【k1】+ Math.abs(A[i] - k)}, 其中Math.abs(k - k1) <= target
        // answer：min f【A.length】【k】k from 1 to 100.
        // target不会超过100，因为数组中的数都为正数且都不超过100
        if (A == null || A.size() == 0) {
            return 0;
        }
        int size = A.size();
        int[][] dp = new int[size + 1][101];
        for (int i = 0; i < size + 1; i++) {
            for (int j = 0; j < 101; j++) {
                if (i == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 1; i < size + 1; i++) {
            for (int j = 0; j < 101; j++) {
                for (int k = 0; k < 101; k++) {
                    if (Math.abs(j - k) > target) {
                        continue;
                    }else {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.abs(A.get(i - 1) - j));
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 101; i++) {
            res = Math.min(res, dp[size][i]);
        }
        return res;