/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/convert-sorted-array-to-binary-search-tree-with-minimal-height
@Language: Java
@Datetime: 16-07-28 05:43
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param A: an integer array
     * @return: a tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {  
        // write your code here
        if (A == null || A.length == 0) {
            return null;
        }
        return helper(A, 0, A.length - 1);
    }
    public TreeNode helper(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }
        if (end == start) {
            return new TreeNode(A[start]);
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(A[mid]);
        TreeNode left = helper(A, start, mid - 1);
        TreeNode right = helper(A, mid + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }
}
