/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/symmetric-binary-tree
@Language: Java
@Datetime: 16-08-06 02:35
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
     * @param root, the root of binary tree.
     * @return true if it is a mirror of itself, or false.
     */
    public boolean isSymmetric(TreeNode root) {
        // Write your code here
        if (root == null) {
            return true;
        }
        return check(root.left, root.right);
    }
    public boolean check(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        return check(a.left, b.right) && check(a.right, b.left);
    }
    // public boolean isSymmetric(TreeNode root) {
    //     // Write your code here
    //     String res1 = "";
    //     String res2 = "";
    //     res1 = helper1(root, res1);
    //     res2 = helper2(root, res2);
    //     return res1.equals(res2);
    // }
    // private String helper1(TreeNode root, String res) {
    //     if (root == null) {
    //         res += "#";
    //         return res;
    //     }
    //     res += root.val + "";
    //     res = helper1(root.left, res);
    //     res = helper1(root.right, res);
    //     return res;
    // }
    // private String helper2(TreeNode root, String res) {
    //     if (root == null) {
    //         res += "#";
    //         return res;
    //     }
    //     res += root.val + "";
    //     res = helper2(root.right, res);
    //     res = helper2(root.left, res);
    //     return res;
    // }
}