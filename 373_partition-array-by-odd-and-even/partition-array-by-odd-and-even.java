/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/partition-array-by-odd-and-even
@Language: Java
@Datetime: 16-07-15 07:27
*/

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
     public void partitionArray(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            while (start < end && nums[start] % 2 == 1) {
                start++;
            }
            while (start < end && nums[end] % 2 == 0) {
                end--;
            }
            if (start < end) {
                int temp = nums[start]; nums[start] = nums[end]; nums[end] = temp;
                start++;
                end--;
            } 
        }
    }
}