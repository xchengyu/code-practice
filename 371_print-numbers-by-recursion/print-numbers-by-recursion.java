/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/print-numbers-by-recursion
@Language: Java
@Datetime: 16-07-31 10:01
*/

public class Solution {
    /**
     * @param n: An integer.
     * return : An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {
        // write your code here
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);
        helper(10, 1, n, res);
        res.remove(0);
        return res;
    }
    public void helper(int base, int len, int n, List<Integer> res) {
        if (len > n) {
            return;
        }
        int size = res.size();
        int carry = base / 10;
        for (int i = carry; i < 10 * carry; i += carry) {
            for (int j = 0; j < size; j++) {
                res.add(res.get(j) + i);
            }
        }
        helper(base * 10, len + 1, n, res);
        return;
    }
}