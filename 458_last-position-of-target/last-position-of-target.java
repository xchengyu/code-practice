/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/last-position-of-target
@Language: Java
@Datetime: 16-06-27 22:06
*/

public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return an integer
     */
    public int lastPosition(int[] nums, int target) {
        // Write your code here
        int left = -1;
        if (nums == null || nums.length == 0) {
            return left;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target){
                break;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (nums[mid] != target) {
            return left;
        }
        left = mid;
        int right = nums.length - 1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }
}