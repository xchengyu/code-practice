/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/search-in-rotated-sorted-array
@Language: Java
@Datetime: 16-06-27 06:44
*/

public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        int pivot = findMin(A);
        if (A[pivot] == target) {
            return pivot;
        }
        if (A[pivot] > target) {
            return -1;
        }
        if (pivot == 0 && target > A[A.length - 1]) {
            return -1;
        }
        if (target > A[A.length - 1]) {
            return helper(A, 0, pivot - 1, target);
        } else {
            return helper(A, pivot + 1, A.length - 1, target);
        }
    }
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        if (num == null || num.length <= 1) {
            return 0;
        }
        int start = 0;
        int end = num.length - 1;
        int mid = 0;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (mid > start && mid < end && num[mid] < num[mid - 1] && num[mid] < num[mid + 1]) {
                return mid;
            }
            if (num[mid] < num[end] && num[mid] < num[start]) {
                end = mid;
            } else if (num[mid] > num[start] && num[mid] > num[end]) {
                start = mid + 1;
            } else if (num[mid] >= num[start] && num[mid] < num[end]) {
                return start;
            } else {
                return end;
            }
        }
        return mid;
    }
    public int helper(int[] num, int start, int end, int target) {
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (num[mid] == target) {
                return mid;
            } else if (num[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
