/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/anagrams
@Language: Java
@Datetime: 16-12-24 10:03
*/

// public class Solution {
//     /**
//      * @param strs: A list of strings
//      * @return: A list of strings
//      */
//     public List<String> anagrams(String[] strs) {
//         // write your code here
//         List<String> res = new ArrayList<String>();
//         if (strs == null || strs.length < 2) {
//             return res;
//         }
//         boolean find = false;
//         for (int i = 0; i < strs.length - 1; i++) {
//             find = false;
//             if (strs[i] == null) {
//                 continue;
//             } else {
//                 res.add(strs[i]);
//                 for (int j = i + 1; j < strs.length; j++) {
//                     if (strs[j] == null || !isAnagram(strs[i], strs[j])) {
//                         continue;
//                     } else {
//                         find = true;
//                         res.add(strs[j]);
//                         strs[j] = null;
//                     }
//                 }
//                 if (!find) {
//                     res.remove(res.size() - 1);
//                 }
//             }
//         }
//         return res;
//     }
//     public boolean isAnagram(String s, String t) {
//         // write your code here
//         if (s.length() != t.length()) {
//             return false;
//         }
//         int[] character = new int[26];
//         for (int i = 0; i < s.length(); i++) {
//             character[s.charAt(i) - 'a']++;
//         }
//         for (int i = 0; i < t.length(); i++) {
//             if (character[t.charAt(i) - 'a'] == 0) {
//                 return false;
//             } else {
//                 character[t.charAt(i) - 'a']--;
//             }
//         }
//         return true;
//     }
// }
public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        List<String> result = new ArrayList<String>();
        Map<String, Integer> dict = new HashMap<String, Integer>();
        buildDict(dict, strs);
        if (dict.size() == 0) {
            return result;
        }
        
        for (String str: strs) {
            StringBuilder sb = new StringBuilder();
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            for (char ch : chars) {
                sb.append(ch);
            }
            String newStr = sb.toString();
            if (dict.containsKey(newStr)) {
                if (dict.get(newStr) > 1) {
                    result.add(str);
                }
            }
        }
        return result;
    }
    
    private void buildDict(Map<String, Integer> dict, String[] strs) {
        if (strs == null || strs.length == 0) {
            return;
        }
        for (String str: strs) {
            StringBuilder sb = new StringBuilder();
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            for (char ch : chars) {
                sb.append(ch);
            }
            String newStr = sb.toString();
            if (!dict.containsKey(newStr)) {
                dict.put(newStr, 1);
            } else {
                dict.put(newStr, dict.get(newStr) + 1);
            }
        }
    }
}