/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/remove-element
@Language: Java
@Datetime: 16-12-25 04:49
*/

// public class Solution {
//     /** 
//      *@param A: A list of integers
//      *@param elem: An integer
//      *@return: The new length after remove
//      */
//     public int removeElement(int[] A, int elem) {
//         // write your code here
//         if (A == null || A.length == 0) {
//             return 0;
//         }
//         int end = A.length - 1;
//         int front = 0;
//         while (front <= end) {
//             if (A[front] == elem) {
//                 A[front] = A[end];
//                 end--;
//             } else {
//                 front++;
//             }
//         }
//         return front;
//     }
// }

public class Solution {
    /** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
            if (A[left] == elem) {
                A[left] = A[right--];
            } else {
                left++;
            }
        }
        return left;
    }
}
