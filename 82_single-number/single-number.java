/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/single-number
@Language: Java
@Datetime: 16-07-22 06:23
*/

public class Solution {
    /**
      *@param A : an integer array
      *return : a integer 
      */
    public int singleNumber(int[] A) {
        // Write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            res ^= A[i];
        }
        return res;
    }
}