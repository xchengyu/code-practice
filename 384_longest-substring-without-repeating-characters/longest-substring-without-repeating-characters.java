/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/longest-substring-without-repeating-characters
@Language: Java
@Datetime: 16-07-15 04:35
*/

public class Solution {
    /**
     * @param s: a string
     * @return: an integer 
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if (s == null || s.length() < 2) {
            return s == null ? 0 : s.length();
        }
        HashSet<Character> set = new HashSet<Character>();
        int start = 0;
        int max = Integer.MIN_VALUE;
        char[] character = s.toCharArray();
        for (int i = 0; i < character.length; i++) {
            if (!set.contains(character[i])) {
                set.add(character[i]);
                max = Math.max(max, set.size());
            } else {
                set.remove(character[start++]);
                while (set.contains(character[i])) {
                    set.remove(character[start++]);
                }
                set.add(character[i]);
                max = Math.max(max, set.size());
            }
        }
        return max;
    }
}