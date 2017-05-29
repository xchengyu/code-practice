/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/expression-tree-build
@Language: Java
@Datetime: 16-09-02 07:34
*/

/**
 * Definition of ExpressionTreeNode:
 * public class ExpressionTreeNode {
 *     public String symbol;
 *     public ExpressionTreeNode left, right;
 *     public ExpressionTreeNode(String symbol) {
 *         this.symbol = symbol;
 *         this.left = this.right = null;
 *     }
 * }
 */
class TreeNode {
    public int val;
    public String symbol;
    public ExpressionTreeNode root;
    public TreeNode(String symbol, int val) {
        this.symbol = symbol;
        this.val = val;
        this.root = new ExpressionTreeNode(symbol);
    }
}
public class Solution {
    /**
     * @param expression: A string array
     * @return: The root of expression tree
     */
    public ExpressionTreeNode build(String[] expression) {
        // write your code here
        if (expression == null) {
            return null;
        }
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        int base = 0;
        int val = 0;
        for (String str : expression) {
            if (str.equals("(")) {
                base += 10;
                continue;
            } else if (str.equals(")")) {
                base -= 10;
                continue;
            } else {
                val = getValue(str, base);
                nodes.add(new TreeNode(str, val));
            }
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        for (int i = 0; i <= nodes.size(); i++) {
            TreeNode cur = i == nodes.size() ? new TreeNode("#", Integer.MIN_VALUE) : nodes.get(i);
            while (!stack.isEmpty()) {
                if (stack.peek().val >= cur.val) {//when the operators are in same priority level(same base value), then we should calculate expression from left to right, so when left TreeNode's val is eqauls to right TreeNode' s val, then we should put the left TreeNode' s base val "a little bit greater" than the right TreeNode.
                    TreeNode left = stack.pop();
                    if (stack.isEmpty()) {
                        cur.root.left = left.root;
                    } else {
                        if (stack.peek().val >= cur.val) {
                            stack.peek().root.right = left.root;
                        } else {
                            cur.root.left = left.root;
                        }
                    }
                } else {
                    break;
                }
            }
            stack.push(cur);
        }
        return stack.peek().root.left;
    }
    
    public int getValue(String expression, int base) {
        if (expression.equals("+") || expression.equals("-")) {
            return base + 1;
        }
        if (expression.equals("*") || expression.equals("/")) {
            return base + 2;
        }
        return Integer.MAX_VALUE;
    }
}