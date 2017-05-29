/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/big-integer-addition
@Language: Java
@Datetime: 17-05-19 08:10
*/

public class Solution {
    /**
     * @param num1 a non-negative integers
     * @param num2 a non-negative integers
     * @return return sum of num1 and num2
     */
    public String addStrings(String num1, String num2) {
        // Write your code here
        int end1 = num1.length() - 1;
        int end2 = num2.length() - 1;
        int carry = 0;
        String result = "";
        while (end1 >= 0 && end2 >= 0) {
            int cur1 = num1.charAt(end1) - '0';
            int cur2 = num2.charAt(end2) - '0';
            int newCur = (cur1 + cur2 + carry) % 10;
            carry = (cur1 + cur2 + carry) / 10;
            result = newCur + result;
            end1--;
            end2--;
        }
        while (end1 >= 0) {
            int cur1 = num1.charAt(end1) - '0';
            int newCur = (cur1 + carry) % 10;
            carry = (cur1 + carry) / 10;
            result = newCur + result;
            end1--;
        }
        while (end2 >= 0) {
            int cur2 = num2.charAt(end2) - '0';
            int newCur = (cur2 + carry) % 10;
            carry = (cur2 + carry) / 10;
            result = newCur + result;
            end2--;
        }
        if (carry != 0) {
            result = carry + result;
        }
        return result;
    }
}