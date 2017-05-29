/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/combination-sum-ii
@Language: Java
@Datetime: 16-12-31 11:02
*/

public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    // public List<List<Integer>> combinationSum2(int[] num, int target) {
    //     // write your code here
    //     List<List<Integer>> res = new ArrayList<List<Integer>>();
    //     if (num == null || num.length == 0) {
    //         return res;
    //     }
    //     Arrays.sort(num);
    //     helper(0, num, 0, target, new ArrayList<Integer>(), res);
    //     return res;
    // }
    // public void helper(int start, int[] num, int sum, int target, List<Integer> ans, List<List<Integer>> res) {
    //     if (sum == target) {
    //         res.add(new ArrayList<Integer>(ans));
    //         return;
    //     }
    //     if (sum > target) {
    //         return;
    //     }
    //     if (start >= num.length) {
    //         return;
    //     }
    //     for (int i = start; i < num.length; i++) {
    //         if (i != start && num[i] == num[i - 1]) {
    //             continue;
    //         } else {
    //             ans.add(num[i]);
    //             helper(i + 1, num, sum + num[i], target, ans, res);
    //             ans.remove(ans.size() - 1);
    //         }
    //     }
    //     return;
    // }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        helper(0, candidates, target, new ArrayList<Integer>(), res);
        return res;
    }
    private void helper(int start, int[] values, int target, List<Integer> tmp, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
        for (int i = start; i < values.length; i++) {
            if (i == start || values[i] != values[i - 1]) {
                if (values[i] <= target) {
                    tmp.add(values[i]);
                    helper(i + 1, values, target - values[i], tmp, res);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
        return;
    }
}