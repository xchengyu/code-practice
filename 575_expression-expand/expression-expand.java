/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/expression-expand
@Language: Java
@Datetime: 17-01-13 11:15
*/

public class Solution {
    /**
     * @param s  an expression includes numbers, letters and brackets
     * @return a string
     */
    public String expressionExpand(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return s;
        }
        Stack<Character> stack = new Stack<Character>();
        Stack<Integer> num = new Stack<Integer>();
        int pointer = 0;
        int number = 0;
        while (pointer < s.length()) {
            char c = s.charAt(pointer);
            if (Character.isDigit(c)) {
                number = number * 10 + s.charAt(pointer) - '0';
            } else if (c == '[') {
                num.push(number);
                stack.push(c);
                number = 0;
            } else if (c == ']') {
                List<Character> list = new ArrayList<Character>();
                while (!stack.isEmpty()) {
                    char cur = stack.pop();
                    if (cur == '[') {
                        int time = num.pop();
                        for (int i = 0; i < time; i++) {
                            for (Character newCh : list) {
                                stack.push(newCh);
                            }
                        }
                        break;
                    } else {
                        list.add(0, new Character(cur));
                    }
                }
            } else {
                stack.push(c);
            }
            pointer++;
        }
        Stack<Character> temp = new Stack<Character>();
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        while (!temp.isEmpty()) {
            sb.append(temp.pop());
        }
        return sb.toString();
    }
}