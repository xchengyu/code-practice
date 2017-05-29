/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/implement-queue-by-linked-list
@Language: Java
@Datetime: 16-07-06 22:53
*/

public class Queue {
    LinkedList<Integer> list;
    public Queue() {
        // do initialize if necessary
        list = new LinkedList<Integer>();
    }

    public void enqueue(int item) {
        // Write your code here
        list.add(item);
        return;
    }

    public int dequeue() {
        // Write your code here
        int ans = list.get(0);
        list.removeFirst();
        return ans;
    }
}