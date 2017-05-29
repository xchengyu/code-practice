/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/trapping-rain-water
@Language: Java
@Datetime: 16-07-13 23:16
*/

public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here
        if (heights == null || heights.length < 3) {
            return 0;
        }
        int res = 0;
        int left = 0;
        int right = heights.length - 1;
        int min = 0;
        while (left < right) {
            if (heights[left] < heights[right]) {
                min = heights[left];
                left++;
                while (left < right && heights[left] < min) {
                    res += min - heights[left];
                    left++;
                }
            } else {
                min = heights[right];
                right--;
                while (left < right && heights[right] < min) {
                    res += min - heights[right];
                    right--;
                }
            }
        }
        return res;
    }
}