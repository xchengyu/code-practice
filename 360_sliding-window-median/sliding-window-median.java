/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/sliding-window-median
@Language: Java
@Datetime: 16-08-31 06:54
*/

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
        int[] tmp = new int[k];
        for (int i = 0; i < k; i++) {
            tmp[i] = nums[i];
        }
        Arrays.sort(tmp);
        Queue<Integer> maxq = new PriorityQueue<Integer>(nums.length, new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                return a > b ? -1 : 1;
            }
            
        });
        Queue<Integer> minq = new PriorityQueue<Integer>();
        int median = tmp[(k - 1) / 2];
        for (int i = 0; i < (k - 1) / 2; i++) {
            maxq.offer(tmp[i]);
        }
        for (int i = (k + 1) / 2; i < k; i++) {
            minq.offer(tmp[i]);
        }
        res.add(median);
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > median) {
                minq.offer(nums[i]);
            } else {
                maxq.offer(nums[i]);
            }
            if (nums[i - k] == median) {
                if (minq.size() > maxq.size()) {
                    median = minq.poll();
                } else {
                    median = maxq.poll();
                }
            } else if (nums[i - k] < median) {
                maxq.remove(nums[i - k]);
                if (minq.size() - maxq.size() > 1) {
                    maxq.offer(median);
                    median = minq.poll();
                }
            } else {
                minq.remove(nums[i - k]);
                if (maxq.size() - minq.size() >= 1) {
                    minq.offer(median);
                    median = maxq.poll();
                }
            }
            res.add(median);
        }
        return res;
    }
}
