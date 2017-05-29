```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/minimum-window-substring
@Language: Markdown
@Datetime: 17-02-01 09:16
```

public class Solution {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        // write your code
        if (target == null || target.length() == 0) {
            return "";
        }
        if (source.equals(target)) {
            return source;
        }
        int[] targetchar = new int[256];
        int[] sourcechar = new int[256];
        char[] charsource = source.toCharArray();
        char[] chartarget = target.toCharArray();
        inittarget(targetchar, chartarget);
        int min = Integer.MAX_VALUE;
        String str = "";
        int start = 0;
        for (int i = 0; i < charsource.length; i++) {
            sourcechar[charsource[i]]++;
            if (isValid(targetchar, sourcechar)) {
                if (min > i - start + 1) {
                    min = i - start + 1;
                    str = source.substring(start, i + 1);
                }
            }
            sourcechar[charsource[start++]]--;
            while (isValid(targetchar, sourcechar)) {
                if (min > i - start + 1) {
                    min = i - start + 1;
                    str = source.substring(start, i + 1);
                }
                sourcechar[charsource[start++]]--;
            }
            sourcechar[charsource[--start]]++;
        }
        return str;
    }
    public void inittarget(int[] targetchar, char[] chartarget) {
        for (int i = 0; i < chartarget.length; i++) {
            targetchar[chartarget[i]]++;
        }
        return;
    }
    public boolean isValid(int[] targetchar, int[] sourcechar) {
        for (int i = 0; i < 256; i++) {
            if (targetchar[i] > sourcechar[i]) {
                return false;
            }
        }
        return true;
    }
}