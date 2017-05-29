/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/container-with-most-water
@Language: Java
@Datetime: 16-07-15 01:36
*/

public class Solution {
    /**
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        // write your code here
        if (heights == null || heights.length <= 1) {
            return 0;
        }
        int left = 0;
        int right = heights.length - 1;
        int max = Integer.MIN_VALUE;
        while (left < right) {
            while (left < right && heights[left] < heights[right]) {
                max = Math.max(max, (right - left) * Math.min(heights[left], heights[right]));
                left++;
            }
            while (left < right && heights[left] >= heights[right]) {
                max = Math.max(max, (right - left) * Math.min(heights[left], heights[right]));
                right--;
            }
        }
        return max;
    }
}