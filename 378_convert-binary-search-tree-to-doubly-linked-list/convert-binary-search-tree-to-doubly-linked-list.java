/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/convert-binary-search-tree-to-doubly-linked-list
@Language: Java
@Datetime: 16-07-03 08:14
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
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {  
        // Write your code here
        if (root == null) {
            return null;
        }
        ArrayList<Integer> res = inorderTraversal(root);
        DoublyListNode head = new DoublyListNode(res.get(0));
        DoublyListNode tmp = head;
        ListIterator<Integer> iter = res.listIterator();
        iter.next();
        while (iter.hasNext()) {
            DoublyListNode newNode = new DoublyListNode(iter.next());
            tmp.next = newNode;
            newNode.prev = tmp;
            tmp = tmp.next;
        }
        return head;
    }
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        helper(root, res);
        return res;
    }
    public void helper(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
        return;
    }
}
