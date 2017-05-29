/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/partition-list
@Language: Java
@Datetime: 16-07-02 23:28
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
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if (head == null) {
            return head;
        }
        ListNode front = new ListNode(0);
        ListNode anchor = new ListNode(x);
        front.next = anchor;
        anchor.next = head;
        ListNode less = front;
        ListNode great = anchor;
        ListNode obj = head;
        while (obj != null) {
            if (obj.val < x) {
                great.next = obj.next;
                less.next = obj;
                obj.next = anchor;
                less = less.next;
                obj = great.next;
            } else {
                obj = obj.next;
                great = great.next;
            }
        }
        less.next = anchor.next;
        return front.next;
    }
}
