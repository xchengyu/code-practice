/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/word-break-ii
@Language: Java
@Datetime: 16-12-23 10:17
*/

public class Solution {
    /**
     * @param s a string
     * @param wordDict a set of words
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // Write your code here
        List<String> result = new ArrayList<String>();
        if (wordDict == null || wordDict.size() == 0) {
            return result;
        }
        if (s == null || s.length() == 0) {
            return result;
        }
        int maxLength = getMaxLength(wordDict);
        boolean[] canSplit = new boolean[s.length()];
        Arrays.fill(canSplit, false);
        for (int i = 0; i < s.length(); i++) {
            for (int j = Math.max(0, i - maxLength + 1); j <= i; j++) {
                if (wordDict.contains(s.substring(j, i + 1)) && (j == 0 || canSplit[j - 1])) {
                    canSplit[i] = true;
                    break;
                }
            }
        }
        if (!canSplit[s.length() - 1]) {
            return result;
        }
        search(s, maxLength, "", wordDict, result);
        return result;
    }
    
    private int getMaxLength(Set<String> wordDict) {
        int max = 0;
        for (String s : wordDict) {
            max = Math.max(s.length(), max);
        }
        return max;
    }
    
    private void search(String str, int maxLength, String temp, Set<String> wordDict, List<String> result) {
        if (str == null || str.length() == 0) {
            result.add(temp.substring(0, temp.length() - 1));
            return;
        }
        for (int i = 0; i <= Math.min(maxLength - 1, str.length() - 1); i++) {
            String word = str.substring(0, i + 1);
            if (wordDict.contains(word)) {
                temp = temp + word + " ";
                search(str.substring(i + 1), maxLength, temp, wordDict, result);
                temp = temp.substring(0, temp.length() - word.length() - 1);
            }
        }
        return;
    }
}