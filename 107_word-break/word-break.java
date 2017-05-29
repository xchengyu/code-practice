/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/word-break
@Language: Java
@Datetime: 17-01-25 07:28
*/

public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if ((s == null || s.length() == 0) && (dict == null || dict.size() == 0)) {
            return true;
        }
        if (s == null || s.length() == 0) {
            return false;
        }
        if (dict == null || dict.size() == 0) {
            return false;
        }
        int maxLength = findMax(dict);
        if (maxLength == 0) {
            return false;
        }
        boolean[] canBreak = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= Math.max(0, i - maxLength + 1); j--) {
                if (dict.contains(s.substring(j, i + 1)) && (j == 0 || canBreak[j - 1])) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[s.length() - 1];
    }
    public int findMax(Set<String> dict) {
        int max = 0;
        for (String str : dict) {
            int len = str.length();
            max = Math.max(max, len);
        }
        return max;
    }
}