/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/flatten-list
@Language: Java
@Datetime: 17-05-14 09:59
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

    // @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
        List<Integer> result = new ArrayList<Integer>();
        if (nestedList == null || nestedList.size() == 0) {
            return result;
        }
        for (NestedInteger element : nestedList) {
            if (element.isInteger()) {
                result.add(element.getInteger());
            } else {
                result.addAll(flatten(element.getList()));
            }
        }
        return result;
    }
}