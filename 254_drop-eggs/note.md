```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/drop-eggs
@Language: Markdown
@Datetime: 17-01-12 10:43
```

所以上述方法的最坏情况是19次，那么有没有更少的方法呢，上面那个方法每多扔一次鸡蛋1，鸡蛋2的线性搜索次数最多还是10次，那么最坏情况肯定会增加，所以我们需要让每多扔一次鸡蛋1，鸡蛋2的线性搜索最坏情况减少1，这样恩能够保持整体最坏情况的平衡，那么我们假设鸡蛋1第一次在第X层扔，然后向上X-1层扔一次，然后向上X-2层扔，以此类推直到100层，那么我们通过下面的公式求出X：

X + (X-1) + (X-2) + ... + 1 = 100 -> X = 14
http://www.cnblogs.com/grandyang/p/4762756.html