```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/combination-sum
@Language: Markdown
@Datetime: 17-05-15 09:27
```

public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (candidates == null) {
            return result;
        }
        ArrayList<Integer> path = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(candidates, target, path, 0, result);
        return result;
    }
    public void helper(int[] candidates, int target, ArrayList<Integer> path, int index,
        List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (i != 0 && candidates[i - 1] == candidates[i]) {
                continue;
            }
            path.add(candidates[i]);
            helper(candidates, target - candidates[i], path, i, result);
            path.remove(path.size() - 1);
        }
    }