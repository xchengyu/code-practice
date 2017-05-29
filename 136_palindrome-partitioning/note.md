```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/palindrome-partitioning
@Language: Markdown
@Datetime: 17-01-16 07:55
```

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
        boolean[][] palindrome = isPalindrome(s);
        helper(s, 0, res, new ArrayList<String>(), palindrome);
        return res;
    }
    public boolean[][] isPalindrome(String s) {
        boolean[][] res = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            res[i][i] = true;
        }
        for (int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= i; j++) {
                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || res[j+1][i-1])) {
                    res[j][i] = true;
                }
            }
        }
        return res;
    }
    public void helper(String s, int start, List<List<String>> res, List<String> ans, boolean[][] palindrome) {
        if (start == s.length()) {
            res.add(new ArrayList<String>(ans));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (!palindrome[start][i]) {
                continue;
            }
            String prefix = s.substring(start, i + 1);
            ans.add(prefix);
            helper(s, i + 1, res, ans, palindrome);
            ans.remove(ans.size() - 1);
        }
        return;
    }
}