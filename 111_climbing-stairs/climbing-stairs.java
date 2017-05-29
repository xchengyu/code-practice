/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/climbing-stairs
@Language: Java
@Datetime: 16-07-01 04:06
*/

public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if (n < 0) {
            return 0;
        }
        int[]res = new int[2];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            res[i % 2] = res[(i - 1) % 2] + res[(i - 2) % 2];
        }
        return res[n % 2];
    }
}