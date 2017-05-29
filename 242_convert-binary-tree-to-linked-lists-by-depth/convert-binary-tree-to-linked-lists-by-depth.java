/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/convert-binary-tree-to-linked-lists-by-depth
@Language: Java
@Datetime: 17-02-07 11:13
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
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        // Write your code here
        List<ListNode> res = new ArrayList<ListNode>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        ListNode dummy = new ListNode(-1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode tail = dummy;
            for (int i = 0; i < size; i++) {
                TreeNode curTreeNode = queue.poll();
                ListNode newListNode = new ListNode(curTreeNode.val);
                tail.next = newListNode;
                tail = tail.next;
                if (curTreeNode.left != null) {
                    queue.offer(curTreeNode.left);
                }
                if (curTreeNode.right != null) {
                    queue.offer(curTreeNode.right);
                }
            }
            res.add(dummy.next);
            dummy.next = null;
        }
        return res;
    }
}