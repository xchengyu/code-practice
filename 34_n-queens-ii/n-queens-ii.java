/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/n-queens-ii
@Language: Java
@Datetime: 16-07-08 00:32
*/

class Solution {
    /**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public static int sum = 0;
    public int totalNQueens(int n) {
        //write your code here
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if (n <= 0) {
            return sum;
        }
        helper(n, new ArrayList<Integer>());
        return sum;
    }
    public void helper(int n, ArrayList<Integer> ans) {
        if (ans.size() == n) {
            sum++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (!isValid(col, ans)) {
                continue;
            } else {
                ans.add(col);
                helper(n, ans);
                ans.remove(ans.size() - 1);
            }
        }
        return;
    }
    public boolean isValid(int col, ArrayList<Integer> ans) {
        int row = ans.size();
        for(int i = 0; i < row; i++) {
            if (ans.get(i) == col) {
                return false;
            }
            if (row - i == Math.abs(col - ans.get(i))) {
                return false;
            }
        }
        return true;
    }
};

