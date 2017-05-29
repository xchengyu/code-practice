/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/kth-largest-element-ii
@Language: Java
@Datetime: 17-01-23 06:30
*/

class Solution {
    /**
     * @param nums an integer unsorted array
     * @param k an integer from 1 to n
     * @return the kth largest element
     */
    public int kthLargestElement2(int[] nums, int k) {
        // Write your code here
        Queue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() < k) {
                queue.offer(nums[i]);
            } else {
                if (nums[i] > queue.peek()) {
                    queue.poll();
                    queue.offer(nums[i]);
                }
            }
        }
        return queue.peek();
    }
};