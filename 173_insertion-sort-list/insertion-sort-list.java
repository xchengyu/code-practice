/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/insertion-sort-list
@Language: Java
@Datetime: 16-08-06 08:17
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
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        // write your code here
        // ListNode dummy = new ListNode(0);
        // // 这个dummy的作用是，把head开头的链表一个个的插入到dummy开头的链表里
        // // 所以这里不需要dummy.next = head;

        // while (head != null) {
        //     ListNode node = dummy;
        //     while (node.next != null && node.next.val < head.val) {
        //         node = node.next;
        //     }
        //     ListNode temp = head.next;
        //     head.next = node.next;
        //     node.next = head;
        //     head = temp;
        // }
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode node = dummy;
            while (node.next != null && node.next.val < head.val) {
                node = node.next;
            }
            ListNode tmp = head.next;
            head.next = node.next;
            node.next = head;
            head = tmp;
        }

        return dummy.next;
    }
}