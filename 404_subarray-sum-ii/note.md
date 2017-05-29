```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/subarray-sum-ii
@Language: Markdown
@Datetime: 16-07-19 05:43
```

这题是玩数学的。find函数的作用是返回第一个比value值大的元素的index。cnt += find(A, len, r+1) - find(A, len, l); 这句话的作用是找到一个值A【j】，使得A【j】的值在【l, r】间，这样就有：
A【i】 - end <= A【j】<= A【i】 -  start， 变换一下后就有 start <= A【i】- A【j】<= end。
注意，在cnt += find(A, len, r+1) - find(A, len, l);这句话中，按照道理计算连续元素的个数的时候应该是末项减首项除以公差加一，这里没有加一的原因是find(A, len, r+1)找到的是第一个大于等于r+1的元素index，而我们想找的是小于等于r并且大于等于l的元素，cnt += find(A, len, r+1) - find(A, len, l);求出来的是大于等于l并且小于r+1的元素外加一个第一个大于等于r+1的元素，我们舍弃末项后就得到了大于等于l并且小于r+1即小于等于r的元素序列。