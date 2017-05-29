```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/expression-tree-build
@Language: Markdown
@Datetime: 16-09-02 07:34
```

just like max tree
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
     * @param expression: A string array
     * @return: The root of expression tree
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
}