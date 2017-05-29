/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/reverse-linked-list-ii
@Language: Java
@Datetime: 16-07-03 04:09
*/

/**
 * Definition for ListNode
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
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode preM = dummy;
        ListNode nodeN = dummy;
        while (m - 1 > 0) {
            preM = preM.next;
            nodeN = nodeN.next;
            m--;
            n--;
        }
        while (n > 0) {
            nodeN = nodeN.next;
            n--;
        }
        ListNode afterN = nodeN.next;
        nodeN.next = null;
        ListNode list = reverseList(preM.next);
        preM.next = list;
        ListNode tmp = list;
        while (tmp != null && tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = afterN;
        return dummy.next;
    }
    public ListNode reverseList(ListNode head) {
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