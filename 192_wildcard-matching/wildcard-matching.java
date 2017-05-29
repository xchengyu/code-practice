/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/wildcard-matching
@Language: Java
@Datetime: 16-08-31 06:28
*/

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
        if ((s == null || s.length() == 0) && (p.equals("*"))) {
            return true;
        }
        if ((s == null || s.length() == 0) || (p == null || p.length() == 0)) {
            return false;
        }
        if (s.equals(p)) {
            return true;
        }
        int notStar = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                notStar++;
            }
        }
        if (notStar > s.length()) {
            return false;
        }
        int sindex = 0;
        int pindex = 0;
        int sReset = 0;
        int pReset = 0;
        boolean findStar = false;
        while (sindex < s.length() && pindex < p.length()) {
            if (s.charAt(sindex) == p.charAt(pindex) || p.charAt(pindex) == '?') {
                sindex++;
                pindex++;
                if (pindex == p.length() && findStar && sindex < s.length()) {
                    sindex = ++sReset;
                    pindex = pReset;
                }
                continue;
            } else if (p.charAt(pindex) == '*') {
                findStar = true;
                sReset = sindex;
                pReset = ++pindex;
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