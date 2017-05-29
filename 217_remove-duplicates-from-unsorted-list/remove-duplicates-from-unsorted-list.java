/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/remove-duplicates-from-unsorted-list
@Language: Java
@Datetime: 16-07-03 05:19
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
     * @param head: The first node of linked list.
     * @return: head node
     */
    public ListNode removeDuplicates(ListNode head) { 
        // Write your code here
        if (head == null || head.next == null) {
            return head;
        }
        Set<Integer> res = new HashSet<Integer>();
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        dummy.next = head;
        while (head != null) {
            if (!res.contains(head.val)) {
                res.add(head.val);
                pre = head;
                head = head.next;
            } else {
                pre.next = head.next;
                head = head.next;
            }
        }
        return dummy.next;
    }  
}