```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/build-post-office-ii
@Language: Markdown
@Datetime: 16-09-18 19:33
```

这题解法太精妙，从house开始bfs遍历每个empty点，在empty点记录house到这个empty点的距离，并另外用个数组记录有几个house能到达这个empty点。