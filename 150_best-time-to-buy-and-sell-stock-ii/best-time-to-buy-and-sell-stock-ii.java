/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock-ii
@Language: Java
@Datetime: 16-07-05 00:16
*/

class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int profits = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] <= prices[i + 1]) {
                profits += prices[i + 1] - prices[i];
            }
        }
        return profits;
    }
};