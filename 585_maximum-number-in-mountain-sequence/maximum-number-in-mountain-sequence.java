/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/maximum-number-in-mountain-sequence
@Language: Java
@Datetime: 16-12-17 04:26
*/

public class Solution {
    /**
     * @param nums a mountain sequence which increase firstly and then decrease
     * @return then mountain top
     */
    public int mountainSequence(int[] nums) {
        // Write your code here
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] >= nums[mid - 1] && nums[mid] >= nums[mid + 1]) {
                return nums[mid];
            } else if (nums[mid] >= nums[mid - 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return Math.max(nums[left], nums[right]);
    }
}