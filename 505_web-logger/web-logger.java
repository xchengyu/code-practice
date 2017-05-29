/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/web-logger
@Language: Java
@Datetime: 16-07-27 09:35
*/

public class WebLogger {
    private LinkedList<Integer> time;
    public WebLogger() {
        // initialize your data structure here.
        time = new LinkedList<Integer>();
    }

    /**
     * @param timestamp an integer
     * @return void
     */
    public void hit(int timestamp) {
        // Write your code here
        time.add(timestamp);
    }

    /**
     * @param timestamp an integer
     * @return an integer
     */
    public int get_hit_count_in_last_5_minutes(int timestamp) {
        // Write your code here
        while (!time.isEmpty() && time.getFirst() + 300 <= timestamp) {
            time.removeFirst();
        }
        return time.size();
    }
}