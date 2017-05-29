/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/first-missing-positive
@Language: Java
@Datetime: 17-01-18 07:13
*/

public class Solution {
    /**    
     * @param A: an array of integers
     * @return: an integer
     */
    public int firstMissingPositive(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 1;
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] == i + 1 || A[i] <= 0 || A[i] >= A.length + 1) {
                continue;
            } else {
                int index = A[i] - 1;
                if (A[index] == index + 1) {
                    A[i] = -1;
                    continue;
                } else {
                    swap(A, i , index);
                    i--;
                }
            }
        }
        int ans = A.length + 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                ans = i + 1;
                break;
            }
        }
        return ans;
    }
    
    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}