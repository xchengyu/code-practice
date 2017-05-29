/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/maximum-subarray
@Language: Java
@Datetime: 17-01-12 09:43
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code
        //dp
        // if (nums == null || nums.length == 0) {
        //     return 0;
        // }
        // int[] local = new int[nums.length];
        // int[] global = new int[nums.length];
        // local[0] = nums[0];
        // global[0] = nums[0];
        // for (int i = 1; i < nums.length; i++) {
        //     local[i] = Math.max(nums[i], local[i - 1] + nums[i]);
        //     global[i] = Math.max(local[i], global[i - 1]);
        // }
        // return global[nums.length - 1];
        
        //greedy
        // if (nums == null || nums.length == 0) {
        //     return 0;
        // }
        // int sum = 0;
        // int max = Integer.MIN_VALUE;
        // for (int i = 0; i < nums.length; i++) {
        //     if (sum < 0) {
        //         sum = 0;
        //     }
        //     sum += nums[i];
        //     max = Math.max(max, sum);
        // }
        // return max;
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = 0;
            }
            sum += nums[i];
            max = Math.max(sum, max);
        }
        return max;
    }
}