/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/permutation-index
@Language: Java
@Datetime: 17-01-12 08:51
*/

public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndex(int[] A) {
        // Write your code here
        // if (A == null || A.length < 2) {
        //     return 1;
        // }
        // long index = 0;
        // long factorial = 1;
        // int number = 1;
        // for (int i = A.length - 1; i >= 0; i--) {
        //     int count = 0;
        //     int j;
        //     for (j = i + 1; j < A.length; j++) {
        //         if (A[j] < A[i]) {
        //             count++;
        //         }
        //     }
        //     if (i == j + 1) {
        //         count = 0;
        //     }
        //     index += Long.valueOf(count) * factorial;
        //     factorial *= Long.valueOf(number++); 
        // }
        // return index + 1;
        // if (A == null || A.length < 2) {
        //     return 1;
        // }
        // long index = Long.valueOf(1);
        // int number = 1;
        // long factorial = Long.valueOf(1);
        // int count = 0;
        // for (int i = A.length - 2; i >= 0; i--) {
        //     count = 0;
        //     int j;
        //     for (j = i + 1; j < A.length; j++) {
        //         if (A[j] < A[i]) {
        //             count++;
        //         }
        //     }
        //     index += Long.valueOf(count) * factorial;
        //     factorial *= Long.valueOf(++number);
        // }
        // return index;
        if (A == null || A.length < 2) {
            return 1;
        }
        long index = Long.valueOf(1);
        long factorial = Long.valueOf(1);
        int count = 0;
        int number = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            count = 0;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[i]) {
                    count++;
                }
            }
            index += Long.valueOf(count) * factorial;
            factorial *= Long.valueOf(++number);
        }
        return index;
    }
}