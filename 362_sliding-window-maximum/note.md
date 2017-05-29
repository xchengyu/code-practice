```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/sliding-window-maximum
@Language: Markdown
@Datetime: 16-08-31 06:11
```

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
        if (nums.length < k) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(max, nums[i]);
            }
            res.add(max);
            return res;
        }
        Deque<Integer> queue = new ArrayDeque<Integer>();//双端队列
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);//存index更好
        }
        res.add(nums[queue.peekFirst()]);
        for (int i = k; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();//存index更好
            }
            queue.offerLast(i);
            if (queue.peekFirst() == i - k) {
                queue.pollFirst();
            }
            res.add(nums[queue.peekFirst()]);
        }
        return res;
    }
}