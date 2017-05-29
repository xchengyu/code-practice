```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/distinct-subsequences
@Language: Markdown
@Datetime: 16-08-17 04:56
```

"How many ways can you generate the string T by only removing (but not reordering) characters in S?"
if (S == null || T == null) {
            return 0;
        }
        int m = S.length();
        int n = T.length();
        int[] res = new int[n + 1];
        res[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                res[j + 1] = (S.charAt(i) == T.charAt(j) ? res[j] : 0) + res[j + 1];
            }
        }
        return res[n];
		
• state: f[i][j] 表示 S的前i个字符中选取T的前j个字符，有多少种方案
• function: f[i][j] = f[i - 1][j] + f[i - 1][j - 1] // S[i-1] == T[j-1]
• = f[i - 1][j] // S[i-1] != T[j-1]
• initialize: f[i][0] = 1, f[0][j] = 0 (j > 0)
• answer: f[n][m] (n = sizeof(S), m = sizeof(T))