/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/maximum-subarray-ii
@Language: Java
@Datetime: 17-01-10 08:04
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        int m = nums.size();
        int[] forward = new int[m];
        int[] backward = new int[m];
        // int sum = 0;
        // int minSum = 0;
        // int max = Integer.MIN_VALUE;
        // for (int i = 0; i < m; i++) {
        //     sum += (int) nums.get(i);
        //     max = Math.max(max, sum - minSum);
        //     minSum = Math.min(sum, minSum);
        //     forward[i] = max;
        // }
        // sum = 0;
        // minSum = 0;
        // max = Integer.MIN_VALUE;
        // for (int i = m - 1; i >= 0; i--) {
        //     sum += (int) nums.get(i);
        //     max = Math.max(max, sum - minSum);
        //     minSum = Math.min(sum, minSum);
        //     backward[i] = max;
        // }
        int[] local = new int[m];
        int[] global = new int[m];
        for (int i = 0; i < m; i++) {
            if (i == 0) {
                local[i] = nums.get(i);
                global[i] = nums.get(i);
                forward[i] = global[i];
            } else {
                local[i] = Math.max(nums.get(i), nums.get(i) + local[i - 1]);
                global[i] = Math.max(global[i - 1], local[i]);
                forward[i] = global[i];
            }
        }
        local = new int[m];
        global = new int[m];
        for (int i = m - 1; i >= 0; i--) {
            if (i == m - 1) {
                local[i] = nums.get(i);
                global[i] = nums.get(i);
                backward[i] = global[i];
            } else {
                local[i] = Math.max(nums.get(i), nums.get(i) + local[i + 1]);
                global[i] = Math.max(global[i + 1], local[i]);
                backward[i] = global[i];
            }
        }
        int ans = Integer.MIN_VALUE; 
        for (int i = 0; i < m - 1; i++) {
            ans = Math.max(ans,forward[i] + backward[i + 1]);
        }
        return ans;
    }
}

