/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/wood-cut
@Language: Java
@Datetime: 16-12-26 07:21
*/

public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if (L == null || L.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < L.length; i++) {
            max = Math.max(max, L[i]);
        }
        int left = 1;
        int right = max;
        max = 0;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (canCut(L, mid, k)) {
                max = Math.max(mid, max);
                left = mid;
            } else {
                right = mid;
            }
        }
        if (canCut(L, right, k)) {
            max = Math.max(max, right);
        } else if (canCut(L, left, k)) {
            max = Math.max(max, left);
        }
        return max;
    }
    
    private boolean canCut(int[] L, int len, int k) {
        int sum = 0;
        for (int i = 0; i < L.length; i++) {
            sum += L[i] / len;
        }
        return sum >= k;
    }
}
// public class Solution {
//     /** 
//      *@param L: Given n pieces of wood with length L[i]
//      *@param k: An integer
//      *return: The maximum length of the small pieces.
//      */
//     public int woodCut(int[] L, int k) {
//         // write your code here
//         int max = 0;
//         for (int i = 0; i < L.length; i++) {
//             max = Math.max(max, L[i]);
//         }
//         // find the largest length that can cut more than k pieces of wood.
//         int start = 1;
//         int end = max;
//         while (start + 1 < end) {
//             int mid = start + (end - start) / 2;
//             if (count(L, mid) >= k) {
//                 start = mid;
//             } else {
//                 end = mid;
//             }
//         }
//         if (count(L, end) >= k) {
//             return end;
//         }
//         if (count(L, start) >= k) {
//             return start;
//         }
//         return 0;
//     }
//     private int count(int[] L, int length) {
//         int sum = 0;
//         for (int i = 0; i < L.length; i++) {
//             sum += L[i] / length;
//         }
//         return sum;
//     }
// }