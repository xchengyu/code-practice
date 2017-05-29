```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/binary-tree-flipping
@Language: Markdown
@Datetime: 17-05-12 10:22
```

左子树为空的时候不翻转。一般情况就是让自己的左节点变成自己的root，自己变成自己左节点的右节点，然后让自己的右节点变成自己左节点的左节点。