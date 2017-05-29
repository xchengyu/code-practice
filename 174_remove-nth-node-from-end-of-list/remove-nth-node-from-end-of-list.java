/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/remove-nth-node-from-end-of-list
@Language: Java
@Datetime: 16-07-02 23:16
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
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        if (head == null) {
            return head;
        }
        ListNode front = new ListNode(0);
        front.next = head;
        ListNode obj = front;
        int count = n;
        while (count > 0 && obj != null) {
            obj = obj.next;
            count--;
        }
        if (obj == null) {
            return head;
        }
        ListNode dele = front;
        while (obj.next != null) {
            obj = obj.next;
            dele = dele.next;
        }
        dele.next = dele.next.next;
        return front.next;
    }
}
