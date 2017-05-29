/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/interval-sum
@Language: Java
@Datetime: 17-05-25 10:07
*/

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
class SegmentTreeNode {
    public long sum;
    public int start;
    public int end;
    public SegmentTreeNode left, right;
    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.sum = 0;
        this.left = this.right = null;
    }
}
public class Solution {
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    public ArrayList<Long> intervalSum(int[] A, 
                                       ArrayList<Interval> queries) {
        // write your code here
        ArrayList<Long> result = new ArrayList<Long>();
        if (A == null || A.length == 0 || queries.size() == 0) {
            return result;
        }
        SegmentTreeNode root = build(A, 0, A.length - 1);
        if (root == null) {
            return result;
        }
        for (Interval cur : queries) {
            if (cur != null) {
                result.add(query(root, cur.start, cur.end));
            }
        }
        return result;
    }
    
    public SegmentTreeNode build(int[] A, int start, int end) {
        if (A == null || A.length == 0) {
            return null;
        }
        if (start < 0 || start >= A.length || end < 0 || end >= A.length || start > end) {
            return null;
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if (start == end) {
            root.sum = A[start];
            return root;
        }
        int mid = start + (end - start) / 2;
        root.left = build(A, start, mid);
        root.right = build(A, mid + 1, end);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }
    
    public long query(SegmentTreeNode root, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (start > root.end || end < root.start) {
            return 0;
        }
        if (start == root.start && end == root.end) {
            return root.sum;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (start >= mid + 1) {
            return query(root.right, start, Math.min(root.end, end));
        }
        if (end <= mid) {
            return query(root.left, Math.max(start, root.start), end);
        }
        long leftSum = query(root.left, Math.max(start, root.start), mid);
        long rightSum = query(root.right, mid + 1, Math.min(end, root.end));
        return leftSum + rightSum;
    }
}
