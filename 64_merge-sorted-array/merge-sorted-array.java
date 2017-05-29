/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/merge-sorted-array
@Language: Java
@Datetime: 16-07-04 03:59
*/

class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        if (B == null || n == 0) {
            return;
        }
        for (int i = m - 1; i >= 0; i--) {
            A[i + n] = A[i];
        }
        int indexA = n;
        int indexB = 0;
        int index = 0;
        while (indexA <= n + m - 1 && indexB <= n - 1) {
            if (A[indexA] < B[indexB]) {
                A[index++] = A[indexA++];
            } else {
                A[index++] = B[indexB++];
            }
        }
        if (indexB != n) {
            while (index <= n + m -1) {
                A[index++] = B[indexB++];
            }
        }
        return;
    }
}