/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/remove-node-in-binary-search-tree
@Language: Java
@Datetime: 16-12-31 10:34
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
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        if (root == null) {
            return root;
        }
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        TreeNode parent = find(root, dummy, value);
        TreeNode node = null;
        if (parent.left != null && parent.left.val == value) {
            node = parent.left;
        } else if (parent.right != null && parent.right.val == value) {
            node = parent.right;
        } else {
            return dummy.left;
        }
        delete(parent, node);
        return dummy.left;
    }
    private TreeNode find(TreeNode child, TreeNode parent, int value) {
        if (child == null || child.val == value) {
            return parent;
        }
        if (child.val > value) {
            return find(child.left, child, value);
        } else {
            return find(child.right, child, value);
        }
    }
    private void delete(TreeNode parent, TreeNode node) {
        if (node.left == null && node.right == null) {
            if (parent.left == node) {
                parent.left = null;
                return;
            } else {
                parent.right = null;
                return;
            }
        } else if (node.left == null) {
            if (parent.left == node) {
                parent.left = node.right;
                return;
            } else {
                parent.right = node.right;
                return;
            }
        } else if (node.right == null) {
            if (parent.left == node) {
                parent.left = node.left;
                return;
            } else {
                parent.right = node.left;
                return;
            }
        } else {
            TreeNode rightMin = findMinInRight(node);
            if (parent.left == node) {
                parent.left = rightMin;
            } else {
                parent.right = rightMin;
            }
            rightMin.left = node.left;
            rightMin.right = node.right;
            return;
        }
    }
    private TreeNode findMinInRight(TreeNode node) {
        TreeNode cur = node.right.left;
        if (cur == null) {
            TreeNode target = node.right;
            node.right = target.right;
            target.right = null;
            return target;
        }
        TreeNode father = node.right;
        while (cur != null && cur.left != null) {
            father = cur;
            cur = cur.left;
        }
        if (cur.right == null) {
            father.left = null;
            return cur;
        } else {
            father.left = cur.right;
            cur.right = null;
            return cur;
        }
    }
}