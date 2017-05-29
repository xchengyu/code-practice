/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/divide-two-integers
@Language: Java
@Datetime: 17-01-18 08:54
*/

public class Solution {
    /**
     * @param dividend the dividend
     * @param divisor the divisor
     * @return the result
     */
    public int divide(int dividend, int divisor) {
        // Write your code here
        // long a = Math.abs(Long.valueOf(dividend));
        // long b = Math.abs(Long.valueOf(divisor));
        // long res = 0;
        // while (a >= b) {
        //     for (long tmp = b, count = 1; tmp <= a; tmp <<= 1, count <<= 1) {
        //         res += count;
        //         a -= tmp;
        //     }
        // }
        // // res = (((dividend ^ divisor) >> 31) & 1) == 1 ? -res : res;
        // res = ((dividend ^ divisor) >>> 31) == 1 ? -res : res;
        // if (res > Integer.MAX_VALUE) {
        //     return Integer.MAX_VALUE;
        // }
        // return (int) res;
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        long a = Math.abs(Long.valueOf(dividend));
        long b = Math.abs(Long.valueOf(divisor));
        long res = 0;
        while (a >= b) {
            for (long tmp = b, count = 1; tmp <= a; tmp <<= 1, count <<= 1) {
                res += count;
                a -= tmp;
            }
        }
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            res = - res;
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;// no need to check second part, see notes
        }
        return (int) res;
    }
}