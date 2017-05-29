```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/binary-tree-path-sum
@Language: Markdown
@Datetime: 17-01-11 09:04
```

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(root, 0, target, new ArrayList<Integer>(), res);
        return res;
    }
    public void helper(TreeNode root, int sum, int target, ArrayList<Integer> ans, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (sum + root.val == target) {
                ans.add(root.val);
                res.add(new ArrayList<Integer>(ans));
                ans.remove(ans.size() - 1);
                return;
            } else {
                return;
            }
        }
        sum += root.val;
        ans.add(root.val);
        if (root.left != null) {
            helper(root.left, sum, target, ans, res);
        }
        if (root.right != null) {
            helper(root.right, sum, target, ans, res);
        }
        sum -= root.val;
        ans.remove(ans.size() - 1);
        return;
    }
}