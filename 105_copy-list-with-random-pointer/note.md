```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/copy-list-with-random-pointer
@Language: Markdown
@Datetime: 16-12-29 09:51
```

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
            return null;
        }
        copyNext(head);
        copyRandom(head);
        return splitList(head);
    }
    public void copyNext(RandomListNode head) {
        while (head != null) {
            RandomListNode newNode = new RandomListNode(head.label);
            newNode.random = head.random;
            newNode.next = head.next;
            head.next = newNode;
            head = head.next.next;
        }
    }
    public void copyRandom(RandomListNode head) {
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }
    public RandomListNode splitList(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode tmp = dummy;
        while (head != null) {
            tmp.next = head.next;
            head.next = head.next.next;
            head = head.next;
            tmp = tmp.next;
            tmp.next = null;
        }
        return dummy.next;
    }
}