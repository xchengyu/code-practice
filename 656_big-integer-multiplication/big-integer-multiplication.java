/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/big-integer-multiplication
@Language: Java
@Datetime: 17-05-19 09:07
*/

public class Solution {
    /**
     * @param num1 a non-negative integers
     * @param num2 a non-negative integers
     * @return return product of num1 and num2
     */
    public String multiply(String num1, String num2) {
        // Write your code here
        String result = "";
        for (int i = num2.length() - 1; i >= 0; i--) {
            int cur = num2.charAt(i) - '0';
            String tmp = multi(cur, num1, num2.length() - 1 - i);
            result = addStrings(tmp, result);
        }
        return result;
    }
    
    public String multi(int times, String num, int zeroNum) {
        int carry = 0;
        String result = "";
        boolean allZero = true;
        for (int i = num.length() - 1; i >= 0; i--) {
            int cur = num.charAt(i) - '0';
            int sum = (cur * times + carry) % 10;
            carry = (cur * times + carry) / 10;
            result = sum + result;
            if (sum != 0) {
                allZero = false;
            }
        }
        if (carry != 0) {
            result = carry + result;
        }
        for (int i = 0; i < zeroNum; i++) {
            result += 0 + "";
        }
        return (carry == 0 && allZero) ? "0" : result;
    }
    
    public String addStrings(String num1, String num2) {
        // Write your code here
        int end1 = num1.length() - 1;
        int end2 = num2.length() - 1;
        int carry = 0;
        String result = "";
        boolean allZero = true;
        while (end1 >= 0 && end2 >= 0) {
            int cur1 = num1.charAt(end1) - '0';
            int cur2 = num2.charAt(end2) - '0';
            int newCur = (cur1 + cur2 + carry) % 10;
            carry = (cur1 + cur2 + carry) / 10;
            result = newCur + result;
            if (newCur != 0) {
                allZero = false;
            }
            end1--;
            end2--;
        }
        while (end1 >= 0) {
            int cur1 = num1.charAt(end1) - '0';
            int newCur = (cur1 + carry) % 10;
            carry = (cur1 + carry) / 10;
            result = newCur + result;
            if (newCur != 0) {
                allZero = false;
            }
            end1--;
        }
        while (end2 >= 0) {
            int cur2 = num2.charAt(end2) - '0';
            int newCur = (cur2 + carry) % 10;
            carry = (cur2 + carry) / 10;
            result = newCur + result;
            if (newCur != 0) {
                allZero = false;
            }
            end2--;
        }
        if (carry != 0) {
            result = carry + result;
        }
        return (carry == 0 && allZero) ? "0" : result;
    }
}