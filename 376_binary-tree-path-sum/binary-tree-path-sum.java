/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/binary-tree-path-sum
@Language: Java
@Datetime: 17-01-11 09:04
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
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        helper(root, 0, target, new ArrayList<Integer>(), res);
        return res;
    }
    private void helper(TreeNode root, int sum, int target, List<Integer> path, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (root != null && root.val + sum == target) {
            if (root.left == null && root.right == null) {
                path.add(root.val);
                res.add(new ArrayList<Integer>(path));
                path.remove(path.size() - 1);
                return;
            }
        }
        path.add(root.val);
        if (root.left != null) {
            helper(root.left, sum + root.val, target, path, res);
        }
        if (root.right != null) {
            helper(root.right, sum + root.val, target, path, res);
        }
        path.remove(path.size() - 1);
        return;
    }
}