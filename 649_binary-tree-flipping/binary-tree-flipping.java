/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/binary-tree-flipping
@Language: Java
@Datetime: 17-05-12 10:22
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
     * @param root the root of binary tree
     * @return the new root
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        // Write your code here
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode new_root = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.right = null;
        root.left = null;
        return new_root;
    }
    
}