/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/strstr-ii
@Language: Java
@Datetime: 17-05-22 10:02
*/

public class Solution {
    /**
     * @param source a source string
     * @param target a target string
     * @return an integer as index
     */
    public int strStr2(String source, String target) {
        // Write your code here
        if (source == null || target == null || source.length() < target.length()) {
            return -1;
        }
        if (target.length() == 0 || source.equals(target)) {
            return 0;
        }
        int m = target.length();
        int n = source.length();
        // mod could be any big integer
        // just make sure mod * 33 wont exceed max value of int.
        int hash = 33;
        int mod = Integer.MAX_VALUE / hash;
        int hash_target = 0;
        int m33 = 1;
        for (int i = 0; i < m - 1; i++) {
            m33 = m33 * hash % mod;
        }
        for (int i = 0; i < m; i++) {
            hash_target = (hash_target * hash + target.charAt(i) - 'a') % mod;
            if (hash_target < 0) {//may overflow
                hash_target += mod;
            }
        }
        int value = 0;
        for (int i = 0; i < n; i++) {
            if (i >= m) {
                value = (value - (source.charAt(i - m) - 'a') * m33) % mod;
            }
            value = (value * hash + (source.charAt(i) - 'a')) % mod;
            if (value < 0) {//may overflow
                value += mod;
            }
            if (i >= m - 1 && value == hash_target) {
                if (target.equals(source.substring(i - m + 1, i + 1))) {
                    return i - m + 1;
                }
            }
        }
        return -1;
    }
}