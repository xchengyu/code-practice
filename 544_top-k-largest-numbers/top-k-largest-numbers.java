/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/top-k-largest-numbers
@Language: Java
@Datetime: 16-08-23 22:12
*/

class Solution {
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        Queue<Integer> queue = new PriorityQueue<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() < k) {
                queue.offer(nums[i]);
            } else {
                int top = queue.peek();
                if (top < nums[i]) {
                    queue.poll();
                    queue.offer(nums[i]);
                }
            }
        }
        int[] results = new int[k];
        for (int i = results.length - 1; i >= 0; i--) {
            results[i] = queue.poll();
        }
        return results;
    }
};

