/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/combinations
@Language: Java
@Datetime: 17-01-20 08:57
*/

public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
		// write your code here
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (k >= n) {
		    List<Integer> path = new ArrayList<Integer>();
		    for (int i = 1; i <= n; i++) {
		        path.add(i);
		    }
		    res.add(path);
		    return res;
		}
		helper(1, n, k, new ArrayList<Integer>(), res);
		return res;
    }
    public void helper(int start, int end, int k, List<Integer> path, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        if (end - start + 1 < k) {
            return;
        }
        for (int i = start; i <= end; i++) {
            path.add(i);
            helper(i + 1, end, k - 1, path, res);
            path.remove(path.size() - 1);
        }
        return;
    }
}