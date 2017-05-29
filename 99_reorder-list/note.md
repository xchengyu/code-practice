```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/reorder-list
@Language: Markdown
@Datetime: 16-12-29 09:22
```

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
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {
        //method 1 4ms findMiddle, reverseSecondList,merge two list
        if(head==null||head.next==null||head.next.next==null)
        {
            return;
        }
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = head;
        while(fast!=null&&fast.next!=null)
        {
            pre=slow;
            fast=fast.next.next;
            slow=slow.next;
        }
        pre.next=null;
        ListNode second = new ListNode(-1);
        second.next = reverseList(slow);
        ListNode merge = new ListNode(-1);
        ListNode tmp = merge;
        first=first.next;
        second=second.next;
        while(first!=null&&second!=null)
        {
            tmp.next = first;
            first=first.next;
            tmp=tmp.next;
            tmp.next=null;
            tmp.next = second;
            second=second.next;
            tmp=tmp.next;
            tmp.next=null;
        }
        if(second!=null)
        {
            tmp.next=second;
        }
        head = merge.next;
        return;
    }
    private ListNode reverseList(ListNode head)
    {
        if(head==null||head.next==null)
        {
            return head;
        }
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode tmp = head.next;
        while(tmp!=null)
        {
            head.next=tmp.next;
            tmp.next=first.next;
            first.next=tmp;
            tmp=head.next;
        }
        return first.next;
    }
}
