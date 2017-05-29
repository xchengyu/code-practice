```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/remove-duplicates-from-sorted-list-ii
@Language: Markdown
@Datetime: 17-01-25 07:40
```

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
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        // if (head == null || head.next == null) {
        //     return head;
        // }
        // ListNode front = new ListNode(0);
        // front.next = head;
        // ListNode last = front;
        // ListNode begin = head;
        // ListNode end = head.next;
        // while (begin != null && end != null) {
        //     if (begin.val == end.val) {
        //         while (end != null && begin.val == end.val) {
        //             end = end.next;
        //         }
        //         last.next = end;
        //         if (end == null) {
        //             return front.next;
        //         } else {
        //             begin = end;
        //             end = end.next;
        //         }
        //     } else {
        //         last = begin;
        //         begin = begin.next;
        //         end = begin.next;
        //     }
        // }
        // return front.next;
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode last = dummy;
        ListNode begin = head;
        ListNode end = head.next;
        while (begin != null && end != null) {
            if (begin.val == end.val) {
                while (end != null && end.val == begin.val) {
                    end = end.next;
                }
                last.next = end;
                if (end == null) {
                    return dummy.next;
                } else {
                    begin = end;
                    end = begin.next;
                }
            } else {
                last = begin;
                begin = end;
                end = begin.next;
            }
        }
        return dummy.next;
    }
}
