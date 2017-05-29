```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/longest-palindromic-substring
@Language: Markdown
@Datetime: 17-01-18 06:34
```

O(n)http://articles.leetcode.com/longest-palindromic-substring-part-ii
public String longestPalindrome(String s) {
        // Write your code here
        if (s == null || s.length() < 2) {
            return s;
        }
        String res = "";
        int len = 1;
        int[][] valid = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            valid[i][i] = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i && i - j + 1 <= 1000; j++) {
                if (s.charAt(i) != s.charAt(j)) {
                    valid[j][i] = 0;
                } else {
                    if (valid[j + 1][i - 1] == 1 || i - j + 1 <= 3) {
                        valid[j][i] = 1;
                        if (i - j + 1 > len) {
                            len = i - j + 1;
                            res = s.substring(j, i + 1);
                        }
                    }
                }
            }
        }
        return res;
    }
    // public String longestPalindrome(String s) {
    //     if (s == null || s.length() == 0) {
    //         return "";
    //     }
        
    //     int length = s.length();    
    //     int max = 0;
    //     String result = "";
    //     for(int i = 1; i <= 2 * length - 1; i++){
    //         int count = 1;
    //         while(i - count >= 0 && i + count <= 2 * length  && get(s, i - count) == get(s, i + count)){
    //             count++;
    //         }
    //         count--; // there will be one extra count for the outbound #
    //         if(count > max) {
    //             result = s.substring((i - count) / 2, (i + count) / 2);
    //             max = count;
    //         }
    //     }
        
    //     return result;
    // }
    
    // private char get(String s, int i) {
    //     if(i % 2 == 0)
    //         return '#';
    //     else 
    //         return s.charAt(i / 2);
    // }