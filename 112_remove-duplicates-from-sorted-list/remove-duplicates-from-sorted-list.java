/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/remove-duplicates-from-sorted-list
@Language: Java
@Datetime: 16-08-06 09:13
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
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) { 
        // write your code here
        // if (head == null) {
        //     return null;
        // }

        // ListNode node = head;
        // while (node.next != null) {
        //     if (node.val == node.next.val) {
        //         node.next = node.next.next;
        //     } else {
        //         node = node.next;
        //     }
        // }
        // return head;
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head;
        while (node != null) {
            if (node.next != null && node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }  
}