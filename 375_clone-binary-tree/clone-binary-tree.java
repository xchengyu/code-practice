/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/clone-binary-tree
@Language: Java
@Datetime: 16-08-22 01:44
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
     * @param root: The root of binary tree
     * @return root of new tree
     */
    public TreeNode cloneTree(TreeNode root) {
        // Write your code here
        if (root == null) {
            return null;
        }
        Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                map.put(cur, new TreeNode(cur.val));
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                TreeNode newNode = map.get(cur);
                if (cur.left != null) {
                    newNode.left = map.get(cur.left);
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    newNode.right = map.get(cur.right);
                    queue.offer(cur.right);
                }
            }
        }
        return map.get(root);
    }
}