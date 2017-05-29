/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/permutation-index-ii
@Language: Java
@Datetime: 16-08-21 06:56
*/

public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long factor(int value) {
        long res = 1;
        for (int i = 1; i <= value; i++) {
            res *= i;
        }
        return res;
    }
    
    public long generateNum(Map<Integer, Integer> map) {
        long denominator = 1;
        int sum = 0;
        for (Integer value : map.values()) {
            denominator *= factor(value);
            sum += value;
        }
        if (sum == 0) {
            return 0;
        }
        return factor(sum) / denominator;
    }
    public long permutationIndexII(int[] A) {
        // Write your code here
        Map<Integer, Integer> times = new HashMap<Integer, Integer>();
        for (int elem : A) {
            if (times.containsKey(elem)) {
                times.put(elem, times.get(elem) + 1);
            } else {
                times.put(elem, 1);
            }
        }
        long ans = 0;
        for (int i = 0; i < A.length; i++) {
            Set<Integer> flag = new HashSet<Integer>();
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[i] && !flag.contains(A[j])) {
                    flag.add(A[j]);
                    times.put(A[j], times.get(A[j]) - 1);
                    ans += generateNum(times);
                    times.put(A[j], times.get(A[j]) + 1);
                }
            }
            times.put(A[i], times.get(A[i]) - 1);
        }
        return ans + 1;
    }
}