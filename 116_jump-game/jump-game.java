/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/jump-game
@Language: Java
@Datetime: 17-01-25 08:15
*/

public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        // greedy O(n)
        // if (A == null || A.length == 0) {
        //     return true;
        // }
        // int farthest = A[0];
        // for (int i = 1; i < A.length; i++) {
        //     if (i <= farthest && i + A[i] > farthest) {
        //         farthest = i + A[i];
        //     }
        // }
        // return farthest >= A.length - 1;
        if (A == null || A.length == 0) {
            return true;
        }
        int farthest = A[0];
        int i = 0;
        while (i <= farthest) {
            if (farthest >= A.length - 1) {
                return true;
            }
            farthest = Math.max(farthest, A[i] + i);
            i++;
        }
        return false;
    }
    // public boolean canJump(int[] A) {
    //     //dp O(n^2)
    //     if (A == null || A.length == 0) {
    //         return true;
    //     }
    //     boolean[] result = new boolean[A.length];
    //     for (int i = 0; i < result.length; i++) {
    //         result[i] = false;
    //     }
    //     result[0] = true;
    //     for (int i = 1; i < A.length; i++) {
    //         for (int j = i; j >= 0; j--) {
    //             if (result[j] && A[j] + j >= i) {
    //                 result[i] = true;
    //                 break;
    //             }
    //         }
    //     }
    //     return result[A.length - 1];
    // }
}
// public class Solution {
//     /**
//      * @param A: A list of integers
//      * @return: The boolean answer
//      */
//     public boolean canJump(int[] A) {
//         // wirte your code here
//         if (A == null || A.length <= 1) {
//             return true;
//         }
//         boolean[] res = new boolean[A.length];
//         for (int i = 0; i < res.length; i++) {
//             res[i] = false;
//         }
//         res[0] = true;
//         for (int i = 1; i < res.length; i++) {
//             for (int j = i; j >= 0; j--) {
//                 if (res[j] && i - j <= A[j]) {
//                     res[i] = true;
//                     break;
//                 }
//             }
//         }
//         return res[res.length - 1];
//     }
// }

