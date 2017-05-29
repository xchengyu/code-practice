/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/compare-strings
@Language: Java
@Datetime: 16-07-21 01:16
*/

public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        if (A.length() < B.length()) {
            return false;
        }
        int[] character = new int[26];
        for (int i = 0; i < A.length(); i++) {
            character[A.charAt(i) - 'A']++;
        }
        for (int i = 0; i < B.length(); i++) {
            if (character[B.charAt(i) - 'A'] == 0) {
                return false;
            } else {
                character[B.charAt(i) - 'A']--;
            }
        }
        return true;
    }
}