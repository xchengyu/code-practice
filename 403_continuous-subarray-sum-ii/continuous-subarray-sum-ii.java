/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/continuous-subarray-sum-ii
@Language: Java
@Datetime: 17-01-17 08:50
*/

public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySumII(int[] A) {
        // Write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(0);
        res.add(0);
        if (A == null || A.length == 0) {
            return res;
        }
        boolean findNegative = false;
        boolean findPositive = false;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int index = 0;
        int[] negativeA = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            negativeA[i] = -A[i];
            if (A[i] < 0) {
                findNegative = true;
            }
            if (A[i] > 0) {
                findPositive = true;
            }
            if (A[i] > max) {
                max = A[i];
                index = i;
            }
        }
        if (!findNegative) {
            res.set(0, 0);
            res.set(1, A.length - 1);
            return res;
        }
        if (!findPositive) {
            res.set(0, index);
            res.set(1, index);
            return res;
        }
        ArrayList<Integer> no_circular_max = continuousSubarraySumI(A);
        ArrayList<Integer> no_circular_min = continuousSubarraySumI(negativeA);
        if (no_circular_max.get(2) >= sum + no_circular_min.get(2)) {
            res.set(0, no_circular_max.get(0));
            res.set(1, no_circular_max.get(1));
        } else {
            int first = no_circular_min.get(1) + 1;
            int last = no_circular_min.get(0) - 1;
            res.set(0, first);
            res.set(1, last);
        }
        return res;
    }
    public ArrayList<Integer> continuousSubarraySumI(int[] nums) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(0);
        res.add(0);
        res.add(0);
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int first = 0;
        int last = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = 0;
                first = i;
                last = i;
            }
            sum += nums[i];
            last = i;
            if (sum > max) {
                max = Math.max(max, sum);
                res.set(0, first);
                res.set(1, last);
                res.set(2, max);
            }
        }
        return res;
    }
}