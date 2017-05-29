/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/segment-tree-query
@Language: Java
@Datetime: 17-05-25 08:28
*/

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
            return 0;
        }
        if (root.start == start && root.end == end) {
            return root.max;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (mid + 1 <= start) {
            return query(root.right, start, Math.min(root.end, end));
        } else if (end <= mid) {
            return query(root.left, Math.max(start, root.start), end);
        }
        return Math.max(query(root.left, Math.max(start, root.start), mid), query(root.right, mid + 1, Math.min(root.end, end)));
    }
}