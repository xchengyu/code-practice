/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/sqrtx
@Language: Java
@Datetime: 16-12-26 06:31
*/

class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        if (x < 1) {
            return 0;
        }
        if (x >= 1 && x < 4) {
            return 1;
        }
        int res = 2 * sqrt(x / 4);
        if ((res + 1) * (res + 1) <= x && (res + 1) * (res + 1) >= 0) {
            return res + 1;
        } else {
            return res;
        }
    }
}
// class Solution {
//     /**
//      * @param x: An integer
//      * @return: The sqrt of x
//      */
//     public int sqrt(int x) {
//         // write your code here
//         // long start = 1, end = x;
//         // while (start + 1 < end) {
//         //     long mid = start + (end - start) / 2;
//         //     if (mid * mid <= x) {
//         //         start = mid;
//         //     } else {
//         //         end = mid;
//         //     }
//         // }
        
//         // if (end * end <= x) {
//         //     return (int) end;
//         // }
//         // return (int) start;
//         if(x < 4) return x == 0 ? 0 : 1;
//         int res = 2 * sqrt(x/4);
//         if((res+1) * (res+1) <= x && (res+1) * (res+1) >= 0) return res+1;
//         return res;
//     }
// }