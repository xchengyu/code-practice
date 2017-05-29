/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/n-queens
@Language: Java
@Datetime: 17-02-01 08:33
*/

class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if (n < 1) {
            return res;
        }
        List<List<Integer>> sol = new ArrayList<List<Integer>>();
        helper(n, new ArrayList<Integer>(), sol);
        draw(sol, res);
        return res;
    }
    
    public void helper(int n, List<Integer> path, List<List<Integer>> sol) {
        if (path.size() == n) {
            sol.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(path, i)) {
                path.add(i);
                helper(n, path, sol);
                path.remove(path.size() - 1);
            }
        }
        return;
    }
    public boolean isValid(List<Integer> path, int col) {
        int row = path.size();
        for (int i = 0; i < path.size(); i++) {
            int tmp_col = path.get(i);
            if (tmp_col == col) {
                return false;
            } else if (tmp_col + i == col + row) {
                return false;
            } else if (tmp_col - i == col - row) {
                return false;
            } else {
                continue;
            }
        }
        return true;
    }
    
    public void draw(List<List<Integer>> sol, ArrayList<ArrayList<String>> res) {
        for (List<Integer> list : sol) {
            ArrayList<String> lines = new ArrayList<String>();
            for (int i = 0; i < list.size(); i++) {
                int col = list.get(i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < list.size(); j++) {
                    if (j == col) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                lines.add(sb.toString());
            }
            res.add(lines);
        }
        return;
    }
};