/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/search-insert-position
@Language: Java
@Datetime: 16-12-26 06:39
*/

public class Solution {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int left = 0;
        int right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (target <= A[left]) {
            return left;
        } else if (target <= A[right]) {
            return right;
        } else {
            return right + 1;
        }
    }
}
// public class Solution {
//     /** 
//      * param A : an integer sorted array
//      * param target :  an integer to be inserted
//      * return : an integer
//      */
//     public int searchInsert(int[] A, int target) {
//         // write your code here
//         if (A == null || A.length == 0) {
//             return 0;
//         }
//         int start = 0;
//         int end = A.length - 1;
//         int mid = 0;
//         while (start <= end) {
//             mid = start + (end - start) / 2;
//             if (A[mid] == target) {
//                 return mid;
//             } else if (A[mid] < target) {
//                 start = mid + 1;
//             } else {
//                 end = mid - 1;
//             }
//         }
//         return A[mid] < target ? mid + 1 : mid;
//     }
// }
