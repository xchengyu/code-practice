/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock
@Language: Java
@Datetime: 16-07-05 00:10
*/

public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] profit = new int[prices.length];
        profit[0] = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            profit[i] = Math.max(0, profit[i - 1] + prices[i] - prices[i - 1]);
            max = Math.max(max, profit[i]);
        }
        return max;
    }
}