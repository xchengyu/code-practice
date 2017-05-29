```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/max-tree
@Language: Markdown
@Datetime: 16-08-29 21:32
```

这题太难了。。。
如果能够确定每个节点的父亲节点，则可以构造出整棵树。找出每个数往左数第一个比他大的数和往右数第一个比他大的数，两者中较小的数即为该数的父亲节点。如：[3,1,2]，3没有父亲节点，1的父亲节点为2，2的父亲节为3。并且可以根据与父亲的位置关系来确定是左儿子还是右儿子。接下来的问题是如何快速找出每个数往左、往右第一个比他大的数。这里需要用到数据结构栈。以找每个数左边第一个比他大的数为例，从左到右遍历每个数，栈中保持递减序列，新来的数不停的Pop出栈顶直到栈顶比新数大或没有数。以[3,1,2]为例，首先3入栈，接下来1比3小，无需pop出3，1入栈，并且确定了1往左第一个比他大的数为3。接下来2比1大，1出栈，2比3小，2入栈。并且确定了2往左第一个比他大的数为3。用同样的方法可以求得每个数往右第一个比他大的数。时间复杂度O(n)，空间复杂度也是O(n)为最优解法。
public class Solution {
    /**
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        // write your code here
        Stack<TreeNode> stack = new Stack<TreeNode>();//这个stack是从下往上递减
        TreeNode root = null;
        for (int i = 0; i <= A.length; i++) {
            TreeNode right = i == A.length ? new TreeNode(Integer.MAX_VALUE)
                : new TreeNode(A[i]);
            while (!stack.isEmpty()) {
                if (right.val > stack.peek().val) {
                    TreeNode nodeNow = stack.pop();
                    if (stack.isEmpty()) {
                        right.left = nodeNow;
                    } else {
                        TreeNode left = stack.peek();
                        if (left.val > right.val) {
                            right.left = nodeNow;
                        } else {
                            left.right = nodeNow;
                        }
                    }
                } else {
                    break;
                }
            }
            stack.push(right);
        }
        return stack.peek().left;
    }
}