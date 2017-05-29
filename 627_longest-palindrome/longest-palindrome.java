/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/longest-palindrome
@Language: Java
@Datetime: 17-02-24 02:58
*/

public class Solution {
    /**
     * @param s a string which consists of lowercase or uppercase letters
     * @return the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        int len = 0;
        boolean hasOdd = false;
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            int value = entry.getValue();
            if (value % 2 == 0) {
                len += value;
            } else {
                hasOdd = true;
                if (value > 2) {
                    len += value - 1;
                } else {
                    continue;
                }
            }
        }
        return hasOdd ? len + 1 : len;
    }
}