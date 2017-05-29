/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/kth-largest-element
@Language: Java
@Datetime: 16-07-29 01:46
*/

class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return 0;
        }
        int[] res = new int[1];
        partition(k, nums, 0, nums.length - 1, res);
        return res[0];
    }
    public void partition(int k, int[] nums, int start, int end, int[] res) {
        if (start > end) {
            return;
        }
        if (start == end && k == 1) {
            res[0] = nums[start];
            return;
        }
        int left = start;//the last element which val is smaller than pivot
        int right = end;//the first element which val is larger than pivot
        int pivot = nums[left + (right - left) / 2];
        int cur = start;
        while (cur <= right) {
            if (nums[cur] < pivot) {
                int tmp = nums[left];
                nums[left] = nums[cur];
                nums[cur] = tmp;
                left++;
                cur++;
            } else if (nums[cur] == pivot) {
                cur++;
            } else {
                int tmp = nums[right];
                nums[right] = nums[cur];
                nums[cur] = tmp;
                right--;
            }
        }
        int i;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (i = start; i <= end; i++) {
            if (nums[i] == pivot) {
                min = Math.min(i, min);
                max = Math.max(i, max);
            }
        }
        int countMax = end - min + 1;
        int countMin = end - max + 1;
        if ( k >= countMin && k <= countMax ) {
            res[0] = pivot;
            return;
        } else if (k < countMin) {
            partition(k, nums, max + 1, end, res);
        } else {
            partition(k - countMax, nums, start, min - 1, res);
        }
        return;
    }
};