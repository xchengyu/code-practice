/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/jump-game-ii
@Language: Java
@Datetime: 17-01-25 08:31
*/

public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    // public int jump(int[] A) {
    //     // write your code here
    //     //dp O(n ^ 2)
    //     if (A == null || A.length == 0) {
    //         return 0;
    //     }
    //     int[] steps = new int[A.length];
    //     for (int i = 1; i < steps.length; i++) {
    //         steps[i] = Integer.MAX_VALUE;
    //     }
    //     steps[0] = 0;
    //     for (int i = 1; i < A.length; i++) {
    //         for (int j = i; j >= 0; j--) {
    //             if (steps[j] != Integer.MAX_VALUE && j + A[j] >= i) {
    //                 steps[i] = Math.min(steps[j] + 1, steps[i]);
    //             }
    //         }
    //     }
    //     return steps[A.length - 1];
    // }
    public int jump(int[] A) {
        // greedy   O(n)
        // if (A == null || A.length <= 1) {
        //     return 0;
        // }
        // int start = 0;
        // int end = 0;
        // int max = 0;
        // int count = 0;
        // while (end < A.length) {
        //     max = 0;
        //     count++;
        //     for (int i = start; i <= end; i++) {
        //         if (A[i] + i >= A.length - 1) {
        //             return count;
        //         }
        //         max = Math.max(A[i] + i, max);
        //     }
        //     start = end + 1;
        //     end = max;
        // }
        // return count;
        if (A == null || A.length < 2) {
            return 0;
        }
        int start = 0;
        int end = 0;
        int count = 0;
        int max = 0;
        while (end < A.length) {
            count++;
            for (int i = start; i <= end; i++) {
                if (A[i] + i >= A.length - 1) {
                    return count;
                }
                max = Math.max(A[i] + i, max);
            }
            start = end + 1;
            end = max;
        }
        return count;
    }
}
