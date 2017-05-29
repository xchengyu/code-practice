/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/reverse-words-in-a-string
@Language: Java
@Datetime: 16-07-28 08:01
*/

public class Solution {
    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        // write your code
        if (s == null || s.length() == 0) {
            return "";
        }

        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = array.length - 1; i >= 0; --i) {
            if (!array[i].equals("")) {
                sb.append(array[i]).append(" ");
            }
        }

        //remove the last " "
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }
}
