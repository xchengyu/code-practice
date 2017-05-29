/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock-iii
@Language: Java
@Datetime: 17-01-24 06:08
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
        int len = prices.length;
        int[] opt = new int[len];
        int curMax = 0;
        int low = prices[0];
        opt[0] = 0;
        for (int i = 1; i < len; i++) {
            low = Math.min(low, prices[i]);
            curMax = Math.max(curMax, prices[i] - low);
            opt[i] = curMax;
        }
        curMax = 0;
        int[] reverseOpt = new int[len];
        reverseOpt[len - 1] = 0;
        int high = prices[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            high = Math.max(high, prices[i]);
            curMax = Math.max(curMax, high - prices[i]);
            reverseOpt[i] = curMax;
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans = Math.max(ans, opt[i] + reverseOpt[i]);
        }
        return ans;
    }
};