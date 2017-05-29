/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/strstr
@Language: Java
@Datetime: 17-05-22 10:00
*/

class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        // write your code here
        if (source == null || target == null || source.length() < target.length()) {
            return -1;
        }
        if (target.length() == 0) {
            return 0;
        }
        if (source.equals(target)) {
            return 0;
        }
        for (int i = 0; i <= source.length() - target.length(); i++) {
            if (source.charAt(i) == target.charAt(0)) {
                int j = 0;
                for (; j < target.length(); j++) {
                    if (source.charAt(i + j) != target.charAt(j)) {
                        break;
                    }
                }
                if (j == target.length()) {
                    return i;
                }
            }
        }
        return -1;
    }
}