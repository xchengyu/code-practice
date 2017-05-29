/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock-iv
@Language: Java
@Datetime: 16-09-03 09:24
*/

class Solution {
    /**
     * @param k: An integer
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int k, int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0 || k == 0) {
            return 0;
        }
        int gain = 0;
        int total = 0;
        if (k >= prices.length / 2) {
            for (int i = 0; i < prices.length - 1; i++) {
                gain = prices[i + 1] - prices[i];
                total += Math.max(0, gain);
            }
            return total;
        }
        int[][] local = new int[prices.length][k + 1];
        int[][] global = new int[prices.length][k + 1];
        for (int i = 0; i <= k; i++) {
            local[0][i] = 0;
            global[0][i] = 0;
        }
        for (int i = 1; i < prices.length; i++) {
            gain = prices[i] - prices[i - 1];
            local[i][0] = 0;
            for (int j = 1; j <= k; j++) {
                local[i][j] = Math.max(global[i - 1][j - 1] + gain, local[i - 1][j] + gain);
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }
        return global[prices.length - 1][k];
    }
}