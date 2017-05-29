/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/sort-letters-by-case
@Language: Java
@Datetime: 16-07-04 08:59
*/

public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        //write your code here
        int i = 0, j = chars.length - 1;
		char tmp ;
		while ( i <= j) {
			while (i <= j && Character.isLowerCase(chars[i]) ) {
			    i++;
			}
			while (i <= j && Character.isUpperCase(chars[j]) ) {
			    j--;
			}
			if (i <= j) {
				tmp = chars[i];
				chars[i] = chars[j];
				chars[j] = tmp;
				i++; j--;
			}
		}
		return;
    }
}
