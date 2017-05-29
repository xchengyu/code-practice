/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/backpack-v
@Language: Java
@Datetime: 17-01-14 10:18
*/

public class Solution {
    /**
     * @param nums an integer array and all positive numbers
     * @param target an integer
     * @return an integer
     */
    public int backPackV(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
// public class Solution {
//     /**
//      * @param nums an integer array and all positive numbers
//      * @param target an integer
//      * @return an integer
//      */
//     public int backPackV(int[] nums, int target) {
//         // Write your code here
//         if (nums == null || nums.length == 0) {
//             return 0;
//         }
//         int[] dp = new int[target + 1];
//         dp[0] = 1;
//         for (int i = 0; i < nums.length; i++) {
//             for (int j = target; j >= nums[i]; j--) {
//                 dp[j] += dp[j - nums[i]];
//             }
//         }
//         return dp[target];
//     }
// }