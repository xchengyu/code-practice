/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/linked-list-cycle-ii
@Language: Java
@Datetime: 16-12-29 10:42
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
     * @return: The node where the cycle begins. 
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {  
        // write your code here
        // if (head == null || head.next == null) {
        //     return null;
        // }
        // ListNode fast = head;
        // ListNode slow = head;
        // while (fast != null && fast.next != null) {
        //     fast = fast.next.next;
        //     slow = slow.next;
        //     if (fast == slow) {
        //         break;
        //     }
        // }
        // if (fast == null || fast.next == null) {
        //     return null;
        // }
        // while (head != slow) {
        //     head = head.next;
        //     slow = slow.next;
        // }
        // return head;
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        ListNode cur = head;
        while (cur != slow) {
            cur = cur.next;
            slow = slow.next;
        }
        return cur;
    }
}
