/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/binary-tree-maximum-node
@Language: Java
@Datetime: 17-03-03 08:15
*/

public class Solution {
    /**
     * @param root the root of binary tree
     * @return the max ndoe
     */
    public TreeNode maxNode(TreeNode root) {
        // Write your code here
        if (root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode maxNode = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
                if (maxNode == null) {
                    maxNode = curNode;
                } else if (maxNode.val < curNode.val){
                    maxNode = curNode;
                } else {
                    continue;
                }
            }
        }
        return maxNode;
    }
}