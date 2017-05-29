/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/median
@Language: Java
@Datetime: 16-08-07 05:09
*/

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return helper(nums, 0, nums.length - 1, (nums.length + 1) / 2);
    }
    // public int helper(int[] nums, int start, int end, int k) {//kth smallest number
    //     if (start == end) {
    //         return nums[start];
    //     }
    //     int pivot = nums[start + (end - start) / 2];
    //     int left = start - 1;//the last element which val is smaller than pivot
    //     int right = end + 1;//the first element which val is larger than pivot
    //     int index = start;
    //     while (index < right) {
    //         if (nums[index] < pivot) {
    //             left++;
    //             int tmp = nums[left];
    //             nums[left] = nums[index];
    //             nums[index] = tmp;
    //             index++;
    //         } else if (nums[index] == pivot) {
    //             index++;
    //         } else {
    //             right--;
    //             int tmp = nums[right];
    //             nums[right] = nums[index];
    //             nums[index] = tmp;
    //         }
    //     }
    //     if (left - start + 1 >= k) {//the left side of this inequality represents the total number of elements which val are smaller than pivot
    //         return helper(nums, start, left, k);
    //     } else if (right - start >= k) {//the left side of this inequality represents the total number of elements which val are not larger than pivot 
    //         return nums[right - 1];
    //     } else {
    //         return helper(nums, right, end, k - (right - start));
    //     }
    // }
    public int helper(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        int pivot = nums[start + (end - start) / 2];
        int left = start - 1;
        int right = end + 1;
        int index = start;
        while (index < right) {
            if (nums[index] < pivot) {
                left++;
                swap(nums, left, index);
                index++;
            } else if (nums[index] == pivot) {
                index++;
            } else {
                right--;
                swap(nums, right, index);
            }
        }
        if (left - start + 1 < k) {
            if (right - start >= k) {
                return nums[right - 1];
            } else {
                return helper(nums, right, end, k - (right - start));
            }
        } else {
            return helper(nums, start, left, k);
        }
    }
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        return;
    }
}
