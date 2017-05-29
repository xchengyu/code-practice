/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/max-tree
@Language: Java
@Datetime: 16-08-29 21:32
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
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        // write your code here
        Stack<TreeNode> stack = new Stack<TreeNode>();
        for (int i = 0; i <= A.length; i++) {
            TreeNode right = i == A.length ? new TreeNode(Integer.MAX_VALUE) : new TreeNode(A[i]);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.peek();
                if (right.val > cur.val) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        right.left = cur;
                    } else {
                        TreeNode left = stack.peek();
                        if (left.val > right.val) {
                            right.left = cur;
                        } else {
                            left.right = cur;
                        }
                    }
                } else {
                    break;
                }
            }
            stack.push(right);
        }
        return stack.pop().left;
    }
}