/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/sort-list
@Language: Java
@Datetime: 17-01-27 07:46
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
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {  
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = dummy;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode first = dummy.next;
        ListNode second = pre.next;
        pre.next = null;
        first = sortList(first);
        second = sortList(second);
        dummy.next = null;
        ListNode tmp = dummy;
        while (first != null && second != null) {
            if (first.val < second.val) {
                tmp.next = first;
                first = first.next;
                tmp = tmp.next;
                tmp.next = null;
            } else {
                tmp.next = second;
                second = second.next;
                tmp = tmp.next;
                tmp.next = null;
            }
        }
        while (first != null) {
            tmp.next = first;
            first = first.next;
            tmp = tmp.next;
            tmp.next = null;
        }
        while (second != null) {
            tmp.next = second;
            second = second.next;
            tmp = tmp.next;
            tmp.next = null;
        }
        return dummy.next;
    }
}
