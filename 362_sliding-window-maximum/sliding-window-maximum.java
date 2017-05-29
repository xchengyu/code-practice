/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/sliding-window-maximum
@Language: Java
@Datetime: 16-08-31 06:11
*/

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        res.add(nums[deque.peekFirst()]);
        for (int i = k; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            res.add(nums[deque.peekFirst()]);
        }
        return res;
    }
}
