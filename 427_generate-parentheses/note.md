```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/generate-parentheses
@Language: Markdown
@Datetime: 17-01-16 07:00
```

public class Solution {
    /**
     * @param n n pairs
     * @return All combinations of well-formed parentheses
     */
    public ArrayList<String> generateParenthesis(int n) {
        // Write your code here
        ArrayList<String> results = new ArrayList<String>();
        if (n == 0) {
            return results;
        }
        dfs(1, 0, n, "(", results);
        return results;
    }
    public void dfs(int left, int right, int total, String cur, ArrayList<String> results) {
        if (left > total || right > total || right > left) {
            return;
        }
        if (left == total && right == total) {
            results.add(new String(cur));
            return;
        }
        if (left < total) {
            cur += "(";
            dfs(left + 1, right, total, cur, results);
            cur = cur.substring(0, cur.length() - 1);
        }
        if (right < total) {
            cur += ")";
            dfs(left, right + 1, total, cur, results);
            cur = cur.substring(0, cur.length() - 1);
        }
        return;
    }
}