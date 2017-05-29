/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/first-position-of-target
@Language: Java
@Datetime: 16-06-27 00:43
*/

class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        //write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                break;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (start > end) {
            return -1;
        }
        while (mid - 1 >= 0) {
            if (nums[mid] == nums[mid - 1]) {
                mid--;
            } else {
                break;
            }
        }
        return mid;
    }
}