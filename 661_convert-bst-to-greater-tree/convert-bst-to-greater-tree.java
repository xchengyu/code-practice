/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/convert-bst-to-greater-tree
@Language: Java
@Datetime: 17-05-12 10:55
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
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        // Write your code here
        if (root == null) {
            sum += 0;
            return root;
        }
        if (root.right != null) {
            convertBST(root.right);
        }
        root.val += sum;
        sum = root.val;
        convertBST(root.left);
        return root;
    }

}