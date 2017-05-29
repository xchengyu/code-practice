```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/maximum-subarray-v
@Language: Markdown
@Datetime: 17-03-19 05:34
```

Use a linkedlist to store all possible prefix index, the elements in this list are stored in ascending order according to sum[prefix_index], so some useless prefix index are not stored because there are other better choices in this list.