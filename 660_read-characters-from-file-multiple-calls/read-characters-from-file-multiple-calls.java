/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/read-characters-from-file-multiple-calls
@Language: Java
@Datetime: 17-05-11 09:25
*/

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf destination buffer
     * @param n maximum number of characters to read
     * @return the number of characters read
     */
    private boolean EOF = false;
    private char[] temp = new char[4];
    private int left = 0;//how many characters were left in temp array
    private int offset = 0;//offset of temp array
    public int read(char[] buf, int n) {
        int readBytes = 0;
        while (readBytes < n && (!EOF || left != 0)) {
            int readSize = 0;
            if (left != 0) {
                readSize = left;
            } else {
                offset = 0;
                readSize = read4(temp);
                if (readSize < 4) {
                    EOF = true;
                }
            }
            int len = Math.min(n - readBytes, readSize);
            for (int i = offset; i < offset + len; i++) {
                buf[readBytes++] = temp[i]; 
            }
            left = readSize - len;
            if (left != 0) {
                offset += len;
            }
        }
        return readBytes;
    }
}