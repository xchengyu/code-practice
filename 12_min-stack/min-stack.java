/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/min-stack
@Language: Java
@Datetime: 17-02-01 09:49
*/

public class MinStack {
    Stack<Integer> alls;
    Stack<Integer> min;
    public MinStack() {
        // do initialize if necessary
        this.alls = new Stack<Integer>();
        this.min = new Stack<Integer>();
    }

    public void push(int number) {
        // write your code here
        alls.push(number);
        if (min.isEmpty() || number <= (int)min.peek()) {
            min.push(number);
        }
        return;
    }

    public int pop() {
        // write your code here
        int top = alls.pop();
        if (top == (int)min.peek()) {
            min.pop();
        }
        return top;
    }

    public int min() {
        // write your code here
        return min.peek();
    }
}
