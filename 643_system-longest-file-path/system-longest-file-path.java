/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/system-longest-file-path
@Language: Java
@Datetime: 17-05-08 10:58
*/

public class Solution {
    /**
     * @param input an abstract file system
     * @return return the length of the longest absolute path to file
     */
    public int lengthLongestPath(String input) {
        // Write your code here
        int[] path = new int[input.length() + 2];
        int result = 0;
        String[] st = input.split("\n");
        for (String str : st) {
            String name = str.replaceAll("(\t)+", "");
            int depth = str.length() - name.length();
            if (name.indexOf(".") != -1) {
                result = Math.max(result, path[depth] + name.length());
            } else {
                path[depth + 1] = path[depth] + name.length() + 1;
            }
        }
        return result;
    }
}