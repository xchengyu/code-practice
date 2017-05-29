/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/minimum-size-subarray-sum
@Language: Java
@Datetime: 16-07-15 01:20
*/

public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int len = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            len++;
            if (sum >= s) {
                min = Math.min(min, len);
            }
            while (sum - nums[start] >= s) {
                sum -= nums[start];
                len--;
                start++;
                min = Math.min(min, len);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}