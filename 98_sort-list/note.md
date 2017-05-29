```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/sort-list
@Language: Markdown
@Datetime: 17-01-27 07:46
```

//method 1 partition
    // public ListNode sortList(ListNode head) {  
    //     // write your code here
    //     if (head == null || head.next == null) {
    //         return head;
    //     }
    //     ListNode pivot = head;
    //     ListNode front = partition(head, pivot.val);
    //     ListNode pre = front;
    //     ListNode cur = front;
    //     while (cur != null && cur != pivot) {
    //         pre = cur;
    //         cur = cur.next;
    //     }
    //     cur = pivot.next;
    //     pre.next = null;
    //     ListNode first = sortList(front);
    //     ListNode second = sortList(cur);
    //     pre = first;
    //     while (pre != null && pre.next != null) {
    //         pre = pre.next;
    //     }
    //     pre.next = pivot;
    //     pivot.next = second;
    //     return first;
    // }
    // public ListNode partition(ListNode head, int x) {
    //     // write your code here
    //     if (head == null) {
    //         return head;
    //     }
    //     ListNode front = new ListNode(0);
    //     ListNode anchor = new ListNode(x);
    //     front.next = anchor;
    //     anchor.next = head;
    //     ListNode less = front;
    //     ListNode great = anchor;
    //     ListNode obj = head;
    //     while (obj != null) {
    //         if (obj.val < x) {
    //             great.next = obj.next;
    //             less.next = obj;
    //             obj.next = anchor;
    //             less = less.next;
    //             obj = great.next;
    //         } else {
    //             obj = obj.next;
    //             great = great.next;
    //         }
    //     }
    //     less.next = anchor.next;
    //     return front.next;
    // }
    // //method 2 merge sort
    // public ListNode sortList(ListNode head) {
    //     if(head == null || head.next == null)
    //     {
    //         return head;
    //     }
    //     ListNode pre = head;
    //     ListNode slow = head;
    //     ListNode fast = head;
    //     while(fast != null && fast.next !=null)
    //     {
    //         pre = slow;
    //         fast = fast.next.next;
    //         slow = slow.next;
    //     }
    //     pre.next = null;
    //     ListNode left = sortList(head);
    //     ListNode right = sortList(slow);
    //     return merge(left , right);
    // }
    // private ListNode merge(ListNode left, ListNode right)
    // {
    //     if(left == null|| right == null)
    //     {
    //         return left == null?(right == null?null:right):left;
    //     }
    //     ListNode head = new ListNode(0);
    //     ListNode first = head;
    //     ListNode tmp = null;
    //     while(left != null && right != null)
    //     {
    //         if(left.val <= right.val)
    //         {
    //             first.next = left;
    //             tmp = left.next;
    //             left.next = null;
    //             left = tmp;
    //         }
    //         else
    //         {
    //             first.next = right;
    //             tmp = right.next;
    //             right.next = null;
    //             right = tmp;
    //         }
    //         first = first.next;
    //     }
    //     if(left != null)
    //     {
    //         first.next = left;
    //     }
    //     else
    //     {
    //         first.next = right;
    //     }
    //     return head.next;
    // }
    //method 3 quicksort
    public ListNode sortList(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode pivot = head;
            ListNode left = new ListNode(-1);
            ListNode right = new ListNode(-1);
            ListNode leftHead = left;
            ListNode rightHead = right;
            ListNode pivotHead = pivot;
            ListNode crt = head.next;
            if (crt == null)
                return pivot;

            while(crt != null) {
                if (crt.val < pivot.val) {
                    left.next = crt;
                    left = left.next;
                } else if (crt.val > pivot.val){
                    right.next = crt;
                    right = right.next;
                } else {
                    pivot.next = crt;
                    pivot = pivot.next;
                }
                crt = crt.next;
            }

            pivot.next = null;
            left.next = null;
            right.next = null;
            left = sortList(leftHead.next);
            right = sortList(rightHead.next);
            pivot.next = right;
            ListNode re = left;

            while (left != null && left.next != null) {
                left = left.next;
            }

            if (left == null) 
                re = pivotHead;
            else 
                left.next = pivotHead;
            return re;
    }