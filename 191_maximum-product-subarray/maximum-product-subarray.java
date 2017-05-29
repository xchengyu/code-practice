/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/maximum-product-subarray
@Language: Java
@Datetime: 17-01-18 09:51
*/

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
        // if (nums == null || nums.length == 0) {
        //     return 0;
        // }
        // int[] min = new int[nums.length];//local
        // int[] max = new int[nums.length];//local
        // min[0] = nums[0];
        // max[0] = nums[0];
        // int result = nums[0];
        // for (int i = 1; i < nums.length; i++) {
        //     if (nums[i] > 0) {
        //         max[i] = Math.max(nums[i], max[i - 1] * nums[i]);
        //         min[i] = Math.min(nums[i], min[i - 1] * nums[i]);
        //     } else {
        //         max[i] = Math.max(nums[i], min[i - 1] * nums[i]);
        //         min[i] = Math.min(nums[i], max[i - 1] * nums[i]);
        //     }
        //     result = Math.max(result, max[i]);
        // }
        // return result;
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] min = new int[len];
        int[] max = new int[len];
        min[0] = nums[0];
        max[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] > 0) {
                max[i] = Math.max(nums[i], max[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], min[i - 1] * nums[i]);
            } else {
                max[i] = Math.max(nums[i], min[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], max[i - 1] * nums[i]);
            }
            result = Math.max(max[i], result);
        }
        return result;
    }
}