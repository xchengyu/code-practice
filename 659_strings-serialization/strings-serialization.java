/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/strings-serialization
@Language: Java
@Datetime: 17-05-08 10:34
*/

public class Solution {
    /**
     * @param strs a list of strings
     * @return encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        // Write your code here
        String result = "";
        for (String str : strs) {
            result += str.length() + "$" + str;
        }
        return result;
    }

    /**
     * @param str a string
     * @return dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // Write your code here
        List<String> result = new LinkedList<String>();
        int start = 0;
        while (start < str.length()) {
            int index = str.indexOf("$", start);
            int size = Integer.parseInt(str.substring(start, index));
            result.add(str.substring(index + 1, index + size + 1));
            start = index + size + 1;
        }
        return result;
    }
}