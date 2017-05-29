/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/interval-minimum-number
@Language: Java
@Datetime: 17-05-25 09:51
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
    public int min;
    public int start;
    public int end;
    public SegmentTreeNode left, right;
    
    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.min = Integer.MAX_VALUE;
        this.left = null;
        this.right = null;
    }
}

public class Solution {
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    public ArrayList<Integer> intervalMinNumber(int[] A, 
                                                ArrayList<Interval> queries) {
        // write your code here
        if (A == null || A.length == 0) {
            return new ArrayList<Integer>();
        }
        SegmentTreeNode root = build(A, 0, A.length - 1);
        if (root == null) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (Interval cur : queries) {
            if (cur != null) {
                result.add(query(root, cur.start, cur.end));
            }
        }
        return result;
    }
    
    public SegmentTreeNode build(int[] nums, int start, int end) {
        if (nums == null || nums.length < 0) {
            return null;
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if (start > end) {
            return null;
        }
        if (start == end) {
            root.min = nums[start];
            return root;
        }
        int mid = start + (end - start) / 2;
        root.left = build(nums, start, mid);
        root.right = build(nums, mid + 1, end);
        if (root.left == null && root.right == null) {
            return null;
        }
        if (root.left == null) {
            root.min = root.right.min;
        } else if (root.right == null) {
            root.min = root.left.min;
        } else {
            root.min = Math.min(root.left.min, root.right.min);
        }
        return root;
    }
    
    public int query(SegmentTreeNode root, int start, int end) {
        if (start > end) {
            return Integer.MAX_VALUE;
        }
        if (root.start > end || root.end < start) {
            return Integer.MAX_VALUE;
        }
        if (root.start == start && root.end == end) {
            return root.min;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (start >= mid + 1) {
            return query(root.right, start, Math.min(root.end, end));
        } else if (end <= mid) {
            return query(root.left, Math.max(start, root.start), end);
        }
        int left = query(root.left, Math.max(root.start, start), mid);
        int right = query(root.right, mid + 1, Math.min(root.end, end));
        return Math.min(left, right);
    }
}