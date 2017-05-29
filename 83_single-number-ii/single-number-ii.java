/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/single-number-ii
@Language: Java
@Datetime: 17-01-27 09:42
*/

public class Solution {
	/**
	 * @param A : An integer array
	 * @return : An integer 
	 */
    public int singleNumberII(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        int bit = 1;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < A.length; j++) {
                if ((A[j] & bit) != 0) {
                    sum++;
                }
            }
            sum %= 3;
            res += (sum << i);
            bit <<= 1;
        }
        return res;
    }
}
// public class Solution {
// 	/**
// 	 * @param A : An integer array
// 	 * @return : An integer 
// 	 */
//     public int singleNumberII(int[] A) {
//         // write your code here
//         if (A == null || A.length == 0) {
//             return -1;
//         }
//         int res = 0;
//         for (int i = 0; i < 32; i++) {
//             int sum = 0;
//             for (int j = 0; j < A.length; j++) {
//                 if (((A[j] >> i) & 1) == 1) {
//                     sum++;
//                     sum %= 3;
//                 }
//             }
//             res += (sum << i);
//         }
//         return res;
//     }
// }
// public class Solution {
// 	/**
// 	 * @param A : An integer array
// 	 * @return : An integer 
// 	 */
//     public int singleNumberII(int[] A) {
//         // write your code here
//         if (A == null || A.length == 0) {
//             return -1;
//         }
//         int res = 0;
//         int[] bit = new int[32];
//         for (int i = 0; i < 32; i++) {
//             int sum = 0;
//             for (int j = 0; j < A.length; j++) {
//                 if (((A[j] >> i) & 1) == 1) {
//                     sum++;
//                     sum = sum % 3;
//                 }
//             }
//             res += (sum << i);
//         }
//         return res;
//     }
// }