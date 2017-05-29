/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/merge-two-sorted-arrays
@Language: Java
@Datetime: 16-07-04 08:50
*/

class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // Write your code here
        if (A == null || A.length == 0) {
            return B;
        }
        if (B == null || B.length == 0) {
            return A;
        }
        int[] newArray = new int[A.length + B.length];
        
        int pointer = 0;
         
         int pointerA = 0;
         int pointerB = 0;
         
         while (pointerA < A.length && pointerB < B.length) {
            if (A[pointerA] <= B[pointerB]) {
                 newArray[pointer] = A[pointerA];
                 pointerA++;
             } else {
                newArray[pointer] = B[pointerB];
                 pointerB++;
             }
             pointer++;
         }
         
        while (pointerA < A.length) {
             newArray[pointer] = A[pointerA];
             pointerA++;
             pointer++;
         }
         
         while (pointerB < B.length) {
             newArray[pointer] = B[pointerB];
             pointerB++;
             pointer++;
         }
         
         return newArray;
    }
}