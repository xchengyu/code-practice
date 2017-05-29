/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/minimum-window-substring
@Language: Java
@Datetime: 17-02-01 09:16
*/

public class Solution {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        // write your code
        if (source == null || source.length() == 0) {
            return "";
        }
        if (target == null || target.length() == 0) {
            return "";
        }
        if (source.equals(target)) {
            return source;
        }
        int[] targetchar = new int[256];
        int[] sourcechar = new int[256];
        char[] chartarget = target.toCharArray();
        char[] charsource = source.toCharArray();
        inittarget(targetchar, chartarget);
        int min = Integer.MAX_VALUE;
        String str = "";
        int start = 0;
        for (int i = 0; i < charsource.length; i++) {
            sourcechar[charsource[i]]++;
            if (isValid(sourcechar, targetchar)) {
                if (min > i - start + 1) {
                    min = i - start + 1;
                    str = source.substring(start, i + 1);
                }
            }
            sourcechar[charsource[start++]]--;
            while (isValid(sourcechar, targetchar)) {
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
        for (char ch : chartarget) {
            targetchar[ch]++;
        }
        return;
    }
    public boolean isValid(int[] sourcechar, int[] targetchar) {
        for (int i = 0; i < sourcechar.length; i++) {
            if (sourcechar[i] < targetchar[i]) {
                return false;
            }
        }
        return true;
    }
}