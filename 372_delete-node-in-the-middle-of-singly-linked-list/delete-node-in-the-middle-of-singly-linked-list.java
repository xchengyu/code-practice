/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/delete-node-in-the-middle-of-singly-linked-list
@Language: Java
@Datetime: 16-07-03 05:32
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
     * @param node: the node in the list should be deleted
     * @return: nothing
     */
    public void deleteNode(ListNode node) {
        // write your code here
        if (node == null || node.next == null)
            return;
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
        return;
    }
}