```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/inorder-successor-in-binary-search-tree
@Language: Markdown
@Datetime: 17-01-17 06:25
```

public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        TreeNode successor = null;
        while (root != null && root.val != p.val) {
            if (root.val > p.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        if (root == null) {
            return null;
        }
        if (root.right == null) {
            return successor;
        }
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}