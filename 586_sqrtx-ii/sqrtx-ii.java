/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/sqrtx-ii
@Language: Java
@Datetime: 17-02-24 10:13
*/

public class Solution {
    /**
     * @param x a double
     * @return the square root of x
     */
    public double sqrt(double x) {
        // Write your code here
        if (x <= 0) {
            return 0;
        }
        double left = 0;
        double right = (x / 1.0) + 1;
        while (right - left > 1e-12) {//accuracy depends on how many digits we need to remain after the dot 
            double mid = (right + left) / 2.0;
            if (mid * mid == x) {
                return mid;
            } else if (mid * mid < x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
}