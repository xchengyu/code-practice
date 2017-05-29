```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/interval-sum-ii
@Language: Markdown
@Datetime: 17-05-26 01:13
```

class SegmentTreeNode {
    public int start, end, sum;
    public SegmentTreeNode left, right;
    public SegmentTreeNode(int start, int end, int sum) {
        this.start = start;
        this.end = end;
        this.sum = sum;
        this.left = this.right = null;
    }
}
public class Solution {
    /* you may need to use some attributes here */
    private SegmentTreeNode root;

    /**
     * @param A: An integer array
     */
    public Solution(int[] A) {
        // write your code here
        root = build(A);
    }
    
    /**
     * @param start, end: Indices
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        // write your code here
        return queryhelper(root, start, end);
    }
    
    public long queryhelper(SegmentTreeNode root, int start, int end) {
        if (start > end) {
            return Long.valueOf(0);
        }
        if (root.start == start && root.end == end) {
            return Long.valueOf(root.sum);
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (mid >= end) {
            return queryhelper(root.left, start, end);
        } else if (start > mid) {
            return queryhelper(root.right, start, end);
        }
        long left = queryhelper(root.left, start, mid);
        long right = queryhelper(root.right, mid + 1, end);
        return left + right;
    }
    
    /**
     * @param index, value: modify A[index] to value.
     */
    public void modify(int index, int value) {
        // write your code here
        modifyhelper(root, index, value);
        return;
    }
    
    public void modifyhelper(SegmentTreeNode root, int index, int value) {
        if(root.start == index && root.end == index) { // 查找到
            root.sum = value;
            return;
        }
        
        // 查询
        int mid = (root.start + root.end) / 2;
        if(root.start <= index && index <=mid) {
            modifyhelper(root.left, index, value);
        }
        
        if(mid < index && index <= root.end) {
            modifyhelper(root.right, index, value);
        }
        //更新
        root.sum = root.left.sum + root.right.sum;
        return;
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
        int sum = left.sum + right.sum;
        SegmentTreeNode root = new SegmentTreeNode(start, end, sum);
        root.left = left;
        root.right = right;
        return root;
    }
}
