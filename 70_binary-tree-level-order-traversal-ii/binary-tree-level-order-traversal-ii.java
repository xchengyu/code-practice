/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/binary-tree-level-order-traversal-ii
@Language: Java
@Datetime: 16-12-30 02:06
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
     * @param root: The root of binary tree.
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur != null) {
                    store(cur, level);
                    expand(cur, queue);
                } else {
                    continue;
                }
            }
            result.add(0, level);
        }
        return result;
    }
    private void store(TreeNode cur, ArrayList<Integer> result) {
        result.add(cur.val);
        return;
    }
    
    private void expand(TreeNode cur, Queue<TreeNode> queue) {
        if (cur.left != null) {
            queue.offer(cur.left);
        }
        if (cur.right != null) {
            queue.offer(cur.right);
        }
        return;
    }
}