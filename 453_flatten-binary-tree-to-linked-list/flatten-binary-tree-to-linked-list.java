/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/flatten-binary-tree-to-linked-list
@Language: Java
@Datetime: 16-08-06 05:42
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
public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }
        helper(root);
        return;
    }
    public TreeNode helper(TreeNode root) {//return the last node of chain
        if (root == null) {
            return root;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        if (root.left == null) {
            TreeNode right = helper(root.right);
            return right;
        }
        if (root.right == null) {
            TreeNode left = helper(root.left);
            root.right = root.left;
            root.left = null;
            return left;
        }
        TreeNode left = helper(root.left);
        TreeNode right = helper(root.right);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        left.right = tmp;
        return right;
    }
}