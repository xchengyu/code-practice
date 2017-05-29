/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/count-and-say
@Language: Java
@Datetime: 16-07-28 06:04
*/

public class Solution {
    /**
     * @param n the nth
     * @return the nth sequence
     */
    public String countAndSay(int n) {
        // Write your code here
        if (n == 0) {
            return "";
        }
        if (n == 1) {
            return "1";
        }
        String origin = "1";
        for (int i = 2; i <= n; i++) {
            char[] tmp = origin.toCharArray();
            origin = "";
            char pre = tmp[0];
            int count = 1;
            for (int j = 1; j < tmp.length; j++) {
                if (tmp[j] == tmp[j - 1]) {
                    count++;
                } else {
                    origin += count + String.valueOf(pre);
                    count = 1;
                    pre = tmp[j];
                }
            }
            origin += count + String.valueOf(pre);
        }
        return origin;
    }
}