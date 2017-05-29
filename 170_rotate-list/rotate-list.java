/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/rotate-list
@Language: Java
@Datetime: 16-12-29 07:21
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length ++;
            head = head.next;
        }
        return length;
    }
    
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        
        int length = getLength(head);
        n = n % length;
        if (n == 0) {
            return head;
        }
        ListNode cur = head;
        ListNode fast = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast != null && fast.next != null) {
            fast = fast.next;
            cur = cur.next;
        }
        ListNode newHead = cur.next;
        cur.next = null;
        cur = newHead;
        while (cur != null && cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;
        return newHead;
        // ListNode dummy = new ListNode(0);
        // dummy.next = head;
        // head = dummy;
        
        // ListNode tail = dummy;
        // for (int i = 0; i < n; i++) {
        //     head = head.next;
        // }
        
        // while (head.next != null) {
        //     tail = tail.next;
        //     head = head.next;
        // }
        
        // head.next = dummy.next;
        // dummy.next = tail.next;
        // tail.next = null;
        // return dummy.next;
    }
}