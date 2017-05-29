/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/mirror-numbers
@Language: Java
@Datetime: 17-05-08 01:37
*/

public class Solution {
    /**
     * @param num a string
     * @return true if a number is strobogrammatic or false
     */
    public boolean isStrobogrammatic(String num) {
        // Write your code here
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        if (num == null || num.length() == 0) {
            return true;
        }
        int start = 0;
        int end = num.length() - 1;
        while (start <= end) {
            char first = num.charAt(start);
            char second = num.charAt(end);
            if (map.get(first) != null && map.get(second) != null && map.get(first) == second && map.get(second) == first) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}