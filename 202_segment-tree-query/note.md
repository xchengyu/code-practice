```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/segment-tree-query
@Language: Markdown
@Datetime: 17-05-25 08:28
```

/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param root, start, end: The root of segment tree and 
     *                         an segment / interval
     *@return: The maximum number in the interval [start, end]
     */
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if (start > end) {
            return Integer.MIN_VALUE;
        }
        if (start == root.start && end == root.end) {
            return root.max; 
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (mid >= end) {
            return query(root.left, start, end);
        } else if (mid >= start) {
            int left = query(root.left, start, mid);
            int right = query(root.right, mid + 1, end);
            return Math.max(left, right);
        }
        return query(root.right, start, end);
        
    }
}