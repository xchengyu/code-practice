/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/powx-n
@Language: Java
@Datetime: 17-05-19 09:33
*/

public class Solution {
    /**
     * @param x the base number
     * @param n the power number
     * @return the result
     */
    public double myPow(double x, int n) {
        // Write your code here
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        boolean isNegative = false;
        if (n < 0) {
            isNegative = true;
            n *= -1;
        }

        int k = n / 2;
        int l = n - k * 2;
        double t1 = myPow(x, k);
        double t2 = myPow(x, l);
        if (isNegative) {
            return 1/(t1*t1*t2);
        } else {
            return t1*t1*t2;
        }
        // long m = n > 0 ? n : -(long)n;
        // double ans = 1.0;
        // while(m!=0)
        // {
        //     if((m&1)==1)
        //     {
        //         ans*=x;
        //     }
        //     x*=x;
        //     m>>=1;
        // }
        // return n>0?ans:1/ans;
    }
}