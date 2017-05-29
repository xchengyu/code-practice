/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/swap-nodes-in-pairs
@Language: Java
@Datetime: 16-07-03 05:25
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
     * @return a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        // Write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null && head.next != null) {
            ListNode tmp = head.next.next;
            pre.next = head.next;
            head.next.next = head;
            head.next = tmp;
            pre = head;
            head = head.next;
        }
        return dummy.next;
    }
}