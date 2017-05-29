/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/search-range-in-binary-search-tree
@Language: Java
@Datetime: 16-08-08 06:19
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
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    // public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
    //     // write your code here
    //     ArrayList<Integer> res = new ArrayList<Integer>();
    //     helper(root, k1, k2, res);
    //     return res;
    // }
    // private void helper(TreeNode root, int k1, int k2, ArrayList<Integer> res) {
    //     if (root == null) {
    //         return;
    //     }
    //     if (root.val > k1) {
    //         helper(root.left, k1, k2, res);
    //     }
    //     if (root.val >= k1 && root.val <= k2) {
    //         res.add(root.val);
    //     }
    //     if (root.val < k2) {
    //         helper(root.right, k1, k2, res);
    //     }
    //     return;
    // }
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) { 
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        helper(root, k1, k2, res);
        return res;
    }
    public void helper(TreeNode root, int k1, int k2, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        if (root.val < k1) {
            helper(root.right, k1, k2, res);
        } else if (root.val > k2) {
            helper(root.left, k1, k2, res);
        } else {
            helper(root.left, k1, root.val, res);
            res.add(root.val);
            helper(root.right, root.val, k2, res);
        }
        return;
    }
}