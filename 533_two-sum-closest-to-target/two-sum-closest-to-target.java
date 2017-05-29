/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/two-sum-closest-to-target
@Language: Java
@Datetime: 16-08-23 22:20
*/

public class Solution {
    /**
     * @param nums an integer array
     * @param target an integer
     * @return the difference between the sum and the target
     */
    public int twoSumCloset(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return target;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int diff = Integer.MAX_VALUE;
        while (left + 1 < right) {
            int tmp = nums[left] + nums[right];
            int res = tmp - target;
            if (res > 0) {
                diff = Math.min(diff, res);
                right--;
            } else if (res == 0) {
                return 0;
            } else {
                diff = Math.min(diff, -res);
                left++;
            }
        }
        int tmp = nums[left] + nums[right];
        int res = tmp - target;
        diff = Math.min(diff, Math.abs(res));
        return diff;
    }
}