/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/sort-integers
@Language: Java
@Datetime: 16-07-28 05:12
*/

public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers(int[] A) {
        // Write your code here
        if (A == null || A.length < 2) {
            return;
        }
        //bubble sort
        // for (int i = A.length - 1; i >= 0; i--) {
        //     for (int j = 0; j < i; j++) {
        //         if (A[j] > A[j + 1]) {
        //             int tmp = A[j + 1];
        //             A[j + 1] = A[j];
        //             A[j] = tmp;
        //         }
        //     }
        // }
        //insertion sort
        // for (int i = 1; i < A.length; i++) {
        //     int tmp = A[i];
        //     int j;
        //     for (j = i; j > 0 && A[j - 1] >= tmp; j--) {
        //         A[j] = A[j - 1];
        //     }
        //     A[j] = tmp;
        // }
        //selection sort
        for (int i = 0; i < A.length; i++) {
            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int j = i; j < A.length; j++) {
                if (A[j] < min) {
                    min = A[j];
                    index = j;
                }
            }
            int tmp = A[i];
            A[i] = min;
            A[index] = tmp;
        }
        return;
    }
}