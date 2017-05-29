/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/restore-ip-addresses
@Language: Java
@Datetime: 17-01-16 05:12
*/

public class Solution {
    /**
     * @param s the IP string
     * @return All possible valid IP addresses
     */
    public ArrayList<String> restoreIpAddresses(String s) {
        // Write your code here
        ArrayList<String> res = new ArrayList<String>();
        if (s == null || s.length() == 0) {
            return res;
        }
        dfs(s, 0, 4, "", res);
        return res;
    }
    public void dfs(String s, int level, int total, String path, List<String> res) {
        if (level == total) {
            if (s == null || s.length() == 0) {
                res.add(new String(path.substring(0, path.length() - 1)));
            }
            return;
        }
        for (int i = 0; i < Math.min(3, s.length()); i++) {
            String cur = s.substring(0, i + 1);
            if (isValid(cur)) {
                path += cur + ".";
                dfs(s.substring(i + 1), level + 1, total, path, res);
                path = path.substring(0, path.length() - 2 - i);
            }
        }
        return;
    }
    public boolean isValid(String s) {
        if (s.charAt(0) == '0') {
            return s.equals("0");
        }
        int ip = Integer.parseInt(s);
        return ip <= 255 && ip >= 0;
    }
}