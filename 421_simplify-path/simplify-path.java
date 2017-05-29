/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/simplify-path
@Language: Java
@Datetime: 16-07-30 09:35
*/

public class Solution {
    /**
     * @param path the original path
     * @return the simplified path
     */
    public String simplifyPath(String path) {
        // Write your code here
        path = path.trim();
        Stack<String> stack = new Stack<String>();
        String[] file = path.split("/");
        for (int i = 0; i < file.length; i++) {
            if (file[i] == null || file[i].length() == 0 || file[i].equals(".")) {
                continue;
            }
            if (file[i].equals("..")) {
                if (stack.isEmpty()) {
                    continue;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(file[i]);
            }
        }
        String res = "";
        boolean flag = true;
        while (!stack.isEmpty()) {
            flag = false;
            String tmp = stack.pop();
            res = tmp + "/" + res;
        }
        res = "/" + res;
        return flag ? res : res.substring(0, res.length() - 1);
    }
}