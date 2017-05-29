/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/balanced-binary-tree
@Language: Java
@Datetime: 16-12-30 01:52
*/

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
    public ResultType(int maxDepth, boolean isBalanced) {
        this.maxDepth = maxDepth;
        this.isBalanced = isBalanced;
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
            return new ResultType(0, true);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        if (!left.isBalanced || !right.isBalanced) {
            return new ResultType(0, false);
        }
        if (Math.abs(left.maxDepth - right.maxDepth) > 1) {
            return new ResultType(0, false);
        }
        return new ResultType(Math.max(left.maxDepth, right.maxDepth) + 1, true);
    }
}