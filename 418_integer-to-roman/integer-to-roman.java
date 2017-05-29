/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/integer-to-roman
@Language: Java
@Datetime: 17-01-17 06:11
*/

public class Solution {
    /**
     * @param n The integer
     * @return Roman representation
     */
    public String intToRoman(int n) {
        // Write your code here
        if (n <= 0) {
            return "";
        }
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        int digit = 0;
        while (n > 0) {
            int time = n / nums[digit];
            for (int i = 0; i < time; i++) {
                sb.append(symbols[digit]);
            }
            n = n % nums[digit];
            digit++;
        }
        return sb.toString();
    }
}