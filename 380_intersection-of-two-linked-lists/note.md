```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/intersection-of-two-linked-lists
@Language: Markdown
@Datetime: 17-01-18 06:20
```

Like the picture shows below: assume linked list has cycle，the length of cycle is Y，the length outside cycle is X.
two pointers, one goes one step per time, another goes two steps per time. If they went t times and meet at the K node

for pointer 1: t = X+nY+K

for pointer 2: 2t = X+mY+K (m,n is unknown)

From above equation, we could get:

2X + 2nY + 2K = X + mY + K

=>   X+K  =  (m-2n)Y 

It is clear that the relationship between X and K is complementary based on Y. Which is to say, if pointer 1 goes X steps from start node and pointer 2 goes

X steps form K node. They will meet at the start place of cycle. Complexity is O(n)
http://blog.csdn.net/sbitswc/article/details/27584037
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        
        // get the tail of list A.
        ListNode node = headA;
        while (node.next != null) {
            node = node.next;
        }
        node.next = headB;
        ListNode result = listCycleII(headA);
        node.next = null;
        return result;
    }
    
    private ListNode listCycleII(ListNode head) {
        ListNode slow = head, fast = head.next;
        
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow = head;
        fast = fast.next;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
