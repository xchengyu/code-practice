```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/paint-fence
@Language: Markdown
@Datetime: 16-08-06 02:00
```

这题目很有意思. 一开始分析的太复杂, 最后按照这个哥们的想法（http://yuanhsh.iteye.com/blog/2219891） 的来做，反而简单了许多。
设定T（n）的做法，最后题目化简以后就跟Fibonacci number一样一样的。详细分析如下。
因为最多2个fence 颜色相同。
假设i是和 i-1不同，那么结果就是 (k-1)*dp[i - 1]
假设i是何 i-1相同，那么根据条件，i-1和i-2肯定不同。那么所有的结果就是(k-1)*dp[i-2]
加在一起就有了。
should spend more time to considering corner cases