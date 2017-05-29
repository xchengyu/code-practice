/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/next-permutation-ii
@Language: Java
@Datetime: 17-01-18 07:59
*/

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
    public void nextPermutation(int[] nums) {
        // write your code here
        if (nums == null || nums.length < 2) {
            return;
        }
        int index = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i + 1;
                break;
            }
        }
        if (index == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int firstBigger = 0;
        for (int i = nums.length - 1; i >= index; i--) {
            if (nums[i] > nums[index - 1]) {
                firstBigger = i;
                break;
            }
        }
        swap(nums, index - 1, firstBigger);
        reverse(nums, index, nums.length - 1);
        return;
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
        return;
    }
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        return;
    }
}