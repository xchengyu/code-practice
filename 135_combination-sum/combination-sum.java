/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/combination-sum
@Language: Java
@Datetime: 17-05-15 09:27
*/

public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (target <= 0 || candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        dfs(candidates, 0, 0, target, new ArrayList<Integer>(), result);
        return result;
    }
    
    private void dfs(int[] candidates, int index, int sum, int target, List<Integer> ans, List<List<Integer>> result) {
        if (target < sum) {
            return;
        }
        if (target == sum) {
            result.add(new ArrayList<Integer>(ans));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i != 0 && candidates[i] == candidates[i - 1]) {
                continue;
            } else {
                ans.add(candidates[i]);
                dfs(candidates, i, sum + candidates[i], target, ans, result);
                ans.remove(ans.size() - 1);
            }
        }
        return;
    }
}