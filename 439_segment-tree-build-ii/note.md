```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/segment-tree-build-ii
@Language: Markdown
@Datetime: 17-05-25 07:59
```

/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param A: a list of integer
     *@return: The root of Segment Tree
     */
    public SegmentTreeNode build(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return null;
        }
        return helper(A, 0, A.length - 1);
    }
    public SegmentTreeNode helper (int[] A, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start < 0 || start >= A.length || end < 0 || end >= A.length) {
            return null;
        }
        if (start == end) {
            return new SegmentTreeNode(start, end, A[start]);
        }
        SegmentTreeNode left = helper(A, start, start + (end - start) / 2);
        SegmentTreeNode right = helper(A, start + (end - start) / 2 + 1, end);
        int max = Math.max(left.max, right.max);
        SegmentTreeNode root = new SegmentTreeNode(start, end, max);
        root.left = left;
        root.right = right;
        return root;
    }
}