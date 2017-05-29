/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/construct-binary-tree-from-preorder-and-inorder-traversal
@Language: Java
@Datetime: 17-01-28 08:15
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
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        if (preorder.length != inorder.length) {
            return null;
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    public TreeNode helper(int[] preorder, int pre_start, int pre_end, int[] inorder, int in_start, int in_end) {
        if (in_start > in_end) {
            return null;
        }
        int index = find(inorder, in_start, in_end, preorder[pre_start]);
        TreeNode root = new TreeNode(preorder[pre_start]);
        TreeNode left = helper(preorder, pre_start + 1, pre_start + index - in_start, inorder, in_start, index - 1);
        TreeNode right = helper(preorder, pre_start + index - in_start + 1, pre_end, inorder, index + 1, in_end);
        root.left = left;
        root.right = right;
        return root;
    }
    public int find(int[] inorder, int in_start, int in_end, int target) {
        int res = in_start;
        for (; res <= in_end; res++) {
            if (inorder[res] == target) {
                break;
            }
        }
        return res;
    }
}