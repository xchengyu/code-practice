/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/generate-parentheses
@Language: Java
@Datetime: 17-01-16 07:00
*/

public class Solution {
    /**
     * @param n n pairs
     * @return All combinations of well-formed parentheses
     */
    public ArrayList<String> generateParenthesis(int n) {
        // Write your code here
        ArrayList<String> res = new ArrayList<String>();
        if (n == 0) {
            return res;
        }
        dfs(n, 0, 0, "", res);
        return res;
    }
    public void dfs(int total, int left, int right, String path, List<String> res) {
        if (left < right) {
            return;
        }
        if (left == total && right == total) {
            res.add(new String(path));
            return;
        }
        if (left < total) {
            path += "(";
            dfs(total, left + 1, right, path, res);
            path = path.substring(0, path.length() - 1);
        }
        if (right < total) {
            path += ")";
            dfs(total, left, right + 1, path, res);
            path = path.substring(0, path.length() - 1);
        }
        return;
    }
}