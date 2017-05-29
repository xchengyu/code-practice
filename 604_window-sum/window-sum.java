/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/window-sum
@Language: Java
@Datetime: 17-01-22 10:32
*/

public class Solution {
    /**
     * @param nums a list of integers.
     * @return the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        if (k >= nums.length) {
            int[] res = new int[1];
            for (int i = 0; i < nums.length; i++) {
                res[0] += nums[i];
            }
            return res;
        }
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                res[index] += nums[i];
            } else {
                index++;
                res[index] = res[index - 1] + nums[i] - nums[i - k];
            }
        }
        return res;
    }
}

