/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/subsets
@Language: Java
@Datetime: 17-02-02 02:25
*/

class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        helper(0, nums, new ArrayList<Integer>(), res);
        return res;
    }
    public void helper(int start, int[] nums, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res) {
        if (start == nums.length) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        helper(start + 1, nums, path, res);
        path.add(nums[start]);
        helper(start + 1, nums, path, res);
        path.remove(path.size() - 1);
        return;
    }
}