/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/minimum-subarray
@Language: Java
@Datetime: 16-12-30 10:01
*/

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        // write your code
        //dp
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        int[] local = new int[nums.size()];
        int[] global = new int[nums.size()];
        local[0] = nums.get(0);
        global[0] = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            local[i] = Math.min(nums.get(i), local[i - 1] + nums.get(i));
            global[i] = Math.min(local[i], global[i - 1]);
        }
        return global[nums.size() - 1];
    }
    // public int minSubArray(ArrayList<Integer> nums) {
    //     // write your code
    //     //greedy
    //     if (nums == null || nums.size() == 0) {
    //         return 0;
    //     }
    //     int min = Integer.MAX_VALUE;
    //     int sum = 0;
    //     for (int i = 0; i < nums.size(); i++) {
    //         if (sum > 0) {
    //             sum = nums.get(i);
    //             min = Math.min(sum, min);
    //         } else {
    //             sum += nums.get(i);
    //             min = Math.min(sum, min);
    //         }
    //     }
    //     return min;
    // }
}
