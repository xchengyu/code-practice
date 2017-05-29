```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/restore-ip-addresses
@Language: Markdown
@Datetime: 17-01-16 05:12
```

public class Solution {
    /**
     * @param s the IP string
     * @return All possible valid IP addresses
     */
    public ArrayList<String> restoreIpAddresses(String s) {
        // Write your code here
        ArrayList<String> res = new ArrayList<String>();
        ArrayList<String> list = new ArrayList<String>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return res;
        }
        helper(s, 0, res, list);
        return res;
    }
    public void helper(String s, int start, ArrayList<String> res, ArrayList<String> list) {
        if (list.size() == 4) {
            if (start != s.length()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (String tmp : list) {
                sb.append(tmp);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length()-1);
            res.add(sb.toString());
            return;
        }
        for (int i = start; i < s.length() && i <= start + 2; i++) {
            String tmp = s.substring(start, i + 1);
            if (isValid(tmp)) {
                list.add(tmp);
                helper(s, i + 1, res, list);
                list.remove(list.size() - 1);
            }
        }
    }
    public boolean isValid(String s) {
        if (s.charAt(0) == '0') {
            return s.equals("0");
        }
        int ip = Integer.parseInt(s);
        return ip <= 255 && ip >= 0;
    }
}