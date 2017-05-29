/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/wiggle-sort-ii
@Language: Java
@Datetime: 17-01-15 10:30
*/

public class Solution {
    /**
     * @param nums a list of integer
     * @return void
     */
    public void wiggleSort(int[] nums) {
        // Write your code here
        if (nums == null || nums.length < 2) {
            return;
        }
        int mid = partition(nums, 0, nums.length - 1, nums.length / 2);
        int[] ans = new int[nums.length];
        Arrays.fill(ans, mid);
        int l, r;
        if (nums.length % 2 == 0) {
            l = nums.length - 2;
            r = 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < mid) {
                    ans[l] = nums[i];
                    l -= 2;
                } else if (nums[i] > mid) {
                    ans[r] = nums[i];
                    r += 2;
                }
            }
        } else {
            l = 0;
            r = nums.length - 2;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < mid) {
                    ans[l] = nums[i];
                    l += 2;
                } else if (nums[i] > mid) {
                    ans[r] = nums[i];
                    r -= 2;
                }
            }
        }
        for (int i = 0; i < ans.length; i++) {
            nums[i] = ans[i];
        }
        return;
    }
    public int partition(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        int left = start - 1;
        int right = end + 1;
        int index = start;
        int pivot = nums[start];
        while (index < right) {
            if (nums[index] < pivot) {
                left++;
                swap(nums, left, index);
                index++;
            } else if (nums[index] == pivot) {
                index++;
            } else {
                right--;
                swap(nums, right, index);
            }
        }
        if (left - start + 1 >= k) {
            return partition(nums, start, left, k);
        } else if (right - start + 1 > k) {
            return pivot;
        }
        return partition(nums, right, end, k - (right - start));
    }
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        return;
    }
}
