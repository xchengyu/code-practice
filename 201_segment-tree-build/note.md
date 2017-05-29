```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/segment-tree-build
@Language: Markdown
@Datetime: 17-05-25 07:52
```

/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end) {
 *         this.start = start, this.end = end;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param start, end: Denote an segment / interval
     *@return: The root of Segment Tree
     */
    public SegmentTreeNode build(int start, int end) {
        // write your code here
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new SegmentTreeNode(start, end);
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        SegmentTreeNode left = build(start, start + (end - start) / 2);
        SegmentTreeNode right = build(start + (end - start) / 2 + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }
}