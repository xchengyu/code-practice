/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/first-position-unique-character
@Language: Java
@Datetime: 17-05-11 09:42
*/

public class Solution {
    /**
     * @param s a string
     * @return it's index
     */
    public int firstUniqChar(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (map.containsKey(cur)) {
                map.put(cur, -1);
            } else {
                map.put(cur, i);
            }
        }
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (value == -1) {
                continue;
            } else {
                min = Math.min(min, value);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}