/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/house-robber-iii
@Language: Java
@Datetime: 16-07-30 08:14
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
class ResultType {
    int maxNotStolen = 0;
    int maxStolen = 0;
    public ResultType(int maxNotStolen, int maxStolen) {
        this.maxNotStolen = maxNotStolen;
        this.maxStolen = maxStolen;
    }
}
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: The maximum amount of money you can rob tonight
     */
    public int houseRobber3(TreeNode root) {
        // write your code here
        ResultType ans = helper(root);
        return Math.max(ans.maxNotStolen, ans.maxStolen);
    }
    public ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        int maxStolen = root.val + left.maxNotStolen + right.maxNotStolen;
        int maxNotStolen = Math.max(left.maxNotStolen, left.maxStolen) + 
        Math.max(right.maxNotStolen, right.maxStolen);
        return new ResultType(maxNotStolen, maxStolen);
    }
}