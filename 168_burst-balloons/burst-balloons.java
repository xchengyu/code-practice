/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/burst-balloons
@Language: Java
@Datetime: 16-07-17 10:09
*/

public class Solution {
    /**
     * @param nums a list of integer
     * @return an integer, maximum coins
     */
    public int maxCoins(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        int[][] dp = new int[len + 2][len + 2];
        int[] arr = new int[len + 2];
        for (int i = 1; i <= len; i++){
        	arr[i] = nums[i - 1];
        }
        arr[0] = 1;
        arr[len + 1] = 1;
        for (int i = 0; i < len + 2; i++) {
            for (int j = i; j < len + 2; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        return search(1, len, arr, dp);
    }
    public int search(int start, int end, int[] arr, int[][] dp) {
        if (start > end) {
            return 0;
        }
        if (dp[start][end] != Integer.MAX_VALUE) {
            return dp[start][end];
        }
        int max = Integer.MIN_VALUE;
        //下面循环中i的意义至关重要，i表示从start到end区间中最后一个被刺破的气球的index
        //只有这样表示，我们刺破第i个气球后才不会对左右子区间的值造成影响
        for (int i = start; i <= end; i++) {
            int left = search(start, i - 1, arr, dp);
            int right = search(i + 1, end, arr, dp);
            int now = arr[start - 1] * arr[i] * arr[end + 1];
            max = Math.max(max, now + left + right);
        }
        dp[start][end] = max;
        return dp[start][end];
    }
    //非递归
    // public int maxCoins(int[] nums) {
    //     int[] arr = new int[nums.length + 2];
    //         int n = 1;
    //         for (int x : nums) {
    //             arr[n++] = x;
    //         }
    //         arr[0] = arr[n++] = 1;//首尾各加一个dummy值
    
    //         int[][] dp = new int[n][n];
    //         for (int k = 2; k < n; ++k)//len
    //             for (int l = 0; l < n - k; ++l) {//left
    //                 int r = l + k;//right
    //                 for (int m = l + 1; m < r; ++m)//最后一个刺破气球的index
    //                     dp[l][r] = Math.max(dp[l][r], 
    //                         arr[l] * arr[m] * arr[r] + dp[l][m] + dp[m][r]);
    //             }
        
    //         return dp[0][n - 1];
    // }
}
