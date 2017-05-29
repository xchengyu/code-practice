```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/interleaving-string
@Language: Markdown
@Datetime: 16-08-07 07:49
```

  如果熟悉动态规划的LCS和ED问题的话，不难看出这是个dp题目.首先，我们定义如下状态:

dp[i+1][j+1]:表示s1[0...i]与s2[0...j]能否交替形成s3[0...i+j+1]部分.

状态转移方程:

    dp[i+1][j+1] = (dp[i][j+1] && s1[i] == s3[i+j+1]) | (dp[i+1][j] && s2[j] == s3[i+j+1]);