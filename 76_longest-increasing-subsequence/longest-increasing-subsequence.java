/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/longest-increasing-subsequence
@Language: Java
@Datetime: 17-01-27 10:40
*/

public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = 1;
        }
        int big = 0;
        for (int i = 1; i < res.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    res[i] = Math.max(res[j] + 1, res[i]);
                }
            }
            big = Math.max(big, res[i]);
        }
        return big;
        // if (nums == null || nums.length == 0) {
        //     return 0;
        // }
        // int[] res = new int[nums.length];
        // int big = 0;
        // for (int i = 0; i < res.length; i++) {
        //     res[i] = 1;
        // }
        // for (int i = 1; i < nums.length; i++) {
        //     int max = 0;
        //     for (int j = 0; j < i; j++) {
        //         if (nums[i] > nums[j]) {
        //             max = Math.max(max, res[j] + 1);
        //         }
        //         res[i] = Math.max(max, res[i]);
        //         big = Math.max(big, res[i]);
        //     }
        // }
        // return big;
    }
}
