/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/stack-sorting
@Language: Java
@Datetime: 16-07-06 23:49
*/

public class Solution {
    /**
     * @param stack an integer stack
     * @return void
     */
    public void stackSorting(Stack<Integer> stack) {
        // Write your code here
        Stack<Integer> sortStack = new Stack<Integer>();
        if (stack == null || stack.size() < 2) {
            return;
        }
        while (!stack.isEmpty()) {
            int tmp = stack.pop();
            if (sortStack.isEmpty() || sortStack.peek() >= tmp) {
                sortStack.push(tmp);
            } else {
                int count = 0;
                while (!sortStack.isEmpty() && sortStack.peek() < tmp) {
                    stack.push(sortStack.pop());
                    count++;
                }
                sortStack.push(tmp);
                while (count > 0) {
                    sortStack.push(stack.pop());
                    count--;
                }
            }
        }
        while (!sortStack.isEmpty()) {
            stack.push(sortStack.pop());
        }
        return;
    }
}