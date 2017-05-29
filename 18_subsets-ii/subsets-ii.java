/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/subsets-ii
@Language: Java
@Datetime: 17-02-07 11:21
*/

class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        helper(0, nums, new ArrayList<Integer>(), res);
        return res;
    }
    public void helper(int pos, int[] nums, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res) {
        res.add(new ArrayList<Integer>(path));
        for (int i = pos; i < nums.length; i++) {
            if (i != pos && nums[i] == nums[i - 1]) {
                continue;
            } else {
                path.add(nums[i]);
                helper(i + 1, nums, path, res);
                path.remove(path.size() - 1);
            }
        }
        return;
    }
}
