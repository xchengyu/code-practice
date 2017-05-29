/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/count-of-smaller-number-before-itself
@Language: Java
@Datetime: 16-09-02 08:16
*/

class SegmentTreeNode {
    public int count;
    public int start;
    public int end;
    public SegmentTreeNode left;
    public SegmentTreeNode right;
    public SegmentTreeNode(int start, int end, int count) {
        this.start = start;
        this.end = end;
        this.count = count;
        this.left = null;
        this.right = null;
    }
}
public class Solution {
    private SegmentTreeNode root;
        
    public SegmentTreeNode build(int start, int end) {
        SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
        if (start > end) {
            return null;
        }
        if (start == end) {
            root.count = 0;
            return root;
        }
        int mid = start + (end - start) / 2;
        SegmentTreeNode left = build(start, mid);
        SegmentTreeNode right = build(mid + 1, end);
        root.left = left;
        root.right = right;
        root.count = left.count + right.count;
        return root;
    }
    
    public void modify(SegmentTreeNode root, int index, int count) {
        if (root.start == index && root.end == index) {
            root.count += count;
            return;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (mid >= index && index >= root.start) {
            modify(root.left, index, count);
        }
        if (mid + 1 <= index && index <= root.end) {
            modify(root.right, index, count);
        }
        root.count = root.left.count + root.right.count;
        return;
    }
    
    public int query(SegmentTreeNode root, int start, int end) {
        if (root.start == start && root.end == end) {
            return root.count;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (root.start <= start && mid >= end) {
            return query(root.left, start, end);
        }
        if (mid + 1 <= start && root.end >= end) {
            return query(root.right, start, end);
        }
        int left = query(root.left, start, mid);
        int right = query(root.right, mid + 1, end);
        return left + right;
    }
   /**
     * @param A: An integer array
     * @return: Count the number of element before this element 'ai' is 
     *          smaller than it and return count number array
     */ 
    public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (A == null || A.length == 0) {
            return res;
        }
        root = build(0, 10000);
        for (int i = 0; i < A.length; i++) {
            int count = 0;
            if (A[i] > 0) {
                count = query(root, 0, A[i] - 1);
            }
            res.add(count);
            modify(root, A[i], 1);
        }
        return res;
    }
}
