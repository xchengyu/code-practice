/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/top-k-largest-numbers-ii
@Language: Java
@Datetime: 16-07-06 23:20
*/

public class Solution {
    Queue<Integer> queue;
    int tk;
    public Solution(int k) {
        // initialize your data structure here.
        queue = new PriorityQueue<Integer>(k);
        tk = k;
    }

    public void add(int num) {
        // Write your code here
        if (queue.size() < tk){
            queue.add(num);
        } else {
            int tmp = queue.peek();
            if (num > tmp) {
                queue.poll();
                queue.add(num);
            }
        }
        return;
    }

    public List<Integer> topk() {
        // Write your code here
        List<Integer> res = new ArrayList<Integer>();
        if (tk <= queue.size()) {
            for (int i = 0; i < tk; i++) {
                res.add(0, queue.poll());
            }
        } else {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                res.add(0, queue.poll());
            }
        }
        queue.addAll(res);
        return res;
    }
};