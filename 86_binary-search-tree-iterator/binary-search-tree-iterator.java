/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/binary-search-tree-iterator
@Language: Java
@Datetime: 16-06-29 02:25
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
 * Example of iterate a tree:
 * BSTIterator iterator = new BSTIterator(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class BSTIterator {
    //@param root: The root of binary tree.
    Stack<TreeNode> stack;
    TreeNode head;
    public BSTIterator(TreeNode root) {
        // write your code here
        head = root;
        stack = new Stack<TreeNode>();
        while (head != null) {
            stack.push(head);
            head = head.left;
        }
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        return !stack.isEmpty();
    }

    //@return: return next node
    public TreeNode next() {
        // write your code here
        TreeNode tmp = stack.pop();
        head = tmp;
        if (tmp.right == null) {
            return tmp;
        } else {
            head = head.right;
            while (head != null) {
                stack.push(head);
                head = head.left;
            }
            return tmp;
        }
    }
}