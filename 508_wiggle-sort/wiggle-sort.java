/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/wiggle-sort
@Language: Java
@Datetime: 16-08-22 21:19
*/

public class Solution {
    /**
     * @param nums a list of integer
     * @return void
     */
    public void wiggleSort(int[] nums) {
        // Write your code here
        for (int i = 0; i < nums.length - 1; i++) {
            if (i % 2 == 0 && nums[i] > nums[i + 1]) {
                swap(nums, i, i + 1);
            } else if (i % 2 == 1 && nums[i] < nums[i + 1]) {
                swap(nums, i, i + 1);
            }
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