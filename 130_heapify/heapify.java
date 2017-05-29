/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/heapify
@Language: Java
@Datetime: 17-01-25 06:29
*/

public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        // write your code here
        if (A == null || A.length < 2) {
            return;
        }
        for (int i = A.length / 2; i >= 0; i--) {
            siftDown(A, i);
        }
        return;
    }
    public void siftDown(int[] A, int k) {
        while (k < A.length) {
            int small = k;
            if (2 * k + 1 < A.length && A[2 * k + 1] < A[small]) {
                small = 2 * k + 1;
            }
            if (2 * k + 2 < A.length && A[2 * k + 2] < A[small]) {
                small = 2 * k + 2;
            }
            if (small == k) {
                break;
            }
            int tmp = A[small];
            A[small] = A[k];
            A[k] = tmp;
            k = small;
        }
    }
}