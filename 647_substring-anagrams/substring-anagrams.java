/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/substring-anagrams
@Language: Java
@Datetime: 17-05-11 09:51
*/

public class Solution {
    /**
     * @param s a string
     * @param p a non-empty string
     * @return a list of index
     */
    public List<Integer> findAnagrams(String s, String p) {
        // Write your code here
        List<Integer> result = new ArrayList<Integer>();
        if (s.length() < p.length()) {
            return result;
        }
        int[] s_map = new int[256];
        int[] p_map = new int[256];
        for (int i = 0; i < p.length(); i++) {
            p_map[p.charAt(i) - '0']++;
            s_map[s.charAt(i) - '0']++;
        }
        if (isAnagram(s_map, p_map)) {
                result.add(0);
        }
        for (int i = p.length(); i < s.length(); i++) {
            s_map[s.charAt(i - p.length()) - '0']--;
            s_map[s.charAt(i) - '0']++;
            if (isAnagram(s_map, p_map)) {
                result.add(i - p.length() + 1);
            }
        }
        return result;
    }
    
    private boolean isAnagram(int[] s_map, int[] p_map) {
        for (int i = 0; i < s_map.length; i++) {
            if (s_map[i] != p_map[i]) {
                return false;
            }
        }
        return true;
    }
}