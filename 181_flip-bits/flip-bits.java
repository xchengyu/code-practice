/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/flip-bits
@Language: Java
@Datetime: 16-12-27 05:52
*/

class Solution {
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        // write your code here
        if (a == b) {
            return 0;
        }
        int count = 0;
        int xor = a ^ b;
        while (xor != 0) {
            xor = (xor & (xor - 1));
            count++;
        }
        return count;
    }
};
// class Solution {
//     /**
//      *@param a, b: Two integer
//      *return: An integer
//      */
//     public static int bitSwapRequired(int a, int b) {
//         // write your code here
//         if ( a == b) {
//             return 0;
//         }
//         int count = 0;
//         // for (int c = a ^ b; c != 0; c = c >>> 1) {
//         //     count += (c & 1);
//         // }
//         // return count;
//         int xor = a ^ b;
//         while (xor != 0) {
//             xor = (xor & (xor - 1));
//             count++;
//         }
//         return count;
//     }
// };
