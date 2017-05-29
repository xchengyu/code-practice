/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/swap-two-nodes-in-linked-list
@Language: Java
@Datetime: 17-01-15 07:44
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @oaram v1 an integer
     * @param v2 an integer
     * @return a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // Write your code here
        if (head == null || head.next == null || v1 == v2) {
            return head;
        }
        ListNode prev1 = null;
        ListNode prev2 = null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur != null && cur.next != null) {
            if (cur.next.val == v1) {
                prev1 = cur;
            }
            if (cur.next.val == v2) {
                prev2 = cur;
            }
            cur = cur.next;
        }
        if (prev1 == null || prev2 == null) {
            return head;
        }
        if (prev1.next == prev2) {
            ListNode afterv2 = prev2.next.next;
            prev1.next = prev2.next;
            prev1.next.next = prev2;
            prev2.next = afterv2;
            return dummy.next;
        }
        if (prev2.next == prev1) {
            ListNode afterv1 = prev1.next.next;
            prev2.next = prev1.next;
            prev2.next.next = prev1;
            prev1.next = afterv1;
            return dummy.next;
        }
        ListNode node1 = prev1.next;
        ListNode node2 = prev2.next;
        ListNode afterv1 = node1.next;
        ListNode afterv2 = node2.next;
        prev1.next = node2;
        node2.next = afterv1;
        prev2.next = node1;
        node1.next = afterv2;
        return dummy.next;
    }
}