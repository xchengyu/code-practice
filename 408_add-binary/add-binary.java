/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/add-binary
@Language: Java
@Datetime: 16-07-28 05:26
*/

public class Solution {
    /**
     * @param a a number
     * @param b a number
     * @return the result
     */
    public String addBinary(String a, String b) {
        // Write your code here
        if (a == null || a.length() == 0) {
            if (b == null || b.length() == 0) {
                return "";
            }
            return b;
        }
        if (b == null || b.length() == 0) {
            if (a == null || a.length() == 0) {
                return "";
            }
            return a;
        }
        int cnt = 0;
        int sum = 0;
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();
        int i = aChar.length - 1;
        int j = bChar.length - 1;
        String res = "";
        while (i >= 0 && j >= 0) {
            int ta = aChar[i--] - '0';
            int tb = bChar[j--] - '0';
            sum = (ta + tb + cnt) % 2;
            cnt = (ta + tb + cnt) / 2;
            res = sum + res;
        }
        while ( i >= 0) {
            int ta = aChar[i--] - '0';
            sum = (ta + cnt) % 2;
            cnt = (ta + cnt) / 2;
            res = sum + res;
        }
        while ( j >= 0) {
            int tb = bChar[j--] - '0';
            sum = (tb + cnt) % 2;
            cnt = (tb + cnt) / 2;
            res = sum + res;
        }
        if (cnt != 0) {
            res = cnt + res;
        }
        return res;
    }
}