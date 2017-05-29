/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/drop-eggs
@Language: Java
@Datetime: 17-01-12 10:43
*/

public class Solution {
    /**
     * @param n an integer
     * @return an integer
     */
    public int dropEggs(int n) {
        // Write your code here
        // long ans = 0;
        // for (int i = 1; ; ++i) {
        //     ans += (long)i;
        //     if (ans >= (long)n)
        //         return i;
        // }
        long ans = 0;
        for (int i = 1; ; i++) {
            ans += Long.valueOf(i);
            if (ans >= Long.valueOf(n)) {
                return i;
            }
        }
    }
}