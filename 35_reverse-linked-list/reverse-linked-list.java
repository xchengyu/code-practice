/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/reverse-linked-list
@Language: Java
@Datetime: 17-01-12 10:14
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
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        // if (head == null || head.next == null) {
        //     return head;
        // }
        // ListNode dummy = new ListNode(-1);
        // dummy.next = head;
        // ListNode front = head;
        // ListNode tmp = head.next;
        // while (tmp != null) {
        //     head.next = tmp.next;
        //     tmp.next = front;
        //     dummy.next = tmp;
        //     front = tmp;
        //     tmp = head.next;
        // }
        // return dummy.next;
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head.next;
        ListNode front = head;
        while (cur != null) {
            head.next = cur.next;
            cur.next = front;
            dummy.next = cur;
            front = cur;
            cur = head.next;
        }
        return dummy.next;
    }
}
// public class Solution {
//     /**
//      * @param head: The head of linked list.
//      * @return: The new head of reversed linked list.
//      */
//     public ListNode reverse(ListNode head) {
//         // write your code here
//         if (head == null || head.next == null) {
//             return head;
//         }
//         ListNode dummy = new ListNode(-1);
//         dummy.next = head;
//         ListNode connect = head;
//         ListNode tmp = head.next;
//         while (tmp != null) {
//             head.next = tmp.next;
//             tmp.next = connect;
//             dummy.next = tmp;
//             connect = tmp;
//             tmp = head.next;
//         }
//         return dummy.next;
//     }
// }
