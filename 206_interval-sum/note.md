```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/interval-sum
@Language: Markdown
@Datetime: 17-05-25 10:07
```

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
public class Solution {
    class SegmentTreeNode{
        long sum;
        int start;
        int end;
        SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end, long sum) {
            this.sum = sum;
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
        }
    }
    SegmentTreeNode root;
    public SegmentTreeNode build(int start, int end) {
        SegmentTreeNode root = new SegmentTreeNode(start, end, Long.valueOf(0));
        if (start > end) {
            return null;
        }
        if (start == end) {
            return root;
        }
        int mid = start + (end - start) / 2;
        root.left = build(start, mid);
        root.right = build(mid + 1, end);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }
    public void modify(SegmentTreeNode root, int index, int value) {
        if (root.start == index && root.end == index) {
            root.sum = Long.valueOf(value);
            return;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (index >= root.start && index <= mid) {
            modify(root.left, index, value);
        }
        if (index >= mid + 1 && index <= root.end) {
            modify(root.right, index, value);
        }
        root.sum = root.left.sum + root.right.sum;
        return;
    }
    public long query(SegmentTreeNode root, int start, int end) {
        if (root.start == start && root.end == end) {
            return root.sum;
        }
        int mid = root.start + (root.end - root.start) / 2;
        long res = Long.valueOf(0);
        //左子树
        if (start <= mid) {
            if (end <= mid) {
                res += query(root.left, start, end);
            } else {
                res += query(root.left, start, mid);
            }
        }
        //右子树
        if (mid < end) {
            if (start >= mid + 1) {
                res += query(root.right, start, end);
            } else {
                res += query(root.right, mid + 1, end);
            }
        }
        return res;
    }
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    public ArrayList<Long> intervalSum(int[] A, 
                                       ArrayList<Interval> queries) {
        // write your code here
        ArrayList<Long> result = new ArrayList<Long>();
        int n = A.length;
        root = build(0, n - 1);
        if (root == null) {
            for (Interval elem : queries) {
                result.add(Long.valueOf(0));
            }
            return result;
        }
        for (int i = 0; i < n; i++) {
            modify(root, i, A[i]);
        }
        for (Interval elem : queries) {
            result.add(query(root, elem.start, elem.end));
        }
        return result;
    }
}
