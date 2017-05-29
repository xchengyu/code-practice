/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/segment-tree-build
@Language: Java
@Datetime: 17-05-25 07:52
*/

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
        SegmentTreeNode root = null;
        if (start > end) {
            return root;
        }
        root = new SegmentTreeNode(start, end);
        if (start == end) {
            return root;
        }
        int mid = start + (end - start) / 2;
        root.left = build(start, mid);
        root.right = build(mid + 1, end);
        return root;
    }
}