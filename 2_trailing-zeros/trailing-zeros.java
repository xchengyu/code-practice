/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/trailing-zeros
@Language: Java
@Datetime: 16-12-27 06:58
*/

class Solution {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // write your code here
        if (n <= 0) {
            return Long.valueOf(1);
        }
        if (n <= 4) {
            return Long.valueOf(0);
        }
        long count = Long.valueOf(0);
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
};
// class Solution {
//     /*
//      * param n: As desciption
//      * return: An integer, denote the number of trailing zeros in n!
//      */
//     public long trailingZeros(long n) {
//         // write your code here
//     //     if (n <= 0) {
//     //         return Long.valueOf(1);
//     //     }
//     //     if (n <= 4) {
//     //         return Long.valueOf(0);
//     //     }
//     //     long cnt = 0;
//     //     while (n > 0) {
//     //         cnt += n / 5;
//     //         n = n / 5;
//     //     }
//     //     return cnt;
//         if (n <= 0) {
//             return Long.valueOf(1);
//         }
//         if (n <= 4) {
//             return Long.valueOf(0);
//         }
//         long count = Long.valueOf(0);
//         while (n > 0) {
//             count += n / 5;
//             n = n / 5;
//         }
//         return count;
//     }
// };

