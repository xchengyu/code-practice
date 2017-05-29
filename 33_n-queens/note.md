```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/n-queens
@Language: Markdown
@Datetime: 17-02-01 08:33
```

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
        if (n <= 0) {
            return res;
        }
        helper(n, new ArrayList<Integer>(), res);
        return res;
    }
    private void helper(int n, List<Integer> path, ArrayList<ArrayList<String>> res) {
        if (path.size() == n) {
            res.add(drawChessBoard(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!isValid(i, path)) {
                continue;
            } else {
                path.add(i);
                helper(n, path, res);
                path.remove(path.size() - 1);
            }
        }
        return;
    }
    private boolean isValid(int pos, List<Integer> path) {
        int row = path.size();
        for (int i = 0; i < path.size(); i++) {
            if (path.get(i) == pos) {
                return false;
            }
            if (row + pos == i + path.get(i)) {
                return false;
            }
            if (row - pos == i - path.get(i)) {
                return false;
            }
        }
        return true;
    }
    private ArrayList<String> drawChessBoard(List<Integer> path) {
        ArrayList<String> res = new ArrayList<String>();
        for (int i = 0; i < path.size(); i++) {
            int col = path.get(i);
            String line = "";
            for (int j = 0; j < path.size(); j++) {
                if (j == col) {
                    line += "Q";
                } else {
                    line += ".";
                }
            }
            res.add(line);
        }
        return res;
    }
    
};