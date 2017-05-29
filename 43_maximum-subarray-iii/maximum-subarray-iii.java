/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/maximum-subarray-iii
@Language: Java
@Datetime: 16-08-28 04:34
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[][] local = new int[len + 1][len + 1];
        int[][] global = new int[len + 1][len + 1];
        for (int i = 1; i <= k; i++) {
            local[i][i - 1] = global[i][i - 1] = Integer.MIN_VALUE;
            for (int j = i; j <= len; j++) {
                local[i][j] = Math.max(global[i - 1][j - 1], local[i][j - 1]) + nums[j - 1];
                if (i == j) {
                    global[i][j] = local[i][j];
                } else {
                    global[i][j] = Math.max(local[i][j], global[i][j - 1]);
                }
            }
        }
        return global[k][len];
    }
}
// public class Solution {
//     /**
//      * @param nums: A list of integers
//      * @param k: An integer denote to find k non-overlapping subarrays
//      * @return: An integer denote the sum of max k non-overlapping subarrays
//      */
//     public int maxSubArray(int[] nums, int k) {
//         // write your code here
//         if (nums == null || nums.length == 0) {
//             return 0;
//         }
//         int m = nums.length;
//         int[][] local = new int[m + 1][m + 1];//行index表示分成多少subarray，列index表示数字
//         //local[i][j]表示前j个数分成i个subarray，最后一个数包含在最后一个subarray中
//         int[][] global = new int[m + 1][m + 1];
//         //global[i][j]表示前j个数分成i个subarray，最后一个数不一定包含在最后一个subarray中
//         for (int i = 1; i <= k; i++) {
//             local[i][i - 1] = global[i][i - 1] = Integer.MIN_VALUE; //小于 i 的数组不能够partition
//             for (int j = i; j <= m; j++) {
//             local[i][j] = Math.max(local[i][j - 1], global[i - 1][j - 1]) + nums[j - 1];
//             if (j == i) {
//                 global[i][j] = local[i][j];
//             } else {
//                 global[i][j] = Math.max(local[i][j], global[i][j - 1]);
//             }
//         }
//         }
//         return global[k][m];
//     }
// }