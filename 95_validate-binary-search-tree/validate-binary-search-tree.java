/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/validate-binary-search-tree
@Language: Java
@Datetime: 17-01-27 07:55
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
    public int min;
    public int max;
    public boolean isValid;
    public ResultType(int min, int max, boolean isValid) {
        this.min = min;
        this.max = max;
        this.isValid = isValid;
    }
}
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        return helper(root).isValid;
    }
    public ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        if (!left.isValid || !right.isValid) {
            return new ResultType(-1, -1, false);
        }
        if ((root.left != null && left.max >= root.val) || (root.right != null && right.min <= root.val)) {
            return new ResultType(-1, -1, false);
        }
        return new ResultType(Math.min(left.min, root.val), Math.max(right.max, root.val), true);
    }
}