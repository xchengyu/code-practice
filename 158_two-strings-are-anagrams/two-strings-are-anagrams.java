/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/two-strings-are-anagrams
@Language: Java
@Datetime: 16-12-24 09:41
*/

// public class Solution {
//     /**
//      * @param s: The first string
//      * @param b: The second string
//      * @return true or false
//      */
//     public boolean anagram(String s, String t) {
//         // write your code here
//         if (s.length() != t.length()) {
//             return false;
//         }
//         int[] character = new int[256];
//         for (int i = 0; i < s.length(); i++) {
//             character[(int)s.charAt(i)]++;
//         }
//         for (int i = 0; i < t.length(); i++) {
//             if (character[(int)t.charAt(i)] == 0) {
//                 return false;
//             } else {
//                 character[(int)t.charAt(i)]--;
//             }
//         }
//         return true;
//     }
// };
public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        if ((s == null || s.length() == 0) && (t == null || t.length() == 0)) {
            return true;
        }
        if ((s == null || s.length() == 0) || (t == null || t.length() == 0)) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] s_char = s.toCharArray();
        char[] t_char = t.toCharArray();
        for (char ch : s_char) {
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }
        for (char ch : t_char) {
            if (!map.containsKey(ch)) {
                return false;
            } else {
                map.put(ch, map.get(ch) - 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
};