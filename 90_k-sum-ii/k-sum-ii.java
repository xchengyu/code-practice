/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/k-sum-ii
@Language: Java
@Datetime: 16-07-07 23:05
*/

public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer 
     */ 
    public ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (A == null || A.length == 0) {
            return res;
        }
        helper(A, k, target, 0, 0, res, new ArrayList<Integer>());
        return res;
    }
    public void helper(int[] A, int k, int target, int start, int sum, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> ans) {
        if (sum == target && k == 0) {
            res.add(new ArrayList<Integer>(ans));
            return;
        }
        if (k < 0) {
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < A.length; i++) {
            ans.add(A[i]);
            helper(A, k - 1, target, i + 1, sum + A[i], res, ans);
            ans.remove(ans.size() - 1);
        }
        return;
    }
}