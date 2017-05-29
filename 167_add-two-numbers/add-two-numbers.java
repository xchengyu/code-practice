/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/add-two-numbers
@Language: Java
@Datetime: 16-07-03 05:48
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
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        // ListNode head1 = l1;
        // ListNode head2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode tmp = dummy;
        int count = 0;
        int value = 0;
        while (l1 != null && l2 != null) {
            value = (l1.val + l2.val + count) % 10;
            count = (l1.val + l2.val + count) / 10;
            ListNode newNode = new ListNode(value);
            tmp.next = newNode;
            tmp = tmp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            value = (l1.val + count) % 10;
            count = (l1.val + count) / 10;
            ListNode newNode = new ListNode(value);
            tmp.next = newNode;
            tmp = tmp.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            value = (l2.val + count) % 10;
            count = (l2.val + count) / 10;
            ListNode newNode = new ListNode(value);
            tmp.next = newNode;
            tmp = tmp.next;
            l2 = l2.next;
        }
        if (count != 0) {
            ListNode newNode = new ListNode(count);
            tmp.next = newNode;
        }
        return dummy.next;
    }
}