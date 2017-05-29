```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/roman-to-integer
@Language: Markdown
@Datetime: 17-01-17 06:02
```

public class Solution {
    /**
     * @param s Roman representation
     * @return an integer
     */
    public int romanToInt(String s) {
        // Write your code here
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        dict.put("I", 1);
        dict.put("V", 5);
        dict.put("X", 10);
        dict.put("L", 50);
        dict.put("C", 100);
        dict.put("D", 500);
        dict.put("M", 1000);
        dict.put("IV", 4);
        dict.put("IX", 9);
        dict.put("XL", 40);
        dict.put("XC", 90);
        dict.put("CD", 400);
        dict.put("CM", 900);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && dict.containsKey(s.substring(i, i + 2))) {
                res += dict.get(s.substring(i, i + 2));
                i++;
            } else {
                res += dict.get(s.substring(i, i + 1));
            }
        }
        return res;
    }
}