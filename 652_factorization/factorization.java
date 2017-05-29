/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/factorization
@Language: Java
@Datetime: 17-05-19 07:58
*/

public class Solution {
    /**
     * @param n an integer
     * @return a list of combination
     */
    public List<List<Integer>> getFactors(int n) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(result, new ArrayList<Integer>(), n, 2);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, List<Integer> path, int num, int start) {
        if (num <= 1) {
            if (path.size() > 1) {
                result.add(new ArrayList<Integer>(path));
            }
            return;
        }
        //for (int i = start; i * i <= num; i++) {//i * i may overflow
        for (int i = start; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                path.add(i);
                dfs(result, path, num / i, i);
                path.remove(path.size() - 1);
            }
        }
        if (num >= start) {
            path.add(num);
            dfs(result, path, 1, num);
            path.remove(path.size() - 1);
        }
        return;
    }
}