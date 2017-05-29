/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/binary-tree-maximum-path-sum
@Language: Java
@Datetime: 17-01-27 08:31
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
    public long singleMax;
    public long max;
    public ResultType(long singleMax, long max) {
        this.singleMax = singleMax;
        this.max = max;
    }
}
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxPathSum(TreeNode root) {
        // write your code here
        return (int)helper(root).max;
    }
    public ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        ResultType result = new ResultType(0, 0);
        result.singleMax = Math.max(root.val, Math.max(root.val + left.singleMax, root.val + right.singleMax));
        result.max = Math.max(Math.max(left.max, right.max), Math.max(0, left.singleMax) + Math.max(0, right.singleMax) + root.val);
        return result;
    }
}