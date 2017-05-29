/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/coins-in-a-line-iii
@Language: Java
@Datetime: 16-07-16 06:47
*/

public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if (values == null || values.length == 0) {
            return false;
        }
        if (values.length == 1) {
            return true;
        }
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        int[][]dp = new int[values.length][values.length];
        int[][]flag = new int[values.length][values.length];
        return sum < 2 * search(0, values.length - 1, dp, flag, values);
    }
    public int search(int left, int right, int[][] dp, int[][] flag, int[] values) {
        if (flag[left][right] == 1) {
            return dp[left][right];
        }
        flag[left][right] = 1;
        if (left > right) {
            dp[left][right] = 0;
            return dp[left][right];
        }
        if (left == right) {
            dp[left][right] = values[left];
            return dp[left][right];
        }
        if (left == right - 1) {
            dp[left][right] = Math.max(values[left], values[right]);
            return  dp[left][right];
        }
        int pick_left = Math.min(search(left + 2, right, dp, flag, values), search(left + 1, right - 1, dp, flag, values)) + values[left];
        int pick_right = Math.min(search(left, right - 2, dp, flag, values), search(left + 1, right - 1, dp, flag, values)) + values[right];
        dp[left][right] = Math.max(pick_left, pick_right);
        return dp[left][right];
    }
}