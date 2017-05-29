/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/valid-number
@Language: Java
@Datetime: 16-07-31 11:18
*/

public class Solution {
    /**
     * @param s the string that represents a number
     * @return whether the string is a valid number
     */
    public boolean isNumber(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return false;
        }
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        int index = 0;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            index++;
        }
        boolean num = false;
        boolean dot = false;
        boolean exp = false;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                num = true;
            } else if (c == '.') {
                if (dot || exp) {
                    return false;
                }
                dot = true;
            } else if (c == 'e') {
                if (exp || !num) {
                    return false;
                }
                exp = true;
            } else if (c == '+' || c == '-') {
                if (index - 1 < 0 || s.charAt(index - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
            index++;
        }
        return num;
    }
}