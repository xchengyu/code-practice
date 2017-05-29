/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/binary-tree-leaves-order-traversal
@Language: Java
@Datetime: 17-05-14 11:26
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
     * @return collect and remove all leaves
     */
    public List<List<Integer>> findLeaves(TreeNode root) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(root, result);
        return result;
    }
    
    private int dfs(TreeNode root, List<List<Integer>> result) {
        if (root == null) {
            return 0;
        }
        int level = Math.max(dfs(root.left, result), dfs(root.right, result)) + 1;
        int size = result.size();
        if (level > size) {
            result.add(new ArrayList<Integer>());
        }
        result.get(level - 1).add(root.val);
        return level;
    }
}