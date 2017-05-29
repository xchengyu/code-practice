/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/maximum-subarray-v
@Language: Java
@Datetime: 17-03-19 05:34
*/

public class Solution {
    /**
     * @param nums an array of integers
     * @param k1 an integer
     * @param k2 an integer
     * @return the largest sum
     */
    public int maxSubarray5(int[] nums, int k1, int k2) {
        // Write your code here
        if (nums == null || nums.length < k1) {
            return 0;
        }
        int result = Integer.MIN_VALUE;
        int[] sum = new int[nums.length + 1];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = nums[i - 1] + sum[i - 1];
            if (!queue.isEmpty() && queue.getFirst() < i - k2) {
                queue.removeFirst();
            }
            if (i >= k1) {
                while (!queue.isEmpty() && sum[queue.getLast()] > sum[i - k1]) {
                    queue.removeLast();
                }
                queue.add(i - k1);
            }
            // [i - k2, i - k1]
            if (!queue.isEmpty() && sum[i] - sum[queue.getFirst()] > result) {
                result = Math.max(result, sum[i] - sum[queue.getFirst()]);
            }
        }
        return result;
    }
}