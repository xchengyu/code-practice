/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/largest-rectangle-in-histogram
@Language: Java
@Datetime: 16-08-29 05:52
*/

public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        if (height == null || height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= height.length; i++) {
            int cur = i == height.length ? -1 : height[i];
            while (!stack.isEmpty() && height[stack.peek()] >= cur) {
                int h = height[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * width);
            }
            stack.push(i);
        }
        return max;
    }
}
