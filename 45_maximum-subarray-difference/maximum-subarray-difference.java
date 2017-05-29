/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/maximum-subarray-difference
@Language: Java
@Datetime: 17-01-10 07:58
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] maxForth = new int[len];
        int[] minForth = new int[len];
        int[] maxBack = new int[len];
        int[] minBack = new int[len];
        boolean direction = true;
        int[] negative = new int[len];
        for (int i = 0; i < nums.length; i++) {
            negative[i] = -nums[i];
        }
        calculateMax(nums, maxForth, direction);
        calculateMax(negative, minForth, direction);
        direction = !direction;
        calculateMax(nums, maxBack, direction);
        calculateMax(negative, minBack, direction);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len - 1; i++) {
            max = Math.max(max, Math.abs(maxForth[i] + minBack[i + 1]));
            max = Math.max(max, Math.abs(minForth[i] + maxBack[i + 1]));
        }
        return max;
    }
    private void calculateMax(int[] nums, int[] results, boolean direction) {
        int len = nums.length;
        int[] local = new int[len];
        int[] global = new int[len];
        if (direction) {
            for (int i = 0; i < len; i++) {
                if (i == 0) {
                    local[i] = nums[i];
                    global[i] = nums[i];
                    results[i] = global[i];
                } else {
                    local[i] = Math.max(nums[i], nums[i] + local[i - 1]);
                    global[i] = Math.max(local[i], global[i - 1]);
                    results[i] = global[i];
                }
            }
        } else {
            for (int i = len - 1; i >= 0; i--) {
                if (i == len - 1) {
                    local[i] = nums[i];
                    global[i] = nums[i];
                    results[i] = global[i];
                } else {
                    local[i] = Math.max(nums[i], nums[i] + local[i + 1]);
                    global[i] = Math.max(local[i], global[i + 1]);
                    results[i] = global[i];
                }
            }
        }
    }
}
// public class Solution {
//     /**
//      * @param nums: A list of integers
//      * @return: An integer indicate the value of maximum difference between two
//      *          Subarrays
//      */
//     public int maxDiffSubArrays(int[] nums) {
//         // write your code here
//         if (nums == null || nums.length == 0) {
//             return 0;
//         } 
//         int len = nums.length;
//         int[] maxForth = new int[len];
//         int[] minForth = new int[len];
//         int[] maxBack = new int[len];
//         int[] minBack = new int[len];
//         int[] negative = new int[len];
//         for (int i = 0; i < len; i++) {
//             negative[i] = - nums[i];
//         }
//         int[] local = new int[len];
//         int[]global = new int[len];
//         boolean direction = true;//forth, false means back
//         calculatemax(nums, maxForth, local, global, direction);
//         calculatemax(negative, minForth, local, global, direction);
//         direction = ! direction;
//         calculatemax(nums, maxBack, local, global, direction);
//         calculatemax(negative, minBack, local, global, direction);
//         int diff = Integer.MIN_VALUE;
//         for (int i = 0; i < nums.length - 1; i++) {
//             int tmp = Math.max(Math.abs(maxForth[i] + minBack[i + 1]), Math.abs(minForth[i] + maxBack[i + 1]));
//             diff = Math.max(diff, tmp);
//         }
//         return diff;
//     }
    
//     public void calculatemax(int[] nums, int[] result, int[] local, int[] global, boolean direction) {
//         Arrays.fill(local, Integer.MIN_VALUE);
//         Arrays.fill(global, Integer.MIN_VALUE);
//         int len = nums.length;
//         if (direction) {
//             local[0] = nums[0];
//             global[0] = nums[0];
//             result[0] = global[0];
//             for (int i = 1; i < len; i++) {
//                 local[i] = Math.max(local[i - 1] + nums[i], nums[i]);
//                 global[i] = Math.max(global[i - 1], local[i]);
//                 result[i] = global[i];
//             }
//             return;
//         } else {
//             local[len - 1] = nums[len - 1];
//             global[len - 1] = nums[len - 1];
//             result[len - 1] = global[len - 1];
//             for (int i = len - 2; i >= 0; i--) {
//                 local[i] = Math.max(local[i + 1] + nums[i], nums[i]);
//                 global[i] = Math.max(global[i + 1], local[i]);
//                 result[i] = global[i];
//             }
//             return;
//         }
//     }
// }


