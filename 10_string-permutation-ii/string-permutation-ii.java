/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/string-permutation-ii
@Language: Java
@Datetime: 16-07-07 23:49
*/

public class Solution {
    /**
     * @param str a string
     * @return all permutations
     */
    public List<String> stringPermutation2(String str) {
        // Write your code here
        List<String> res = new ArrayList<String>();
        if (str == null) {
            return res;
        }
        if (str.length() == 0) {
            res.add("");
            return res;
        }
        str = str.trim();
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        boolean[] visit = new boolean[str.length()];
        Arrays.fill(visit, false);
        helper(ch, visit, res, new ArrayList<Character>());
        return res;
    }
    public void helper(char[] ch, boolean[] visit, List<String> res, ArrayList<Character> ans) {
        if (ans.size() == ch.length) {
            StringBuilder sb = new StringBuilder("");
            for (Character i : ans) {
                sb.append(i);
            }
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < ch.length; i++) {
            if (visit[i] || i != 0 && !visit[i - 1] && ch[i] == ch[i - 1]) {
                continue;
            }
            if (!visit[i]) {
                ans.add(ch[i]);
                visit[i] = true;
                helper(ch, visit, res, ans);
                ans.remove(ans.size() - 1);
                visit[i] = false;
            } else {
                continue;
            }
        }
        return;
    }
}