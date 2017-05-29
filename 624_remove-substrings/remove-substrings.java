/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/remove-substrings
@Language: Java
@Datetime: 17-03-09 11:53
*/

public class Solution {
    /**
     * @param s a string
     * @param dict a set of n substrings
     * @return the minimum length
     */
    public int minLength(String s, Set<String> dict) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (dict == null || dict.size() == 0) {
            return s.length();
        }
        int min = s.length();
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        queue.offer(s);
        visited.add(s);
        while (!queue.isEmpty()) {
            s = queue.poll();
            for (String sub : dict) {
                int found = s.indexOf(sub);
                while (found != -1) {
                    String newStr = s.substring(0, found) + s.substring(found + sub.length(), s.length());
                    if (!visited.contains(newStr)) {
                        visited.add(newStr);
                        queue.offer(newStr);
                        min = Math.min(min, newStr.length());
                    }
                    found = s.indexOf(sub, found + 1);
                }
            }
        }
        return min;
    }
}