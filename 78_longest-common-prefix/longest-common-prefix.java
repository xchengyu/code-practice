/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/longest-common-prefix
@Language: Java
@Datetime: 17-01-27 10:23
*/

// public class Solution {
//     /**
//      * @param strs: A list of strings
//      * @return: The longest common prefix
//      */
//     public String longestCommonPrefix(String[] strs) {
//         // write your code here
//         if (strs == null || strs.length == 0) {
//             return "";
//         }
//         String prefix = strs[0];
//         for (int i = 0; i < strs.length; i++) {
//             int j = 0;
//             while (j < strs[i].length() && j < prefix.length() && prefix.charAt(j) == strs[i].charAt(j)) {
//                 j++;
//             }
//             if (j == 0) {
//                 return "";
//             }
//             prefix = prefix.substring(0, j);
//         }
//         return prefix;
//     }
// }
// public class Solution {
//     /**
//      * @param strs: A list of strings
//      * @return: The longest common prefix
//      */
//     public String longestCommonPrefix(String[] strs) {
//         // write your code here
//         if (strs == null || strs.length == 0) {
//             return "";
//         }
//         String prefix = strs[0];
//         for (int i = 0; i < strs.length; i++) {
//             int j = 0;
//             while(j < prefix.length() && j < strs[i].length() && prefix.charAt(j) == strs[i].charAt(j)) {
//                 j++;
//             }
//             if (j == 0) {
//                 return "";
//             }
//             prefix = prefix.substring(0, j);
//         }
//         return prefix;
//     }
// }
public class Solution {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        // write your code here
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 0; i < strs.length; i++) {
            int j = 0;
            while (j < prefix.length() && j < strs[i].length() && prefix.charAt(j) == strs[i].charAt(j)) {
                j++;
            }
            if (j == 0) {
                return "";
            }
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }
}