/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/sort-colors
@Language: Java
@Datetime: 17-05-17 09:15
*/

class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if (nums == null || nums.length <= 1) {
            return;
        }
        int start = -1;
        int end = nums.length;
        int index = 0;
        int pivot = 1;
        while (index < end) {
            if (nums[index] < pivot) {
                start++;
                swap(nums, start, index);
                index++;
            } else if (nums[index] == pivot) {
                index++;
            } else {
                end--;
                swap(nums, index, end);
            }
        }
        return;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}