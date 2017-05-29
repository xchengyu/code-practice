/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/continuous-subarray-sum
@Language: Java
@Datetime: 17-05-26 10:12
*/

public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        // Write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (A == null || A.length < 1) {
            return result;
        }
        int start = 0;
        int end = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        result.add(0);
        result.add(0);
        //int cur = 0;
        for (int i = 0; i < A.length; i++) {
            if (sum < 0) {
                start = i;
                end = i;
                sum = A[i];
            } else {
                sum += A[i];
                end = i;
            }
            if (sum > max) {
                max = sum;
                result.set(0, start);
                result.set(1, end);
            }
        }
        return result;
    }
}