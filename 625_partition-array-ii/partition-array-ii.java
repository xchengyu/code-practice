/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/partition-array-ii
@Language: Java
@Datetime: 17-03-03 10:20
*/

public class Solution {
    /**
     * @param nums an integer array
     * @param low an integer
     * @param high an integer
     * @return nothing
     */
    public void partition2(int[] nums, int low, int high) {
        // Write your code here
        if (nums == null || nums.length < 2) {
            return;
        }
        int small = 0;
        int large = nums.length - 1;
        int cur = 0;
        while (cur <= large) {
            if (nums[cur] < low) {
                swap(nums, cur, small);
                small++;
                cur++;
            } else if (nums[cur] > high) {
                swap(nums, cur, large);
                large--;
            } else {
                cur++;
            }
        }
        return;
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}