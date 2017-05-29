/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/space-replacement
@Language: Java
@Datetime: 16-07-28 09:27
*/

public class Solution {
    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        // Write your code here
        if(0==length) return 0;
        int num = 0;
        for(int i=0;i<length;i++){
            if(string[i] == ' ') num++;
        }
        
        int newLen = length + num*2;
        string[newLen] = 0;
        int j = 1;
        for(int i=length-1;i>=0;i--){
            if(string[i] != ' '){
                string[newLen - j] = string[i];
                j++;
            }
            else{
                string[newLen - j] = '0';
                j++;
                string[newLen - j] = '2';
                j++;
                string[newLen - j] = '%';
                j++; 
            }
        }
        return newLen;
    }
}