/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/rehashing
@Language: Java
@Datetime: 16-07-05 08:28
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
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        if (hashTable == null || hashTable.length == 0) {
            return new ListNode[0];
        }
        int len = hashTable.length;
        ListNode[] newTable = new ListNode[2 * len];
        ListNode[] last = new ListNode[2 * len];
        Arrays.fill(newTable, null);
        Arrays.fill(last, null);
        for (int i = 0; i < len; i++) {
            if (hashTable[i] == null) {
                continue;
            } else {
                ListNode head = hashTable[i];
                while (head != null) {
                    ListNode tmp = head.next;
                    head.next = null;
                    int index = head.val >= 0 ? head.val % (2 * len) : (head.val % (2 * len) + 2 * len) % (2 * len);
                    if (newTable[index] == null) {
                        newTable[index] = head;
                        last[index] = head;
                    } else {
                        last[index].next = head;
                        last[index] = last[index].next;
                    }
                    head = tmp;
                }
            }
        }
        return newTable;
    }
};
