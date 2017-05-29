```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/strstr
@Language: Markdown
@Datetime: 17-05-22 10:00
```

// class Solution {
//     /**
//      * Returns a index to the first occurrence of target in source,
//      * or -1  if target is not part of source.
//      * @param source string to be scanned.
//      * @param target string containing the sequence of characters to match.
//      */
//     public int strStr(String source, String target) {
//         //write your code here
//         int i;
//         int j;
//         if (source == null || target == null || source.length() < target.length()) {
//             return -1;
//         }
//         if (target.length() == 0) {
//             return 0;
//         }
//         for (i = 0; i < source.length() - target.length() + 1; i++) {
//             for (j = 0; j < target.length(); j++) {
//                 if (source.charAt(i + j) != target.charAt(j)) {
//                     break;
//                 }
//             }
//             if (j == target.length()) {
//                 return i;
//             }
//         }
//         return -1;
//     }
// }
class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        //write your code here
        if (source == null || target == null || source.length() < target.length()) {
            return -1;
        }
        for (int i = 0; i <= source.length() - target.length(); i++) {
            int j;
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            if (j == target.length()) {
                return i;
            }
        }
        return -1;
    }
}