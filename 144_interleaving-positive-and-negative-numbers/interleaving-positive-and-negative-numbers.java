/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/interleaving-positive-and-negative-numbers
@Language: Java
@Datetime: 16-07-15 07:56
*/

class Solution {
    /**
     * @param A: An integer array.
     * @return: void
     */
    public void rerange(int[] A) {
        // write your code here
        if (A == null || A.length < 2) {
            return;
        }
        Arrays.sort(A);
        int i = 0;
        while (i < A.length) {
            if (A[i] > 0) {
                break;
            } else {
                i++;
            }
        }
        int start;
        int end;
        if ( i == A.length - i) {
            start = 1;
            end = A.length - 2;
        } else {
            if (i < A.length - i) {
                start = 0;
                end = A.length - 2;
            } else {
                start = 1;
                end = A.length - 1;
            }
        }
        while (start < end) {
            swap(A, start, end);
            start += 2;
            end -= 2;
        }
        return;
   }
   public void swap(int[]A, int start, int end) {
       int tmp = A[start];
       A[start] = A[end];
       A[end] = tmp;
       return;
   }
}