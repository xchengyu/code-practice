/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/remove-duplicates-from-sorted-list-ii
@Language: Java
@Datetime: 17-01-25 07:40
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
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode last = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                ListNode tmp = cur.next.next;
                while (tmp != null && tmp.val == cur.val) {
                    tmp = tmp.next;
                }
                if (tmp == null) {
                    last.next = tmp;
                    return dummy.next;
                }
                last.next = tmp;
                cur = tmp;
            } else {
                last = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
