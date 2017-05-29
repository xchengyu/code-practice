/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/interval-sum-ii
@Language: Java
@Datetime: 17-05-26 01:13
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
    /* you may need to use some attributes here */
    public SegmentTreeNode head;
    /**
     * @param A: An integer array
     */
    public Solution(int[] A) {
        // write your code here
        this.head = build(A, 0, A.length - 1);
    }
    
    public SegmentTreeNode build(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (nums == null || nums.length == 0) {
            return null;
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if (start == end) {
            root.sum = nums[start];
            return root;
        }
        int mid = start + (end - start) / 2;
        root.left = build(nums, start, mid);
        root.right = build(nums, mid + 1, end);
        root.sum = root.left.sum + root.right.sum;
        return root;
    }
    /**
     * @param start, end: Indices
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        // write your code here
        return queryHelper(head, start, end);
    }
    
    public long queryHelper(SegmentTreeNode root, int start, int end) {
        if (root == null) {
            return 0;
        }
        if (start > end) {
            return 0;
        }
        if (start > root.end || end < root.start) {
            return 0;
        }
        if (root.start == start && root.end == end) {
            return root.sum;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (start >= mid + 1) {
            return queryHelper(root.right, start, Math.min(root.end, end));
        }
        if (end <= mid) {
            return queryHelper(root.left, Math.max(root.start, start), end);
        }
        long leftSum = queryHelper(root.left, Math.max(root.start, start), mid);
        long rightSum = queryHelper(root.right, mid + 1, Math.min(root.end, end));
        return leftSum + rightSum;
    }
    /**
     * @param index, value: modify A[index] to value.
     */
    public void modify(int index, int value) {
        // write your code here
        modifyHelper(head, index, value);
        return;
    }
    
    public void modifyHelper(SegmentTreeNode root, int index, int value) {
        if (index < root.start || root.end < index) {
            return;
        }
        if (root == null) {
            return;
        }
        if (root.start == index && root.end == index) {
            root.sum = Long.valueOf(value);
            return;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (root.start <= index && index <= mid) {
            modifyHelper(root.left, index, value);
        }
        if (mid + 1 <= index && index <= root.end) {
            modifyHelper(root.right, index, value);
        }
        root.sum = root.left.sum + root.right.sum;
        return;
    }
}
