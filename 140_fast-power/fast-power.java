/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/fast-power
@Language: Java
@Datetime: 17-01-24 09:47
*/

class Solution {
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        // write your code here
        if (b == 1) {
            return 0;
        }
        if (a == 0) {
            return 0;
        }
        if (n == 0) {
            return b == 1 ? 0 : 1;
        }
        if (n == 1) {
            return a % b;
        }
        long halfRes = fastPower(a, b, n / 2);
        long total = ((halfRes % b) * (halfRes % b)) % b; 
        if (n % 2 == 1) {
            total = (total * a) % b;
        }
        return (int) total;
    }
};