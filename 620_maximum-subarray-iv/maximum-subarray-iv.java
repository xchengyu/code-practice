/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/maximum-subarray-iv
@Language: Java
@Datetime: 17-03-19 04:21
*/

public class Solution {
    /**
     * @param nums an array of integers
     * @param k an integer
     * @return the largest sum
     */
    public int maxSubarray4(int[] nums, int k) {
        // Write your code here
        if (nums == null || nums.length < k) {
            return 0;
        }
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = nums[i - 1] + sum[i - 1];
        }
        int min_prefix = 0;
        int max = Integer.MIN_VALUE;
        for (int i = k - 1; i < nums.length; i++) {
            max = Math.max(max, sum[i + 1] - min_prefix);
            min_prefix = Math.min(min_prefix, sum[i - k + 1]);
        }
        return max;
    }
}