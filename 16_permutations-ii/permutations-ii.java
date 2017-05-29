/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/permutations-ii
@Language: Java
@Datetime: 17-01-01 10:01
*/

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        helper(nums, visited, new ArrayList<Integer>(), res);
        return res;
    }
    private void helper(int[] nums, boolean[] visited, List<Integer> path, List<List<Integer>> res) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i != 0 && !visited[i - 1] && nums[i - 1] == nums[i])) {
                continue;
            } else {
                visited[i] = true;
                path.add(nums[i]);
                helper(nums, visited, path, res);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
        return;
    }
}


