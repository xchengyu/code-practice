/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/string-to-integer-ii
@Language: Java
@Datetime: 16-12-24 10:57
*/

// public class Solution {
//     /**
//      * @param str: A string
//      * @return An integer
//      */
//     public int atoi(String str) {
//         // write your code here
//         if (str == null || str.length() == 0) {
//             return 0;
//         }
//         str = str.trim();
//         char flag = '+';
//         int i = 0;
//         if (str.charAt(i) == '-') {
//             flag = '-';
//             i++;
//         } else if (str.charAt(i) == '+') {
//             i++;
//         }
//         double res = 0;//cannot be long, in 32bit machine, long variable costs 4 byte, same as int
//         while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
//             res = res * 10 + (str.charAt(i) - '0');
//             i++;
//         }
//         res = flag == '+' ? res : -res;
//         if (res > Integer.MAX_VALUE) {
//             return Integer.MAX_VALUE;
//         } else if (res < Integer.MIN_VALUE) {
//             return Integer.MIN_VALUE;
//         } else {
//             return (int) res;
//         }
//     }
// }
public class Solution {
    /**
     * @param str: A string
     * @return An integer
     */
    public int atoi(String str) {
        // write your code here
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        char flag = '+';
        int i = 0;
        double res = 0;
        if (str.charAt(i) == '-') {
            flag = '-';
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            res = 10 * res + (str.charAt(i) - '0');
            i++;
        }
        res = flag == '+' ? res : -res;
        if (res >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (res <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int)res;
        }
    }
}