```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/swap-two-nodes-in-linked-list
@Language: Markdown
@Datetime: 17-01-15 07:44
```

should consider the v1 node is adjacent to v2 node
public class Solution {
    /**
     * @param head a ListNode
     * @oaram v1 an integer
     * @param v2 an integer
     * @return a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // Write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode node1Prev = null, node2Prev = null;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == v1) {
                node1Prev = cur;
            } else if (cur.next.val == v2) {
                node2Prev = cur;
            }
            cur = cur.next;
        }
        
        if (node1Prev == null || node2Prev == null) {
            return head;
        }
        
        if (node2Prev.next == node1Prev) {
            // make sure node1Prev is before node2Prev
            ListNode t = node1Prev;
            node1Prev = node2Prev;
            node2Prev = t;
        }
        
        ListNode node1 = node1Prev.next;
        ListNode node2 = node2Prev.next;
        ListNode node2Next = node2.next;
        if (node1Prev.next == node2Prev) {
            node1Prev.next = node2;
            node2.next = node1;
            node1.next = node2Next;
        } else {
            node1Prev.next = node2;
            node2.next = node1.next;
            
            node2Prev.next = node1;
            node1.next = node2Next;
        }
        
        return dummy.next;
    }
}