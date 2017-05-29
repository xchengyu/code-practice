/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/reverse-nodes-in-k-group
@Language: Java
@Datetime: 16-07-03 08:38
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
     * @param k an integer
     * @return a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // Write your code here
        if (head == null || head.next == null) {
            return head;
        }
        int len = getLength(head);
        if (k > len) {
            return head;
        }
        if (k == len) {
            return reverse(head);
        }
        ListNode tmp = head;
        int count = k - 1;
        while (count > 0) {
            head = head.next;
            count--;
        }
        ListNode nextOne = head.next;
        head.next = null;
        ListNode front = reverse(tmp);
        tmp.next = reverseKGroup(nextOne, k);
        return front;
    }
    public int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }
    public ListNode reverse(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode connect = head;
        ListNode tmp = head.next;
        while (tmp != null) {
            head.next = tmp.next;
            tmp.next = connect;
            dummy.next = tmp;
            connect = tmp;
            tmp = head.next;
        }
        return dummy.next;
    }
}