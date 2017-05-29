/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/gray-code
@Language: Java
@Datetime: 16-07-30 05:52
*/

public class Solution {
    /**
     * @param n a number
     * @return Gray code
     */
    public ArrayList<Integer> grayCode(int n) {
        // Write your code here
        ArrayList<Integer> results = new ArrayList<Integer>();
        results.add(0);
        if (n == 0) {
            return results;
        }
        helper(results, 0, n, 1);
        return results;
    }
    public void helper(ArrayList<Integer> results, int cur, int n, int base) {
        if (cur >= n) {
            return;
        }
        int size = results.size();
        for (int i = size - 1; i >= 0; i--) {
            int tmp = results.get(i);
            results.add(tmp + base);
        }
        helper(results, cur + 1, n, base << 1);
        return;
    }
}