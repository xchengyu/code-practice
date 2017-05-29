/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/second-max-of-array
@Language: Java
@Datetime: 17-05-23 08:56
*/

public class Solution {
    /**
     * @param nums: An integer array.
     * @return: The second max number in the array.
     */
    public int secondMax(int[] nums) {
        /* your code */
        int first = Math.max(nums[0], nums[1]);
        int second = Math.min(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] < second) {
                continue;
            } else if (nums[i] >= second && nums[i] < first) {
                second = nums[i];
            } else {
                second = first;
                first = nums[i];
            }
        }
        return second;
    }
}