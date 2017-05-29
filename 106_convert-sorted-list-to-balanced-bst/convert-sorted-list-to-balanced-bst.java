/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/convert-sorted-list-to-balanced-bst
@Language: Java
@Datetime: 16-12-29 07:31
*/

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
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
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {  
        // write your code here
        // if (head == null) {
        //     return null;
        // }
        // if (head.next == null) {
        //     return new TreeNode(head.val);
        // }
        // ListNode front = new ListNode(0);
        // front.next = head;
        // ListNode fast = front;
        // ListNode slow = front;
        // ListNode pre = slow;
        // while (fast != null && fast.next != null) {
        //     pre = slow;
        //     fast = fast.next.next;
        //     slow = slow.next;
        // }
        // pre.next = null;
        // TreeNode left = sortedListToBST(front.next);
        // TreeNode right = sortedListToBST(slow.next);
        // front.next = null;
        // slow.next = null;
        // TreeNode mid = new TreeNode(slow.val);
        // mid.left = left;
        // mid.right = right;
        // return mid;
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        TreeNode left = sortedListToBST(dummy.next);
        TreeNode right = sortedListToBST(mid.next);
        TreeNode midNode = new TreeNode(mid.val);
        midNode.left = left;
        midNode.right = right;
        return midNode;
    }
}
