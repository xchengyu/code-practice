/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/edit-distance-ii
@Language: Java
@Datetime: 17-05-08 09:36
*/

public class Solution {
    /**
     * @param s a string
     * @param t a string
     * @return true if they are both one edit distance apart or false
     */
    public boolean isOneEditDistance(String s, String t) {
        // Write your code here
        if (s == null || t == null) {
            return true;
        }
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        if (Math.abs(s.length() - t.length()) == 1) {
            int i = 0;
            for (i = 0; i < s.length() && i < t.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    return s.substring(i + 1).equals(t.substring(i)) || t.substring(i + 1).equals(s.substring(i));
                }
            }
            return i == s.length() || i == t.length();
        }
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 1;
    }
}