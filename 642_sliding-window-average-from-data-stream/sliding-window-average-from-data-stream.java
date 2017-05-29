/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/sliding-window-average-from-data-stream
@Language: Java
@Datetime: 17-05-08 02:06
*/

public class MovingAverage {
    private Queue<Integer> queue;
    private long sum;
    private int size;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.queue = new LinkedList<Integer>();
        this.sum = 0;
        this.size = size;
    }
    
    public double next(int val) {
        // Write your code here
        if (queue.size() < size) {
            queue.offer(val);
            sum += val;
        } else {
            sum -= queue.poll();
            sum += val;
            queue.offer(val);
        }
        return (double) sum / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param = obj.next(val);
 */