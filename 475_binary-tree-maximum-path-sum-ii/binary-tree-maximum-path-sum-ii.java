/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/binary-tree-maximum-path-sum-ii
@Language: Java
@Datetime: 16-06-28 04:18
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
     * @param root the root of binary tree.
     * @return an integer
     */
    public int maxPathSum2(TreeNode root) {
        // Write your code here
        if (root == null) {
            return 0;
        }
        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);
        return root.val + Math.max(0, Math.max(left, right));
    }
}