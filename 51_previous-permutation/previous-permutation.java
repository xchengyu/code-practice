/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/previous-permutation
@Language: Java
@Datetime: 16-08-16 06:17
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
		// write your code
        if (nums == null || nums.size() < 2) {
            return nums;
        }
        boolean found = false;
        int index = 0;
        for (int i = nums.size() - 2; i >= 0; i--) {
            if (nums.get(i) > nums.get(i + 1)) {
                found = true;
                index = i;
                break;
            }
        }
        if (!found) {
            reverse(nums, 0, nums.size() - 1);
            return nums;
        }
        int invertIndex = 0;
        for (int i = nums.size() - 1; i > index; i--) {
            if (nums.get(i) < nums.get(index)) {
                invertIndex = i;
                break;
            }
        }
        swap(nums, index, invertIndex);
        reverse(nums, index + 1, nums.size() - 1);
        return nums;
    }
    public void swap(ArrayList<Integer> nums, int i, int j) {
        int tmp = nums.get(i);
        nums.set(i,nums.get(j));
        nums.set(j, tmp);
        return;
    }
    
    public void reverse(ArrayList<Integer> nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
        return;
    }
}
