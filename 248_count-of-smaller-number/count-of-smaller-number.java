/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/count-of-smaller-number
@Language: Java
@Datetime: 17-05-26 01:53
*/

class SegmentTreeNode {
    public int count;
    public int start;
    public int end;
    public SegmentTreeNode left, right;
    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
        this.count = 0;
        this.left = this.right = null;
    }
}
public class Solution {
   /**
     * @param A: An integer array
     * @return: The number of element in the array that 
     *          are smaller that the given integer
     */
    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        // if (A == null || A.length == 0) {
        //     return result;
        // }
        if (queries == null || queries.length == 0) {
            return result;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[i]);
        }
        SegmentTreeNode root = build(min, max);
        // if (root == null) {
        //     return result;
        // }
        for (int i = 0; i < A.length; i++) {
            modify(root, A[i], 1);
        }
        for (int i = 0; i < queries.length; i++) {
            if (queries[i] == Integer.MIN_VALUE) {
                result.add(0);
            } else {
                result.add(query(root, min, queries[i] - 1));
            }
        }
        return result;
    }
    
    public SegmentTreeNode build(int start, int end) {
        if (start > end) {
            return null;
        }
        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if (start == end) {
            root.count = 0;
            return root;
        }
        int mid = start + (end - start) / 2;
        root.left = build(start, mid);
        root.right = build(mid + 1, end);
        root.count = root.left.count + root.right.count;
        return root;
    }
    
    public void modify(SegmentTreeNode root, int index, int count) {
        if (root == null) {
            return;
        }
        if (index < root.start || index > root.end) {
            return;
        }
        if (root.start == index && root.end == index) {
            root.count += count;
            return;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (index >= root.start && index <= mid) {
            modify(root.left, index, count);
        }
        if (index >= mid + 1 && index <= root.end) {
            modify(root.right, index, count);
        }
        root.count = root.left.count + root.right.count;
        return;
    }
    
    public int query(SegmentTreeNode root, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (root == null) {
            return 0;
        }
        if (start > root.end || end < root.start) {
            return 0;
        }
        if (root.start == start && root.end == end) {
            return root.count;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (start >= mid + 1) {
            return query(root.right, start, Math.min(root.end, end));
        }
        if (end <= mid) {
            return query(root.left, Math.max(root.start, start), end);
        }
        int leftCount = query(root.left, Math.max(root.start, start), mid);
        int rightCount = query(root.right, mid + 1, Math.min(root.end, end));
        return leftCount + rightCount;
    }
}
