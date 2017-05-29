```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/binary-tree-paths
@Language: Markdown
@Datetime: 17-01-11 09:13
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
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        List<String> res = new ArrayList<String>();
        if (root == null) {
            return res;
        }
        helper(root, "", res);
        return res;
    }
    public void helper(TreeNode root, String path, List<String> res) {
        if (root.left == null && root.right == null) {
            path += root.val + "";
            res.add(new String(path));
            path = path.substring(0, path.length() - 1);
            return;
        }
        path += root.val + "->";
        if (root.left != null) {
            helper(root.left, path, res);
        }
        if (root.right != null) {
            helper(root.right, path, res);
        }
        path = path.substring(0, path.length() - 3);
        return;
    }
}