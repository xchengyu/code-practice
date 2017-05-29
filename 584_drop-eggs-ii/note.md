```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/drop-eggs-ii
@Language: Markdown
@Datetime: 17-01-13 10:43
```

public class Solution {
    /**
     * @param m the number of eggs
     * @param n the umber of floors
     * @return the number of drops in the worst case
     */
    public int dropEggs2(int m, int n) {
        // Write your code here
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; ++i) {
            dp[i][1] = 1;
            dp[i][0] = 0;
        }
     
        for (int j = 1; j <= n; ++j)
            dp[1][j] = j;

        for (int i = 2; i <= m; ++i) {
            for (int j = 2; j <= n; ++j) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 1; k <= j; ++k) {
                    dp[i][j] = Math.min(dp[i][j],
                        1 + Math.max(dp[i - 1][k - 1], dp[i][j - k]));
                }
            }
        }

        return dp[m][n];
    }
}
下面用递归的方法解决该问题。假设鸡蛋从 x 层扔下去。（1）如果鸡蛋摔破，那么还剩 n-1 个鸡蛋，临界楼层在 [1, x] 之间；（2）如果鸡蛋没破，那么还剩 n 个鸡蛋，临界楼层在 [k, x+1] z之间。 设 eggDrop(n,k) 是问题的解，那么递归表达式是
eggDrop(n,k) = 1+ min (   max( eggDrop(n-1, x-1), eggDrop(n, k-x) ) for all x in [1,k] )。
http://blog.csdn.net/jiyanfeng1/article/details/47193063
http://www.acmerblog.com/egg-dropping-puzzle-5591.html
