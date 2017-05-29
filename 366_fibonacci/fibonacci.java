/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/fibonacci
@Language: Java
@Datetime: 16-07-28 04:49
*/

class Solution {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        // write your code here
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        int first = 0;
        int second = 1;
        int third = 1;
        for (int i = 4; i <= n; i++) {
            first = second;
            second = third;
            third = first + second;
        }
        return third;
    }
}

