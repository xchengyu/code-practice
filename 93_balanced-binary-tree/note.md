```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/balanced-binary-tree
@Language: Markdown
@Datetime: 16-12-30 01:52
```

//Normal version (not good enough)
public class Solution {
/**
* @param root: The root of binary tree.
* @return: True if this Binary tree is Balanced, or false.
*/
public boolean isBalanced(TreeNode root) {
// write your code here
return maxDepth(root) != -1;
}
public int maxDepth(TreeNode root) {
// write your code here
if (root == null) {
return 0;
}
int left = maxDepth(root.left);
int right = maxDepth(root.right);
if (left == -1 || right == -1 || Math.abs(left - right) &gt; 1) {
return -1;
}
return Math.max(left, right) + 1;
}
}
//reference version
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
class ResultType {
    public boolean isBalanced;
    public int maxDepth;
    public ResultType(boolean isBalanced, int maxDepth) {
        this.isBalanced = isBalanced;
        this.maxDepth = maxDepth;
    }
}
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        return helper(root).isBalanced;
    }
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(true, 0);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        // subtree not balance
        if (!left.isBalanced || !right.isBalanced) {
            return new ResultType(false, -1);
        }
        // root not balance
        if (Math.abs(left.maxDepth - right.maxDepth) > 1) {
            return new ResultType(false, -1);
        }
        return new ResultType(true, Math.max(left.maxDepth, right.maxDepth) + 1);
    }
}