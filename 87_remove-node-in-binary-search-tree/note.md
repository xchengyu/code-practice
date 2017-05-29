```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/remove-node-in-binary-search-tree
@Language: Markdown
@Datetime: 16-12-31 10:34
```

在要删除的节点的右子树里面找个最小的节点替换待删除节点
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        if (root == null) {
            return null;
        }
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        TreeNode parent = findNode(dummy, root, value);
        TreeNode node;
        if (parent.left != null && parent.left.val == value) {
            node = parent.left;
        } else if (parent.right != null && parent.right.val == value) {
            node = parent.right;
        } else {
            return dummy.left;
        }
        deleteNode(parent, node);
        return dummy.left;
    }
    public TreeNode findNode(TreeNode parent, TreeNode cur, int key) {
        if (cur == null || cur.val == key) {
            return parent;
        }
        if (cur.val < key) {
            return findNode(cur, cur.right, key);
        } else {
            return findNode(cur, cur.left, key);
        }
    }
    public void deleteNode(TreeNode parent, TreeNode node) {
        if (node.right == null) {
            if (parent.left == node) {
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
        } else if (node.left == null) {
            if (parent.left == node) {
                parent.left = node.right;
            } else {
                parent.right = node.right;
            }
        } else if (node.left == null && node.right == null) {
            if (parent.left == node) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else {
            if (parent.left == node) {
                TreeNode tmp = node.right;
                TreeNode father = node.right;
                TreeNode cur = node.right.left;
                //在要删除的节点的右子树里面找个最小的节点替换待删除节点
                if (cur == null) {
                    node.right.left = node.left;
                    parent.left = node.right;
                    return;
                } else {
                    while (cur != null && cur.left != null) {
                        father = cur;
                        cur = cur.left;
                    }
                    cur.left = node.left;
                    father.left = cur.right;
                    parent.left = cur;
                    cur.right = tmp;
                    return;
                }
            } else {
                TreeNode tmp = node.right;
                TreeNode father = node.right;
                TreeNode cur = node.right.left;
                //在要删除的节点的右子树里面找个最小的节点替换待删除节点
                if (cur == null) {
                    node.right.left = node.left;
                    parent.right = node.right;
                    return;
                } else {
                    while (cur != null && cur.left != null) {
                        father = cur;
                        cur = cur.left;
                    }
                    cur.left = node.left;
                    father.left = cur.right;
                    parent.right = cur;
                    cur.right = tmp;
                    return;
                }
            }
        }
    }
}