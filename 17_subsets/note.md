```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/subsets
@Language: Markdown
@Datetime: 17-02-02 02:25
```

class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (nums == null) {
            return res;
        }
        if (nums.length == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }
    public void helper(int[] nums, int index, ArrayList<Integer> ans, ArrayList<ArrayList<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<Integer>(ans));
            return;
        }
        helper(nums, index + 1, ans, res);
        ans.add(nums[index]);
        helper(nums, index + 1, ans, res);
        ans.remove(ans.size() - 1);
        return;
    }
}