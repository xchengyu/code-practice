/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/strings-homomorphism
@Language: Java
@Datetime: 17-05-04 00:55
*/

public class Solution {
    /**
     * @param s a string
     * @param t a string
     * @return true if the characters in s can be replaced to get t or false
     */
    public boolean isIsomorphic(String s, String t) {
        // Write your code here
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> s_t = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) {
                s_t.put(s.charAt(i), t.charAt(i));
            } else {
                if (s_t.containsKey(s.charAt(i))) {
                    if (s_t.get(s.charAt(i)) == t.charAt(i)) {
                        continue;
                    } else {
                        return false;
                    }
                } else {
                    s_t.put(s.charAt(i), t.charAt(i));
                }
            } 
        }
        Set<Character> visited = new HashSet<Character>();
        for (Map.Entry<Character, Character> entry : s_t.entrySet()) {
            if (visited.contains(entry.getValue())) {
                return false;
            } else {
                visited.add(entry.getValue());
            }
        }
        return true;
    }
}