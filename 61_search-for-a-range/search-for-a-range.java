/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/search-for-a-range
@Language: Java
@Datetime: 16-06-27 06:16
*/

public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        int [] range = new int[2];
        range[0] = -1;
        range[1] = -1;
        if (A == null || A.length == 0) {
            return range;
        }
        int start = 0;
        int end = A.length - 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target){
                break;
            } else if (A[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (A[mid] != target) {
            return range;
        }
        range[0] = mid;
        range[1] = mid;
        while (range[0] >= 1) {
            if (A[range[0] - 1] == target) {
                range[0]--;
            } else {
                break;
            }
        }
        while (range[1] < A.length - 1) {
            if (A[range[1] + 1] == target) {
                range[1]++;
            } else {
                break;
            }
        }
        return range;
    }
}
