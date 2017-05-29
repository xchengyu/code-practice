/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/o1-check-power-of-2
@Language: Java
@Datetime: 16-07-21 07:50
*/

class Solution {
    /*
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        // write your code here
        return n <= 0 ? false : (n & (n - 1)) == 0;
    }
};