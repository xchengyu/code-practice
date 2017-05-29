/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/left-pad
@Language: Java
@Datetime: 16-07-28 07:19
*/

public class StringUtils {
    /**
     * @param originalStr the string we want to append to with spaces
     * @param size the target length of the string
     * @return a string
     */
    static public String leftPad(String originalStr, int size) {
        // Write your code here
        while (originalStr.length() < size) {
            originalStr = " " + originalStr;
        }
        return originalStr;
    }

    /**
     * @param originalStr the string we want to append to
     * @param size the target length of the string
     * @param padChar the character to pad to the left side of the string
     * @return a string
     */
    static public String leftPad(String originalStr, int size, char padChar) {
        // Write your code here
        while (originalStr.length() < size) {
            originalStr = String.valueOf(padChar) + originalStr;
        }
        return originalStr;
    }
}