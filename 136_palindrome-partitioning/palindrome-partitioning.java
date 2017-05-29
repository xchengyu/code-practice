/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/palindrome-partitioning
@Language: Java
@Datetime: 17-01-16 07:55
*/

public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> res = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) {
            return res;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        isPalindrome(s, dp);
        dfs(s, dp, 0, new ArrayList<String>(), res);
        return res;
    }
    public void isPalindrome(String s, boolean[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                }
            }
        }
        return;
    }
    public void dfs(String s, boolean[][] dp, int start, List<String> path, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<String>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (!dp[start][i]) {
                continue;
            } else {
                String cur = s.substring(start, i + 1);
                path.add(cur);
                dfs(s, dp, i + 1, path, res);
                path.remove(path.size() - 1);
            }
        }
        return;
    }
}