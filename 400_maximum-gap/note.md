```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/maximum-gap
@Language: Markdown
@Datetime: 16-07-18 08:31
```

改进版的bucket sort， 普通bucket sort坐标区间长度为1，但是这个版本的坐标区间长度为最大值与最小值的差平均分成n - 1份的长度，这样使bucket的size减小了，我们只要再额外维护两个数组，一个数组表示bucket 中某一区间内最小值，另一个表示bucket中某一区间内最大值，求diff时，只用拿后一个区间的最大值减去前一个区间的最小值即可