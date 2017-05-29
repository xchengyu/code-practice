```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/lowest-common-ancestor-iii
@Language: Markdown
@Datetime: 17-01-13 09:13
```

A B不一定在root这棵树中
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
     * @param root The root of the binary tree.
     * @param A and B two nodes
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null) {
            return null;
        }
        
        if (!find(root, A, B)) {
            return null;
        }
        return LCA(root, A, B);
    }
    
    public TreeNode LCA(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return null;
        }
        if (root == A || root == B) {
            return root;
        }
        TreeNode left = LCA(root.left, A, B);
        TreeNode right = LCA(root.right, A, B);
        if (left != null && right != null) {
            return root;
        }
        if (left == null) {
            return right;
        }
        return left;
    }
    
    public boolean find(TreeNode root, TreeNode A, TreeNode B) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        boolean findA = false;
        boolean findB = false;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.val == A.val) {
                    findA = true;
                } 
                if (cur.val == B.val) {
                    findB = true;
                }
                if (findA && findB) {
                    return true;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return false;
    }
}