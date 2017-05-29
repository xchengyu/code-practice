/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/insert-into-a-cyclic-sorted-list
@Language: Java
@Datetime: 17-01-22 10:46
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
     * @param node a list node in the list
     * @param x an integer
     * @return the inserted new list node
     */
    public ListNode insert(ListNode node, int x) {
        // Write your code here
        ListNode newNode = new ListNode(x);
        if (node == null) {
            newNode.next = newNode;
            return newNode;
        }
        if (node == node.next) {
            node.next = newNode;
            newNode.next = node;
            return newNode;
        }
        ListNode cur = node;
        do {
            if (node.val <= x && x <= node.next.val) {
                newNode.next = node.next;
                node.next = newNode;
                return newNode;
            } else {
                node = node.next;
            }
        } while (cur != node);
        newNode.next = node.next;
        node.next = newNode;
        return newNode;
    }
}