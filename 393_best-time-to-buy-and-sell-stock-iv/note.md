```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock-iv
@Language: Markdown
@Datetime: 16-09-03 09:24
```

local
global
dynamic programming
class Solution {
    /**
     * @param k: An integer
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int k, int[] prices) {
        // write your code here
        if (prices == null || prices.length < 2) {
            return 0;
        }
        if (k >= prices.length / 2) {//交易次数超过天数一半后我们可以两天进行一次交易使交易利润最高
            int profit = 0;
            for (int i = 0; i < prices.length - 1; i++) {
                if (prices[i] <= prices[i + 1]) {
                    profit += prices[i + 1] - prices[i];
                }
            }
            return profit;
        }
        int[][] local = new int[prices.length][prices.length];//第i天必须完成一次交易，行index表示天数，列index表示交易次数
        int[][] global = new int[prices.length][prices.length];//第i天不一定有交易
        for (int i = 0; i < k; i++) {
            local[0][i] = global[0][i] = 0;//第0天进行多少次交易利润都是0
        }
        int gain = 0;
        for (int i = 1; i < prices.length; i++) {
            gain = prices[i] - prices[i - 1];
            local[i][0] = 0;
            for (int j = 1; j <= k; j++) {//只进行k次交易
                local[i][j] = Math.max(global[i - 1][j - 1] + gain, local[i - 1][j] + gain);
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }
        return global[prices.length - 1][k];//前prices.length天完成k次交易所获得的最大利润
    }
};