/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/intersection-of-two-linked-lists
@Language: Java
@Datetime: 17-01-18 06:20
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
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode 
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Write your code here
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tail = headA;
        while (tail != null && tail.next != null) {
            tail = tail.next;
        }
        tail.next = headB;
        ListNode fast = headA.next;
        ListNode slow = headA;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast != slow) {
            return null;
        }
        ListNode tmp = headA;
        while (tmp != slow.next) {
            tmp = tmp.next;
            slow = slow.next;
        }
        tail.next = null;
        return tmp;
    }  
}