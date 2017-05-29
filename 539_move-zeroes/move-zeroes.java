/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/move-zeroes
@Language: Java
@Datetime: 16-07-28 07:40
*/

public class Solution {
    /**
     * @param nums an integer array
     * @return nothing, do this in-place
     */
    public void moveZeroes(int[] nums) {
        // Write your code here
        int zero = 0;
        int non = 0;
        if (nums == null || nums.length == 0) {
            return;
        }
        int index = 0;
        while (index < nums.length) {
            if (nums[index] == 0) {
                zero = index;
                non = index + 1;
                while (non < nums.length && nums[non] == 0) {
                    non++;
                }
                if (non == nums.length) {
                    return;
                }
                int tmp = nums[non];
                nums[non] = nums[zero];
                nums[zero] = tmp;
                index++;
            } else {
                index++;
            }
        }
    }
}