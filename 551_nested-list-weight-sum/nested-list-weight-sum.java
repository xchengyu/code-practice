/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/nested-list-weight-sum
@Language: Java
@Datetime: 17-01-11 08:51
*/

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        // Write your code here
        // Queue<NestedInteger> queue = new LinkedList<NestedInteger>();
        // for (NestedInteger element : nestedList) {
        //     queue.offer(element);
        // }
        // int depth = 0;
        // int sum = 0;
        // while (!queue.isEmpty()) {
        //     depth++;
        //     int size = queue.size();
        //     for (int i = 0; i < size; i++) {
        //         NestedInteger ele = queue.poll();
        //         if (ele.isInteger()) {
        //             sum += ele.getInteger() * depth;
        //         } else {
        //             for (NestedInteger inner : ele.getList()) {
        //                 queue.offer(inner);
        //             }
        //         }
        //     }
        // }
        // return sum;
        // Queue<NestedInteger> queue = new LinkedList<NestedInteger>();
        // int sum = 0;
        // int depth = 0;
        // for (NestedInteger elem : nestedList) {
        //     queue.offer(elem);
        // }
        // while (!queue.isEmpty()) {
        //     depth++;
        //     int size = queue.size();
        //     for (int i = 0; i < size; i++) {
        //         NestedInteger tmp = queue.poll();
        //         if (tmp.isInteger()) {
        //             sum += depth * tmp.getInteger();
        //         } else {
        //             for (NestedInteger elem : tmp.getList()) {
        //                 queue.offer(elem);
        //             }
        //         }
        //     }
        // }
        // return sum;
        int sum = 0;
        int depth = 0;
        Queue<NestedInteger> queue = new LinkedList<NestedInteger>();
        for (NestedInteger elem : nestedList) {
            queue.offer(elem);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                NestedInteger num = queue.poll();
                if (num.isInteger()) {
                    sum += depth * num.getInteger();
                } else {
                    for (NestedInteger elem : num.getList()) {
                        queue.offer(elem);
                    }
                }
            }
        }
        return sum;
        // return helper(nestedList, 1);
        
    }
    // public int helper(List<NestedInteger> nestedList, int depth) {
    //     int sum = 0;
    //     for (NestedInteger num : nestedList) {
    //         if (num.isInteger()) {
    //             sum += num.getInteger() * depth;
    //         } else {
    //             sum += helper(num.getList(), depth + 1);
    //         }
    //     }
    //     return sum;
    // }
}