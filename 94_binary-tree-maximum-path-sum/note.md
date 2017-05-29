```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/binary-tree-maximum-path-sum
@Language: Markdown
@Datetime: 17-01-27 08:31
```

for any node, two situation:
1. a path from the root to a specific node;
2. a path from any node to any node but must go through the root;
class ResultType {
int singlePath;
int maxPath;
public ResultType(int singlePath, int maxPath) {
this.singlePath = singlePath;
this.maxPath = maxPath;
}
}
public class Solution {
/**
* @param root: The root of binary tree.
* @return: An integer.
*/
public int maxPathSum(TreeNode root) {
// write your code here
return helper(root).maxPath;
}
public ResultType helper(TreeNode root) {
// Write your code here
if (root == null) {
return new ResultType(0, Integer.MIN_VALUE);
}
ResultType left = helper(root.left);
ResultType right = helper(root.right);
int singlePath = Math.max(0, Math.max(left.singlePath, right.singlePath)) + root.val;
int maxPath = Math.max(Math.max(left.maxPath, right.maxPath), Math.max(left.singlePath, 0)
+ Math.max(right.singlePath, 0) + root.val);
return new ResultType(singlePath, maxPath);
}
}