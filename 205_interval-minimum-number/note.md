```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/interval-minimum-number
@Language: Markdown
@Datetime: 17-05-25 09:51
```

class SegmentTreeNode {
    public int start, end, min;
    public SegmentTreeNode left, right;
    public SegmentTreeNode(int start, int end, int min) {
        this.start = start;
        this.end = end;
        this.min = min;
        this.left = this.right = null;
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
        SegmentTreeNode root = build(A);
        if (root == null) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (Interval i : queries) {
            res.add(query(root, i.start, i.end));
        }
        return res;
    }
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
        int min = Math.min(left.min, right.min);
        SegmentTreeNode root = new SegmentTreeNode(start, end, min);
        root.left = left;
        root.right = right;
        return root;
    }
    public int query(SegmentTreeNode root, int start, int end) {
        // write your code here
        if (start > end) {
            return -1;
        }
        if (root.start == start && root.end == end) {
            return root.min;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (mid >= end) {
            return query(root.left, start, end);
        } else if (start > mid) {
            return query(root.right, start, end);
        }
        int left = query(root.left, start, mid);
        int right = query(root.right, mid + 1, end);
        return Math.min(left, right);
    }
}