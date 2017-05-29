/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/backpack-iv
@Language: Java
@Datetime: 17-01-14 10:16
*/

public class Solution {
    /**
     * @param nums an integer array and all positive numbers, no duplicates
     * @param target an integer
     * @return an integer
     */
    public int backPackIV(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j >= nums[i] && dp[j - nums[i]] > 0) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }
}
// public class Solution {
//     /**
//      * @param nums an integer array and all positive numbers, no duplicates
//      * @param target an integer
//      * @return an integer
//      */
//     public int backPackIV(int[] nums, int target) {
//         // Write your code here
//         if (nums == null || nums.length == 0) {
//             return 0;
//         }
//         int[] dp = new int[target + 1];
//         dp[0] = 1;
//         for (int i = 0; i < nums.length; i++) {
//             for (int j = nums[i]; j <= target; j++) {
//                 dp[j] += dp[j - nums[i]];
//             }
//         }
//         return dp[target];
//     }
// }