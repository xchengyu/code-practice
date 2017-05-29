/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/binary-tree-path-sum-ii
@Language: Java
@Datetime: 17-01-22 08:32
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
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        // Write your code here
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<Integer> buffer = new ArrayList<Integer>();
        if (root == null) {
            return results;
        }
        findSum(root, target, buffer, results);
        return results;
    }
    public void findSum(TreeNode root, int sum, List<Integer> buffer, List<List<Integer>> results) {
        if (root == null) {
            return;
        }
        buffer.add(root.val);
        int tmp = sum;
        int level = buffer.size();
        for (int i = level - 1; i >= 0; i--) {
            tmp -= buffer.get(i);
            if (tmp == 0) {
                List<Integer> temp = new ArrayList<Integer>();
                for (int j = i; j <= level - 1; j++) {
                    temp.add(buffer.get(j));
                }
                results.add(temp);
            }
        }
        findSum(root.left, sum, buffer, results);
        findSum(root.right, sum, buffer, results);
        buffer.remove(level - 1);
    }
}