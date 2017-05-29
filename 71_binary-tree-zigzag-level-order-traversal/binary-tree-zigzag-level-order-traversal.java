/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/binary-tree-zigzag-level-order-traversal
@Language: Java
@Datetime: 16-12-30 02:04
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
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean change = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<Integer>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur != null) {
                    store(cur, level, change);
                    expand(cur, queue);
                } else {
                    continue;
                }
            }
            change = !change;
            result.add(level);
        }
        return result;
    }
    
    private void store(TreeNode cur, ArrayList<Integer> result, boolean change) {
        if (!change) {
            result.add(cur.val);
        } else {
            result.add(0, cur.val);
        }
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