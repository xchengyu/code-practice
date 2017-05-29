/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/sort-colors-ii
@Language: Java
@Datetime: 17-05-17 09:55
*/

class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        quickSort(colors, 0, colors.length - 1, 1, k);
        return;
    }
    public void quickSort(int[] colors, int start, int end, int bottom, int up) {
        if (bottom == up) {
            return;
        }
        if (start >= end) {
            return;
        }
        int pivot = bottom + (up - bottom) / 2;
        int left = start - 1;
        int right = end + 1;
        int index = start;
        while (index < right) {
            if (colors[index] < pivot) {
                left++;
                swap(colors, index, left);
                index++;
            } else if (colors[index] == pivot) {
                index++;
            } else {
                right--;
                swap(colors, index, right);
            }
        }
        quickSort(colors, start, left, bottom, pivot - 1);
        quickSort(colors, right, end, pivot + 1, up);
        return;
    }
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        return;
    }
}