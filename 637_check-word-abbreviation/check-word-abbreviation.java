/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/check-word-abbreviation
@Language: Java
@Datetime: 17-05-04 01:21
*/

public class Solution {
    /**
     * @param word a non-empty string
     * @param abbr an abbreviation
     * @return true if string matches with the given abbr or false
     */
    public boolean validWordAbbreviation(String word, String abbr) {
        // Write your code here
        if (word == null && abbr == null) {
            return true;
        }
        if (word == null || abbr == null) {
            return false;
        }
        int i, j = 0;
        for (i = 0; i < abbr.length(); ) {
            for (j = 0; j < word.length(); ) {
                if (word.charAt(j) == abbr.charAt(i)) {
                    i++;
                    j++;
                } else {
                    if (Character.isDigit(abbr.charAt(i))) {
                        int sum = 0;
                        while (i < abbr.length() && Character.isDigit(abbr.charAt(i))) {
                            sum = sum * 10 + (abbr.charAt(i) - '0');
                            if (sum == 0) {
                                return false;
                            }
                            i++;
                        }
                        j += sum;
                        if (j > word.length()) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
        }
        return i == abbr.length() && j == word.length();
    }
}