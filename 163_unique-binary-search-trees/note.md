```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/unique-binary-search-trees
@Language: Markdown
@Datetime: 16-12-27 07:34
```

当节点数为n的时候，左右子树节点个数可能的情况有：（0，n - 1）, (1, n - 2), ........, (n - 2, 1), (n - 1, 0)。假设节点数为i 时Unique Binary Search Trees 有h ( i ) 棵，那么 当节点数为 n 时， Unique Binary Search Trees 有： h (0) * h (n - 1) + h (1) * h (n - 2) + ...... + h (n - 2) * h (1) + h (n - 1) * h (0)棵
if (n == 0) {
            return 1;
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        for (int i = 1; i <= n; i++) {
            int start = 0;
            int end = i - 1;
            for (;start <= i - 1 && end >=0;) {
                res[i] += res[start++] * res[end--];
            }
        }
        return res[n];