```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/regular-expression-matching
@Language: Markdown
@Datetime: 16-08-30 09:38
```

这题就是要细心。
dp思路
DP:

D[i][j]: 表示string s中取i长度的字串，string p中取j长度字串，进行匹配。

状态转移：

1. j >= 2 && P[j - 1] = *，这时，我们可以选择匹配s中的空字串，或匹配无限个。

k: 在s中匹配的字符的个数

所以转移式是：D[i][j] = D[i - k][j - 2] && isSame(s.charAt(i - k), p.charAt(j - 2))   (k: 1-i)

                                D[i - k][j - 2]  (k = 0) 

2. p最后一个字符不是*

那么首先，s中至少还要有一个字符，然后再匹配一个字符，以及上一级也要匹配即可。

D[i][j] = i >= 1 
&& isSame(s.charAt(i - 1), p.charAt(j - 1))
&& D[i - 1][j - 1];

3. j = 0;

 D[i][j] = i == 0;  (p为空，则s也是要为空才可以匹配）
 public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
    // public boolean isMatch(String s, String p) {
    //     // write your code here
    //     if (s == null || s.length() == 0) {
    //         return isEmpty(p);
    //     }
    //     if (p == null || p.length() == 0) {
    //         return false;
    //     }
    //     char a = s.charAt(0);
    //     char b1 = p.charAt(0);
    //     char b2 = '0';//must be initialized but can not be initialized as '*'
    //     if (p.length() > 1) {
    //         b2 = p.charAt(1);
    //     }
    //     if (b2 == '*') {
    //         if (compare(a, b1)) {
    //             return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
    //         } else {
    //             return isMatch(s, p.substring(2));
    //         }
    //     } else {
    //         if (compare(a, b1)) {
    //             return isMatch(s.substring(1), p.substring(1));
    //         } else {
    //             return false;
    //         }
    //     }
    // }
    // public boolean compare(char a, char b) {
    //     return b == '.' || a == b;
    // }
    // public boolean isEmpty(String p) {
    //     if (p == null) {
    //         return true;
    //     }
    //     if (p.length() % 2 != 0) {
    //         return false;
    //     }
    //     for (int i = 1; i < p.length(); i += 2) {
    //         if (p.charAt(i) != '*') {
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    // solution4: DP
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        
        // bug 2: should use boolean instead of int.
        boolean[][] D = new boolean[s.length() + 1][p.length() + 1];
        
        // D[i][j]: i, j, the length of String s and String p.        
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= p.length(); j++) {
                if (j == 0) {
                    // when p is empth, the s should be empty.
                    D[i][j] = i == 0;
                } else if (p.charAt(j - 1) == '*') {
                    /*
                        P has at least one node.
                    */
                    
                    // The last node in p is '*'
                    if (j < 2) {
                        // a error: there should be a character before *.
                        return false;
                    }
                    
                    // we can match 0 characters or match more characters.
                    for (int k = 0; k <= i; k++) {
                        // BUG 3: severe! Forget to deal with the empty string!!
                        if (k != 0 && !isSame(s.charAt(i - k), p.charAt(j - 2))) {
                            D[i][j] = false;
                            break;
                        }
                        
                        if (D[i - k][j - 2]) {
                            D[i][j] = true;
                            break;
                        }
                    }
                } else {
                    D[i][j] = i >= 1 
                         && isSame(s.charAt(i - 1), p.charAt(j - 1))
                         && D[i - 1][j - 1];
                }
            }
        }
        
        return D[s.length()][p.length()];
    }
    public boolean isSame(char a, char b) {
        return b == '.' || a == b;
    }
}