/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/find-peak-element
@Language: Java
@Datetime: 16-12-26 08:08
*/

class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        if (A.length < 4) {
            return 1;
        }
        int left = 0;
        int right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return mid;
            } else if (A[mid] >= A[mid - 1] && A[mid] <= A[mid + 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return A[left] > A[right] ? left : right;
    }
}
// class Solution {
//     /**
//      * @param A: An integers array.
//      * @return: return any of peek positions.
//      */
//     public int findPeak(int[] A) {
//         // write your code here
//         if (A == null || A.length < 3) {
//             return 0;
//         }
//         int start = 1;
//         int end = A.length - 2;
//         int mid = 0;
//         while (start + 1 < end) {
//             mid = start + (end - start) / 2;
//             if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
//                 return mid;
//             } else if (A[mid] < A[mid - 1] || A[mid] > A[mid + 1]) {
//                 end = mid;
//             } else if (A[mid] < A[mid + 1] || A[mid] > A[mid - 1]) {
//                 start = mid;
//             }
//         }
//         if (A[start] > A[end]) {
//             return start;
//         } else {
//             return end;
//         }
//     }
// }

