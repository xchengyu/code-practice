```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/word-break
@Language: Markdown
@Datetime: 17-01-25 07:28
```

private int getMaxLength(Set<String> dict) {
        int maxLength = 0;
        for (String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength;
    }

    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int maxLength = getMaxLength(dict);
        boolean[] canSegment = new boolean[s.length() + 1];

        canSegment[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            canSegment[i] = false;
            for (int lastWordLength = 1;
                     lastWordLength <= maxLength && lastWordLength <= i;
                     lastWordLength++) {
                if (!canSegment[i - lastWordLength]) {
                    continue;
                }
                String word = s.substring(i - lastWordLength, i);
                if (dict.contains(word)) {
                    canSegment[i] = true;
                    break;
                }
            }
        }

        return canSegment[s.length()];
    }
	public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    private int getMaxLength(Set<String> dict) {
        int maxLength = 0;
        for (String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength;
    }

    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int maxLength = getMaxLength(dict);
        if (maxLength == 0) {
            return false;
        }
        boolean[] canSegment = new boolean[s.length()];
        // for (int i = 0; i < s.length(); i++) {
        //     for (int j = i; j >= 0 && j > i - maxLength; j--) {
        //         if (dict.contains(s.substring(j, i + 1)) && (j == 0 || canSegment[j - 1])) {
        //             canSegment[i] = true;
        //             break;
        //         }
        //     }
        // }
        for (int i = 0; i < s.length(); i++) {
            for (int j = Math.max(0, i - maxLength + 1); j <= i; j++) {
                if (dict.contains(s.substring(j, i + 1)) && (j == 0 || canSegment[j - 1])) {
                    canSegment[i] = true;
                    break;
                }
            }
        }
        

        return canSegment[s.length() - 1];
    }
}