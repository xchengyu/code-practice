```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/permutations-ii
@Language: Markdown
@Datetime: 17-01-01 10:01
```

public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.size() == 0) {
            return res;
        }
        Collections.sort(nums);
        boolean[] visited = new boolean[nums.size()];
        Arrays.fill(visited, false);
        helper(nums, new ArrayList<Integer>(), res, visited);
        return res;
    }
    public void helper(ArrayList<Integer> nums, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res, boolean[] visited) {
        if (path.size() == nums.size()) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (visited[i] || (i != 0 && !visited[i - 1] && nums.get(i - 1) == nums.get(i))) {
                continue;
            } else {
                visited[i] = true;
                path.add(nums.get(i));
                helper(nums, path, res, visited);
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
        return;
    }