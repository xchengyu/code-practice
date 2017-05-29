/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/expression-evaluation
@Language: Java
@Datetime: 16-07-20 07:44
*/

class ExpressionTreeNode {
    public String symbol;
    public ExpressionTreeNode left, right;
    public ExpressionTreeNode(String symbol) {
        this.symbol = symbol;
        this.left = this.right = null;
    }
}
class TreeNode {
    public int val;
    public String sb;
    public ExpressionTreeNode root;
    public TreeNode(int val, String sb) {
        this.val = val;
        this.sb = sb;
        this.root = new ExpressionTreeNode(sb);
    }
}
public class Solution {
    /**
     * @param expression: an array of strings;
     * @return: an integer
     */
    private int base;//优先级，用数字表示。树中字符的优先级，从下到上优先级从高到低。
    public int get(String sb, int base) {//返回字符的优先级数字，数字的优先级最高，所以在数的最底层
        if (sb.equals("+") || sb.equals("-")) {
            return 1 + base;
        }
        if (sb.equals("*") || sb.equals("/")) {
            return 2 + base;
        }
        return Integer.MAX_VALUE;
    } 
    public ExpressionTreeNode build(String[] expression) {
        // write your code here
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int val = 0;
        int base = 0;
        for (int i = 0; i <= expression.length; i++) {
            if (i != expression.length) {
                if (expression[i].equals("(")) {
                    base += 10;
                    continue;
                } else if (expression[i].equals(")")) {
                    base -= 10;
                    continue;
                } else {
                    val = get(expression[i], base);
                }
            }
            TreeNode right = i == expression.length ? new TreeNode(Integer.MIN_VALUE, "") : new TreeNode(val, expression[i]);//当 i == expression.length的时候加入一个dummy node进栈清空栈（栈中最后只剩这个dummy node）
            while (!stack.isEmpty()) {//这一部分和max tree一模一样。先入栈的字符一定在后入栈的字符的左边，这个栈是个优先级单调递增栈
                if (right.val <= stack.peek().val) {
                    TreeNode nowNode  = stack.pop();
                    if (stack.isEmpty()) {
                        right.root.left = nowNode.root;
                    } else {
                        TreeNode left = stack.peek();
                        if (left.val < right.val) {
                            right.root.left = nowNode.root;
                        } else {
                            left.root.right = nowNode.root;
                        }
                    }
                } else {
                    break;
                }
            }
            stack.push(right);
        }
        return stack.peek().root.left;
    }
    public int evaluateExpression(String[] expression) {
        // write your code here
        ExpressionTreeNode root = build(expression);
        return postorder(root);
    }
    public int postorder(ExpressionTreeNode root) {
        if (root == null) {
            return 0;
        }
        if (Character.isDigit(root.symbol.charAt(0))) {
            return Integer.parseInt(root.symbol);
        }
        int left = postorder(root.left);
        int right = postorder(root.right);
        if (root.symbol.equals("+")) {
            return left + right;
        }
        if (root.symbol.equals("-")) {
            return left - right;
        }
        if (root.symbol.equals("*")) {
            return left * right;
        }
        if (root.symbol.equals("/")) {
            return left / right;
        }
        return 0;
    }
};