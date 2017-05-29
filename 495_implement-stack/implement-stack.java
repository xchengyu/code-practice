/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/implement-stack
@Language: Java
@Datetime: 16-07-06 22:00
*/

class Stack {
    // Push a new item into the stack
    ArrayList<Integer> res = new ArrayList<Integer>();
    public void push(int x) {
        // Write your code here
        res.add(x);
        return;
    }

    // Pop the top of the stack
    public void pop() {
        // Write your code here
        res.remove(res.size() - 1);
        return;
    }

    // Return the top of the stack
    public int top() {
        // Write your code here
        return res.get(res.size() - 1);
    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        // Write your code here
        return res.size() == 0;
    }    
}