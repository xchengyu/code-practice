/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/closest-number-in-sorted-array
@Language: Java
@Datetime: 16-06-27 22:27
*/

public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int closestNumber(int[] A, int target) {
        // Write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0;
        int end = A.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        int insertion = 0;
        if (A[mid] < target) {
            insertion = mid + 1;
        } else {
            insertion = mid;
        }
        if (insertion == 0) {
            return 0;
        } else if (insertion == A.length) {
            return A.length - 1;
        } else {
            int leftDiff = target - A[insertion - 1];
            int rightDiff = A[insertion] - target;
            if (leftDiff < rightDiff) {
                return insertion - 1;
            } else {
                return insertion;
            }
        }
    }
}