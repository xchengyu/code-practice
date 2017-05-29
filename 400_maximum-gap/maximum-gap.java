/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/maximum-gap
@Language: Java
@Datetime: 16-07-18 08:52
*/

class Solution {
    /**
     * @param nums: an array of integers
     * @return: the maximum difference
     */
    public int maximumGap(int[] nums) {
        // write your code here
        if (nums == null || nums.length < 2) {
            return 0;
        }
        if (nums.length == 2) {
            return Math.abs(nums[0] - nums[1]);
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        double gap = ((double) (max - min)) / (len - 1.0);
        int[] minV = new int[len - 1];
        int[] maxV = new int[len - 1];
        Arrays.fill(minV, Integer.MAX_VALUE);
        Arrays.fill(maxV, Integer.MIN_VALUE);
        for (int i = 0; i < len; i++) {
            if (nums[i] != max) {// the bktId of maxAll will fall out of bucket range
                int bktid = (int) ((nums[i] - min) / gap);
                minV[bktid] = Math.min(minV[bktid], nums[i]);
                maxV[bktid] = Math.max(maxV[bktid], nums[i]);
            }
        }
        int res = 0;
        int curMax = maxV[0];
        for (int i = 1; i < len - 1; i++) {
            if (minV[i] != Integer.MAX_VALUE) {
                res = Math.max(res, minV[i] - curMax);
                curMax = maxV[i];
            }
        }
        res = Math.max(res, max - curMax);
        return res;
    }
}