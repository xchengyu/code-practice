/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/search-in-rotated-sorted-array-ii
@Language: Java
@Datetime: 16-08-16 06:47
*/

public class Solution {
    /** 
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean 
     */
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int minIndex = findMin(nums);
        if (target < nums[minIndex]) {
            return false;
        }
        if (target > nums[nums.length - 1]) {
            return search(nums, 0, minIndex - 1, target);
        } else {
            return search(nums, minIndex, nums.length - 1, target);
        }
    }
    
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right && nums[left] == nums[right]) {
            left++;
        }
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid;
            } else {
                right = mid;   
            }
        }
        return nums[left] < nums[right] ? left : right;
    }
    
    public boolean search(int[] nums, int left, int right, int target) {
        while (left < right && nums[left] == nums[right]) {
            left++;
        }
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else if (nums[mid] == target) {
                return true;
            } else {
                right = mid;
            }
        }
        if ((left < nums.length && nums[left] == target) || (right >= 0 && nums[right] == target)) {
            return true;
        }
        return false;
    }
}
