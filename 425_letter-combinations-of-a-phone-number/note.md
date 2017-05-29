```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/letter-combinations-of-a-phone-number
@Language: Markdown
@Datetime: 17-05-18 09:07
```

public class Solution {
    /**
     * @param digits A digital string
     * @return all posible letter combinations
     */
    public ArrayList<String> letterCombinations(String digits) {
        // Write your code here
        Map<Integer, String> dict = new HashMap<Integer, String>();
        init(dict);
        ArrayList<String> results = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return results;
        }
        helper(digits, "", dict, results);
        return results;
    }
    public void init(Map<Integer, String> dict) {
        dict.put(2, "abc");
        dict.put(3, "def");
        dict.put(4, "ghi");
        dict.put(5, "jkl");
        dict.put(6, "mno");
        dict.put(7, "pqrs");
        dict.put(8, "tuv");
        dict.put(9, "wxyz");
        return;
    }
    public void helper(String digits, String cur, Map<Integer, String> dict, ArrayList<String> results) {
        if (digits.length() == 0) {
            results.add(new String(cur));
            return;
        }
        int digit = digits.charAt(0) - '0';
        String total = dict.get(digit);
        for (int i = 0; i < total.length(); i++) {
            cur += total.substring(i, i + 1);
            helper(digits.substring(1), cur, dict, results);
            cur = cur.substring(0, cur.length() - 1);
        }
        return;
    }
}