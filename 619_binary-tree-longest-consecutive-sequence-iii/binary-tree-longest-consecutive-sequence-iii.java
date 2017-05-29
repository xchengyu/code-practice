/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/binary-tree-longest-consecutive-sequence-iii
@Language: Java
@Datetime: 17-03-09 10:36
*/

/**
 * Definition for a multi tree node.
 * public class MultiTreeNode {
 *     int val;
 *     List<TreeNode> children;
 *     MultiTreeNode(int x) { val = x; }
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
     * @param root the root of k-ary tree
     * @return the length of the longest consecutive sequence path
     */
    public int longestConsecutive3(MultiTreeNode root) {
        // Write your code here
        return helper(root).max;
    }
    public ResultType helper(MultiTreeNode root) {
        if (root == null) {
            return new ResultType(0, 0, 0);
        }
        int up = 1;
        int down = 1;
        int max = 1;
        for (MultiTreeNode node : root.children) {
            ResultType result = helper(node);
            if (node == null) {
                continue;
            } else {
                if (node.val + 1 == root.val) {
                    down = Math.max(down, result.down + 1);
                }
                if (node.val - 1 == root.val) {
                    up = Math.max(up, result.up + 1);
                }
                max = Math.max(max, result.max);
            }
        }
        max = Math.max(down + up - 1, max);
        return new ResultType(up, down, max);
    }
}