/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/maximum-average-subarray
@Language: Java
@Datetime: 17-01-13 10:25
*/

public class Solution {
    /**
     * @param nums an array with positive and negative numbers
     * @param k an integer
     * @return the maximum average
     */
    public double maxAverage(int[] nums, int k) {
        // Write your code here
        if (nums == null || nums.length < k) {
            return 0;
        }
        double big = Integer.MIN_VALUE;
        double small = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            big = Math.max(big, nums[i]);
            small = Math.min(small, nums[i]);
        }
        double[] sum = new double[nums.length + 1];
        sum[0] = 0;
        while (big - small > 1e-6) {
            double mid = (big + small) / 2.0;
            double min_pre = 0;
            boolean find = false;
            for (int i = 1; i < nums.length + 1; i++) {
                sum[i] = sum[i - 1] + nums[i - 1] - mid;
                if (i >= k && sum[i] - min_pre >= 0) {
                    find = true;
                    break;
                }
                if (i >= k) {
                    min_pre = Math.min(min_pre, sum[i - k + 1]);
                }
            }
            if (find) {
                small = mid;
            } else {
                big = mid;
            }
        }
        return small;
    }
}