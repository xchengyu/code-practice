/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/reverse-integer
@Language: Java
@Datetime: 17-01-11 10:34
*/

public class Solution {
    /**
     * @param n the integer to be reversed
     * @return the reversed integer
     */
    public int reverseInteger(int n) {
        // Write your code here
        // int reversed_n = 0;
        
        // while (n != 0) {
        //     int temp = reversed_n * 10 + n % 10;
        //     n = n / 10;
        //     if (temp / 10 != reversed_n) {//Returns 0 when the reversed integer overflows (signed 32-bit integer).
        //         reversed_n = 0;
        //         break;
        //     }
        //     reversed_n = temp;
        // }
        // return reversed_n;
        // int reverse = 0;
        // while (n != 0) {
        //     int tmp = reverse * 10 + n % 10;
        //     n = n / 10;
        //     if (tmp / 10 != reverse) {
        //         return 0;
        //     }
        //     reverse = tmp;
        // }
        // return reverse;
        if (n == 0) {
            return 0;
        }
        boolean positive = n > 0 ? true : false;
        long value = Long.valueOf(0);
        long tmp = Long.valueOf(n);
        if (tmp < 0) {
            tmp = -tmp;
        }
        while (tmp > 0) {
            value = value * 10 + tmp % 10;
            tmp = tmp / 10;
        }
        int ret = 0;
        if (positive) {
            if (value > Integer.MAX_VALUE) {
                return 0;
            } else {
                ret = (int) value; 
            }
        } else {
            value = -value;
            if (value < Integer.MIN_VALUE) {
                return 0;
            } else {
                ret = (int) value;
            }
        }
        return ret;
    }
}