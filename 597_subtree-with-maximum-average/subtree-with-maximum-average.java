/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/subtree-with-maximum-average
@Language: Java
@Datetime: 17-01-21 00:58
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
    public int sum, size;
    public ResultType(int sum, int size) {
        this.sum = sum;
        this.size = size;
    }
}
public class Solution {
    /**
     * @param root the root of binary tree
     * @return the root of the maximum average of subtree
     */
    TreeNode subTree = null;
    ResultType subTreeResult = null;
    public TreeNode findSubtree2(TreeNode root) {
        // Write your code here
        helper(root);
        return subTree;
    }
    public ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        ResultType result = new ResultType(left.sum + right.sum + root.val, left.size + right.size + 1);
        if (subTree == null || subTreeResult.sum * result.size < result.sum * subTreeResult.size) {
            subTree = root;
            subTreeResult = result;
        }
        return result;
    }
}