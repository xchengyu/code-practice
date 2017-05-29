/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/valid-palindrome
@Language: Java
@Datetime: 16-07-15 05:50
*/

public class Solution {
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return true;
        }

        int front = 0;
        int end = s.length() - 1;
        while (front < end) {
            while (front < s.length() && front < end && !isvalid(s.charAt(front))){ // nead to check range of a/b
                front++;
            }

            if (front == s.length()) { // for emtpy string â.,,,â     
                return true; 
            }           

            while (end > front && ! isvalid(s.charAt(end))) { // same here, need to check border of a,b
                end--;
            }
            if (front == end) {     
                return true; 
            } 

            if (front < end && Character.toLowerCase(s.charAt(front)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            } else {
                front++;
                end--;
            }
        }

        return true; 
    }
    private boolean isvalid (char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}