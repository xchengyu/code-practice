/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/consistent-hashing
@Language: Java
@Datetime: 16-07-24 04:59
*/

public class Solution {
    /**
     * @param n a positive integer
     * @return n x 3 matrix
     */
    public List<List<Integer>> consistentHashing(int n) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(0);
        ans.add(359);
        ans.add(1);
        res.add(ans);
        for (int i = 2; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            int num = 0;
            List<Integer> maxGroup = new ArrayList<Integer>();
            for (List<Integer> group : res) {
                int size = group.get(1) - group.get(0) + 1;
                if (size > max || (size == max && group.get(2) < maxGroup.get(2))) {
                    maxGroup = group;
                    max = size;
                    num = group.get(2);
                }
            }
            int start = maxGroup.get(0);
            int end = maxGroup.get(1);
            int mid = start + (end - start) / 2;
            List<Integer> newGroup = new ArrayList<Integer>();
            newGroup.add(mid + 1);
            newGroup.add(end);
            newGroup.add(i);
            res.add(newGroup);
            maxGroup.set(1, mid);
        }
        return res;
    }
}