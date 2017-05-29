/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/add-digits
@Language: Java
@Datetime: 17-01-24 05:46
*/

public class Solution {
    /**
     * @param num a non-negative integer
     * @return one digit
     */
    public int addDigits(int num) {
        // Write your code here
        if (num == 0) {
            return 0;
        }
        return num % 9 == 0 ? 9 : num % 9;
    }
}