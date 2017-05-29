/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/data-stream-median
@Language: Java
@Datetime: 16-07-14 01:00
*/

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int len = nums.length;
        Queue<Integer> minheap = new PriorityQueue<Integer>(len);
        Queue<Integer> maxheap = new PriorityQueue<Integer>(len, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a > b ? -1 : 1;    
            }
        });
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (maxheap.size() == minheap.size()) {
                minheap.offer(nums[i]);
                maxheap.offer(minheap.poll());
            } else {
                if (nums[i] > maxheap.peek()) {
                    minheap.offer(nums[i]);
                } else {
                    minheap.offer(maxheap.poll());
                    maxheap.offer(nums[i]);
                }
            }
            res[i] = maxheap.peek();
        }
        return res;
    }
}