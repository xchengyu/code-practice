/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/copy-list-with-random-pointer
@Language: Java
@Datetime: 16-12-29 09:51
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null) {
            return head;
        }
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode newCur = new RandomListNode(cur.label);
            newCur.random = cur.random;
            newCur.next = cur.next;
            cur.next = newCur;
            cur = cur.next.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head;
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode front = dummy;
        while (cur != null) {
            front.next = cur.next;
            front = front.next;
            cur = cur.next.next;
            front.next = null;
        }
        return dummy.next;
    }
}