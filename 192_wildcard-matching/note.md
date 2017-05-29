```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/wildcard-matching
@Language: Markdown
@Datetime: 16-07-10 09:44
```

这题用greedy思想更好写.
我们如果仔细想想，实际上，当p中'*'的数量大于1个时，我们并不需要像上面一样匹配所有尾子集。

依然以 p = "c*ab*c"，s = "cddabbac"为例。

对于p = "c*ab*c"，我们可以猜想出它可以匹配的s应该长成这样： "c....ab.....c"，省略号表示0到任意多的字符。我们发现主要就是p的中间那个"ab"比较麻烦，一定要s中的'ab'来匹配，因此只要s中间存在一个"ab"，那么一切都可以交给后面的'*'了。

所以说，当我们挨个比较p和s上的字符时，当我们遇到p的第一个'*'，我们实际只需要不断地在s的剩余部分找和'ab'匹配的部分。

换言之，我们可以记录下遇到*时p和s的位置，记为presp和press，然后挨个继续比较*(++p)和*(++s)；如果发现*p != *s，就回溯回去，p = presp，s = press+1, ++press；直到比较到末尾，或者遇到了下一个'*'，如果遇到了下一个'*'，说明 "ab"部分搞定了，下面的就交给第二个'*'了；如果p和s都到末尾了，那么就返回true；如果到末尾了既没遇到新的'*'，又还存在不匹配的值，press也已经到末尾了，那么就返回false了。

这样的思路和上面的递归比起来，最大的区别就在于：

遇到'*'，我们只考虑遇到下一个'*'前的子问题，而不是考虑一直到末尾的子问题。从而避免大量的子问题计算。




public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "?" and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        if ((s == null || s.length() == 0) && (p == null || p.length() == 0)) {
            return true;
        }
        if ((s == null || s.length() == 0) && p.equals("*")) {
            return true;
        }
        if ((s == null || s.length() == 0) || (p == null || p.length() == 0)) {
            return false;
        }
        if (s.equals(p)) {
            return true;
        }
        int countPLenNoStar = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                countPLenNoStar++;
            }
        }
        if (countPLenNoStar > s.length()) {
            return false;
        }
        int sindex = 0;
        int pindex = 0;
        int pReset = 0;
        int sReset = 0;
        boolean findStar = false;
        while (sindex < s.length() && pindex < p.length()) {
            if (s.charAt(sindex) == p.charAt(pindex) || p.charAt(pindex) == '?') {
                sindex++;
                pindex++;
                if (pindex == p.length() && findStar && sindex < s.length()) {
                    pindex = pReset;
                    sindex = ++sReset;
                }
                continue;
            } else if (p.charAt(pindex) == '*') {
                sReset = sindex;
                pReset = ++pindex;
                findStar = true;
                if (pindex == p.length()) {
                    return true;
                }
            } else {
                if (findStar) {
                    sindex = ++sReset;
                    pindex = pReset;
                } else {
                    return false;
                }
            }
        }
        if (pindex == p.length() && sindex < s.length()) {
            return false;
        }
        while (pindex < p.length() && p.charAt(pindex) == '*') {
            pindex++;
        }
        return pindex == p.length();
     }
}