/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/reorder-list
@Language: Java
@Datetime: 16-12-29 09:22
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
 */ 
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {  
        // write your code here
        if (head == null || head.next == null) {
            return;
        }
        ListNode dummy = new ListNode(-1);
        ListNode front = dummy;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode first = head;
        ListNode secondTmp = slow.next;
        slow.next = null;
        ListNode second = reverseList(secondTmp);
        while (first != null && second != null) {
            dummy.next = first;
            first = first.next;
            dummy = dummy.next;
            dummy.next = second;
            second = second.next;
            dummy = dummy.next;
        }
        while (first != null) {
            dummy.next = first;
            first = first.next;
            dummy = dummy.next;
        }
        head = front.next;
        return;
    }
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode front = head;
        ListNode cur = head.next;
        while (cur != null) {
            head.next = cur.next;
            dummy.next = cur;
            cur.next = front;
            front = cur;
            cur = head.next;
        }
        return dummy.next;
    }
}
