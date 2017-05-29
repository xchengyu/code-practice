/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/maximum-subtree
@Language: Java
@Datetime: 17-02-24 02:48
*/

public class Solution {
    /**
     * @param root the root of binary tree
     * @return the maximum weight node
     */
    private int maxSum = Integer.MIN_VALUE;
    private TreeNode maxNode = null;
    public TreeNode findSubtree(TreeNode root) {
        // Write your code here
        sum(root);
        return maxNode;
    }
    
    public int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        int result = root.val + leftSum + rightSum;
        if (result > maxSum || (result == maxSum && maxNode == null)) {
            maxSum = result;
            maxNode = root;
        }
        return result;
    }
}