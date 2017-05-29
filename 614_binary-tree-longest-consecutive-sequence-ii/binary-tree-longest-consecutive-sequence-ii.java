/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/binary-tree-longest-consecutive-sequence-ii
@Language: Java
@Datetime: 17-03-09 10:29
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ResultType {
    int down;
    int up;
    int max;
    public ResultType(int up, int down, int max) {
        this.up = up;
        this.down = down;
        this.max = max;
    }
}
public class Solution {
    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */
    public int longestConsecutive2(TreeNode root) {
        // Write your code here
        return helper(root).max;
    }
    
    public ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0, 0);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        int up = 1;
        int down = 1;
        int max = 1;
        if (root.left != null && root.val + 1 == root.left.val) {
            up = Math.max(up, left.up + 1);
        }
        if (root.left != null && root.val - 1 == root.left.val) {
            down = Math.max(down, left.down + 1);
        }
        if (root.right != null && root.val + 1 == root.right.val) {
            up = Math.max(up, right.up + 1);
        }
        if (root.right != null && root.val - 1 == root.right.val) {
            down = Math.max(down, right.down + 1);
        }
        max = Math.max(max, Math.max(Math.max(left.max, right.max), down + up - 1));
        return new ResultType(up, down, max);
    }
}