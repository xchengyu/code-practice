```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/segment-tree-modify
@Language: Markdown
@Datetime: 17-05-25 09:18
```

/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param root, index, value: The root of segment tree and 
     *@ change the node's value with [index, index] to the new given value
     *@return: void
     */
    public void modify(SegmentTreeNode root, int index, int value) {
        // write your code here
        // if (root == null) {
        //     return;
        // }
        // if (index < root.start || index > root.end) {
        //     return;
        // }
        // Stack<SegmentTreeNode> stack = new Stack<SegmentTreeNode>();
        // while (root != null && (root.start != index || root.end != index)) {
        //     stack.push(root);
        //     int mid = root.start + (root.end - root.start) / 2;
        //     if (index <= mid) {
        //         root = root.left;
        //     } else {
        //         root = root.right;
        //     }
        // }
        // root.max = value;
        // while (!stack.isEmpty()) {
        //     SegmentTreeNode tmp = stack.pop();
        //     tmp.max = value;
        //     if (tmp.left != null) {
        //         tmp.max = Math.max(tmp.max, tmp.left.max);
        //     }
        //     if (tmp.right != null) {
        //         tmp.max = Math.max(tmp.max, tmp.right.max);
        //     }
        // }
        // return;
        if(root.start == index && root.end == index) { // 查找到
            root.max = value;
            return;
        }
        
        // 查询
        int mid = (root.start + root.end) / 2;
        if(root.start <= index && index <=mid) {
            modify(root.left, index, value);
        }
        
        if(mid < index && index <= root.end) {
            modify(root.right, index, value);
        }
        //更新
        root.max = Math.max(root.left.max, root.right.max);
        return;
    }
}