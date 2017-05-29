```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/sliding-window-median
@Language: Markdown
@Datetime: 16-08-31 06:54
```

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The median of the element inside the window at each moving.
     */
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        if (nums.length <= k) {
            Arrays.sort(nums);
            res.add(nums[nums.length / 2]);
            return res;
        }
        int[] tmp = new int[k];
        for (int i = 0; i < k; i++) {
            tmp[i] = nums[i];
        }
        Arrays.sort(tmp);
        Queue<Integer> minheap = new PriorityQueue<Integer>(nums.length);
        Queue<Integer> maxheap = new PriorityQueue<Integer>(nums.length, new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                return a < b ? 1 : -1;
            }
        });
        int median = tmp[(k - 1) / 2];
        for (int i = 0; i < (k - 1) / 2; i++) {
            maxheap.offer(tmp[i]);
        }
        for (int i = k - 1; i > (k - 1) / 2; i--) {
            minheap.offer(tmp[i]);
        }
        res.add(median);
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > median) {
                minheap.offer(nums[i]);
            } else {
                maxheap.offer(nums[i]);
            }
            if (nums[i - k] == median) {
                if (minheap.size() > maxheap.size()) {
                    median = minheap.poll();
                } else {
                    median = maxheap.poll();
                }
            } else if (nums[i - k] < median) {
                maxheap.remove(nums[i - k]);
                if (minheap.size() - maxheap.size() > 1) {
                    maxheap.offer(median);
                    median = minheap.poll();
                }
            } else {
                minheap.remove(nums[i - k]);
                if (maxheap.size() - minheap.size() >= 1) {//注意，k为偶数时，当maxheap - minheap = 1时就要对堆进行调整
                    minheap.offer(median);
                    median = maxheap.poll();
                }
            }
            res.add(median);
        }
        return res;
    }
}