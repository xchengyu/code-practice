/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/backpack-vi
@Language: Java
@Datetime: 16-08-05 01:04
*/

public class Solution {
    /**
     * @param nums an integer array and all positive numbers, no duplicates
     * @param target an integer
     * @return an integer
     */
    public int backPackVI(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length == 0 || target == 0) {
            return 0;
        }
        int[] res = new int[target + 1];
        res[0] = 1;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        for (int i = 1; i < min; i++) {
            res[i] = 0;
        }
        for (int i = min; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] <= i) {
                    res[i] += res[i - nums[j]];
                }
            }
        }
        return res[target];
    }
}