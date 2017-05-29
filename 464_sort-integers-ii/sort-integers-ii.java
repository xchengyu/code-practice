/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/sort-integers-ii
@Language: Java
@Datetime: 17-01-11 10:24
*/

public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    //quick sort
    public void sortIntegers2(int[] A) {
        // Write your code here
        if (A == null || A.length < 2) {
            return;
        }
        helper(A, 0, A.length - 1);
        return;
    }
    public void helper(int[] A, int start, int end) {
        // if (start >= end) {
        //     return;
        // }
        // int pivot = A[start + (end - start) / 2];
        // int left = start - 1;
        // int right = end + 1;
        // int index = start;
        // while (index < right) {
        //     if (A[index] < pivot) {
        //         left++;
        //         int tmp = A[left];
        //         A[left] = A[index];
        //         A[index] = tmp;
        //         index++;
        //     } else if (A[index] == pivot) {
        //         index++;
        //     } else {
        //         right--;
        //         int tmp = A[right];
        //         A[right] = A[index];
        //         A[index] = tmp;
        //     }
        // }
        // helper(A, start, left);
        // helper(A, right, end);
        // return;
        if (start >= end) {
            return;
        }
        int left = start - 1;
        int right = end + 1;
        int index = start;
        int pivot = A[start];
        while (index < right) {
            if (A[index] < pivot) {
                left++;
                swap(A, left, index);
                index++;
            } else if (A[index] == pivot) {
                index++;
            } else {
                right--;
                swap(A, right, index);
            }
        }
        helper(A, start, left);
        helper(A, right, end);
        return;
    }
    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    //////////////////////////////////////////
    //merge sort timeout
    // public void sortIntegers2(int[] A) {
    //     // Write your code here
    //     if (A == null || A.length < 2) {
    //         return;
    //     }
    //     helper(A, 0, A.length - 1);
    //     return;
        
    // }
    // public void helper(int[] A, int start, int end) {
    //     if (start >= end) {
    //         return;
    //     }
    //     int mid = start + (end - start) / 2;
    //     helper(A, start, mid);
    //     helper(A, mid + 1, end);
    //     int[] newArr = new int[A.length];
    //     for (int i = 0; i < A.length; i++) {
    //         newArr[i] = A[i];
    //     }
    //     int index1 = start;
    //     int index2 = mid + 1;
    //     int index = start;
    //     while (index1 <= mid && index2 <= end) {
    //         if (newArr[index1] <= newArr[index2]) {
    //             A[index] = newArr[index1];
    //             index++;
    //             index1++;
    //         } else {
    //             A[index] = newArr[index2];
    //             index++;
    //             index2++;
    //         }
    //     }
    //     while (index1 <= mid) {
    //         A[index] = newArr[index1];
    //         index++;
    //         index1++;
    //     }
    //     return;
    // }
    ///////////////////////////////////////////////////////////
    //heap sort
    // public void sortIntegers2(int[] A) {
    //     // Write your code here
    //     if (A == null || A.length < 2) {
    //         return;
    //     }
    //     Queue<Integer> queue = new PriorityQueue<Integer>();
    //     for (int num : A) {
    //         queue.add(num);
    //     }
    //     int index = 0;
    //     while (index < A.length && !queue.isEmpty()) {
    //         A[index++] = queue.poll();
    //     }
    //     return;
    // }
}