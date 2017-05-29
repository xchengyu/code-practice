/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/reverse-pairs
@Language: Java
@Datetime: 17-01-15 07:58
*/

public class Solution {
    /**
     * @param A an array
     * @return total of reverse pairs
     */
    public long reversePairs(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return Long.valueOf(0);
        }
        return mergeSort(A, 0, A.length - 1);
    }
    
    private long mergeSort(int[] A, int start, int end) {
        if (start == end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        long sum = Long.valueOf(0);
        sum += mergeSort(A, start, mid);
        sum += mergeSort(A, mid + 1, end);
        sum += merge(A, start, end);
        return sum;
    }
    private long merge(int[] A, int start, int end) {
        long sum = Long.valueOf(0);
        int mid = start + (end - start) / 2;
        int left = start;
        int right = mid + 1;
        int[] temp = new int[end - start + 1];
        int index = 0;
        while (left <= mid && right <= end) {
            if (A[left] <= A[right]) {
                temp[index++] = A[left++];
            } else {
                temp[index++] = A[right++];
                sum += Long.valueOf(mid - left + 1);
            }
        }
        while (left <= mid) {
            temp[index++] = A[left++];
        }
        while (right <= end) {
            temp[index++] = A[right++];
        }
        index = 0;
        for (int i = start; i <= end; i++) {
            A[i] = temp[index++];
        }
        return sum;
    }
}