/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/kth-smallest-numbers-in-unsorted-array
@Language: Java
@Datetime: 17-01-16 05:42
*/

class Solution {
    /*
     * @param k an integer
     * @param nums an integer array
     * @return kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (k >= nums.length) {
            return partition(nums, 0, nums.length - 1, nums.length);
        }
        return partition(nums, 0, nums.length - 1, k);
    }
    public int partition(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        int left = start - 1;
        int right = end + 1;
        int index = start;
        int pivot = nums[(start + end) / 2];
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
        if (left - start + 1 >= k) {
            return partition(nums, start, left, k);
        } else if (right - start >= k) {
            return nums[right - 1];
        }
        return partition(nums, right, end, k - (right - start));
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }
};