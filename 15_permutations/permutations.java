/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/permutations
@Language: Java
@Datetime: 16-08-07 07:18
*/

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    // public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
    //     // write your code here
    //     ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    //     if (nums == null || nums.size() == 0){
    //         return res;
    //     }
    //     helper(nums, new ArrayList(), res);
    //     return res;
    // }
    // public void helper(ArrayList<Integer> nums, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res) {
    //     if (list.size() == nums.size()) {
    //         res.add(new ArrayList<Integer>(list));
    //         return;
    //     }
    //     for (int i = 0; i < nums.size(); i++) {
    //         if (list.contains(nums.get(i))) {
    //             continue;
    //         }
    //         list.add(nums.get(i));
    //         helper(nums, list, res);
    //         list.remove(list.size() - 1);
    //     }
    //     return;
    // }
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.size() == 0) {
            return res;
        }
        helper(nums, new ArrayList<Integer>(), res);
        return res;
    }
    public void helper(List<Integer> nums, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> res) {
        if (ans.size() == nums.size()) {
            res.add(new ArrayList<Integer>(ans));
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (ans.contains(nums.get(i))) {
                continue;
            } else {
                ans.add(nums.get(i));
                helper(nums, ans, res);
                ans.remove(ans.size() - 1);
            }
        }
        return;
    }
}
