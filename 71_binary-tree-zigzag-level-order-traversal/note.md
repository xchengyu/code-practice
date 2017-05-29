```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/binary-tree-zigzag-level-order-traversal
@Language: Markdown
@Datetime: 16-12-30 02:04
```

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
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> in = new Stack<TreeNode>();
        Stack<TreeNode> out = new Stack<TreeNode>();
        int count = 0;
        in.push(root);
        count++;
        boolean zig = false;
        while (!in.isEmpty()) {
            while (count > 0) {
                out.push(in.pop());
                count--;
            }
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            while (!out.isEmpty()) {
                TreeNode obj = out.pop();
                if (zig) {
                    tmp.add(0, obj.val);
                } else {
                    tmp.add(obj.val);
                }
                if (obj.left != null) {
                    in.push(obj.left);
                    count++;
                }
                if (obj.right != null) {
                    in.push(obj.right);
                    count++;
                }
            }
            res.add(tmp);
            zig = !zig;
        }
        return res;
    }
}