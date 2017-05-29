/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/implement-queue-by-two-stacks
@Language: Java
@Datetime: 16-07-05 08:44
*/

public class Queue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Queue() {
       // do initialization if necessary
       stack1 = new Stack<Integer>();
       stack2 = new Stack<Integer>();
    }
    private void transform() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return;
    }
    public void push(int element) {
        // write your code here
        stack1.push(element);
        return;
    }

    public int pop() {
        // write your code here
        if (stack2.isEmpty()) {
            transform();
        }
        return stack2.pop();
    }

    public int top() {
        // write your code here
        if (stack2.isEmpty()) {
            transform();
        }
        return stack2.peek();
    }
}