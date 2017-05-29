/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/complete-binary-tree
@Language: Java
@Datetime: 17-01-11 11:46
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
    boolean isComplete;
    boolean isFull;
    int depth;
    public ResultType(int depth, boolean isComplete, boolean isFull) {
        this.depth = depth;
        this.isComplete = isComplete;
        this.isFull = isFull;
    }
}
public class Solution {
    /**
     * @param root, the root of binary tree.
     * @return true if it is a complete binary tree, or false.
     */
    public boolean isComplete(TreeNode root) {
        // Write your code here
        return helper(root).isComplete;
    }
    public ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, true, true);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        if (!left.isComplete) {
            return new ResultType(-1, false, false);
        }
        if (left.depth == right.depth) {
            if (!left.isFull || !right.isComplete) {
                return new ResultType(-1, false, false);
            }
            return new ResultType(left.depth + 1, true, right.isFull);
        }
        if (left.depth == right.depth + 1) {
            if (!left.isComplete || !right.isFull) {
                return new ResultType(-1, false, false);
            }
            return new ResultType(left.depth + 1, true, false);
        }
        return new ResultType(-1, false, false);
    }
}