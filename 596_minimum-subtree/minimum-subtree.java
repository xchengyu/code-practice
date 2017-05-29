/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/minimum-subtree
@Language: Java
@Datetime: 17-01-21 00:50
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
    public int sum;
    public TreeNode minRoot;
    public int min_sum;
    public ResultType(int sum, TreeNode minRoot, int min_sum) {
        this.sum = sum;
        this.minRoot = minRoot;
        this.min_sum = min_sum;
    }
}
public class Solution {
    /**
     * @param root the root of binary tree
     * @return the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        // Write your code here
        if (root == null) {
            return root;
        }
        return helper(root).minRoot;
    }
    public ResultType helper(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new ResultType(root.val, root, root.val);
        }
        if (root.left == null) {
            ResultType right = helper(root.right);
            int sum = right.sum + root.val;
            if (sum < right.min_sum) {
                return new ResultType(sum, root, sum);
            } else {
                return new ResultType(sum, right.minRoot, right.min_sum);
            }
        }
        if (root.right == null) {
            ResultType left = helper(root.left);
            int sum = left.sum + root.val;
            if (sum < left.min_sum) {
                return new ResultType(sum, root, sum);
            } else {
                return new ResultType(sum, left.minRoot, left.min_sum);
            }
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        int sum = left.sum + root.val + right.sum;
        if (sum <= left.min_sum && sum <= right.min_sum) {
            return new ResultType(sum, root, sum);
        } else if (left.min_sum <= sum && left.min_sum <= right.min_sum) {
            return new ResultType(sum, left.minRoot, left.min_sum);
        } else if (right.min_sum <= sum && right.min_sum <= left.min_sum){
            return new ResultType(sum, right.minRoot, right.min_sum);
        }
        return null;
    }
}