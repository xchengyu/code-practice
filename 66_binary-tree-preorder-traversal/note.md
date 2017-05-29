```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/binary-tree-preorder-traversal
@Language: Markdown
@Datetime: 16-12-30 01:42
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
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        helper(root, res);
        return res;
    }
    private void helper(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
        return;
    }
}