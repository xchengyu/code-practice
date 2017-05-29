/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/two-sum-less-than-or-equal-to-target
@Language: Java
@Datetime: 17-01-23 02:28
*/

public class Solution {
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum5(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int index = nums.length - 1;
        int res = 0;
        while (index > 0) {
            int insert = findInsert(nums, target - nums[index], 0, index - 1);
            res += insert == -1 ? 0 : insert;
            index--;
        }
        return res;
    }
    public int findInsert(int[] nums, int target, int start, int end) {
        if (start > end || target < nums[start]) {
            return -1;
        }
        if (target > nums[end]) {
            return end + 1;
        }
        int mid = 0;
        int left = start;
        int right = end;
        while (left + 1 < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                while (mid <= end && nums[mid] == target) {
                    mid++;
                }
                if (mid == end + 1) {
                    return mid;
                }
                if (nums[mid] != target) {
                    return mid;
                }
            }
        }
        if (nums[right] <= target) {
            return right + 1;
        } else if (nums[left] <= target) {
            return left + 1;
        }
        return left;
    }
}