/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/two-sum-input-array-is-sorted
@Language: Java
@Datetime: 17-01-23 02:55
*/

public class Solution {
    /*
     * @param nums an array of Integer
     * @param target = nums[index1] + nums[index2]
     * @return [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        // write your code here
        int[] res = new int[2];
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                break;
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }
}