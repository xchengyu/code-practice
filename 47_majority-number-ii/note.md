```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/majority-number-ii
@Language: Markdown
@Datetime: 16-08-16 05:19
```

三三抵销法，但是也有需要注意的地方：

1. 我们对cnt1,cnt2减数时，相当于丢弃了3个数字（当前数字，candidate1, candidate2）。也就是说，每一次丢弃数字，我们是丢弃3个不同的数字。

而Majority number超过了1/3所以它最后一定会留下来。

设定总数为N, majority number次数为m。丢弃的次数是x。则majority 被扔的次数是x

而m > N/3, N - 3x >= 0. 

3m > N,  N >= 3x 所以 3m > 3x, m > x 也就是说 m一定没有被扔完

最坏的情况，Majority number每次都被扔掉了，但它一定会在n1,n2中。

2. 为什么最后要再检查2个数字呢(从头开始统计，而不用剩下的count1, count2)？因为数字的编排可以让majority 数被过度消耗，使其计数反而小于n2，或者等于n2.前面举的例子即是。

另一个例子：

1 1 1 1 2 3 2 3 4 4 4 这个 1就会被消耗过多，最后余下的反而比4少。