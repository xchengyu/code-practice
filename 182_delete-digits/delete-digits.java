/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/delete-digits
@Language: Java
@Datetime: 17-01-20 06:51
*/

public class Solution {
    /**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     */
    public String DeleteDigits(String A, int k) {
        // write your code here
        if (A == null || A.length() == 0) {
            return A;
        }
        StringBuilder sb = new StringBuilder(A);
        int i;
        while (k > 0) {
            for (i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) <= sb.charAt(i + 1)) {
                    continue;
                } else {
                    break;
                }
            }
            sb.delete(i, i + 1);
            k--;
        }
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.delete(0, 1);
        }
        if (sb.length() == 0) {
            return "0";
        } else {
            return sb.toString();
        }
    }
}
// public class Solution {
//     /**
//      *@param A: A positive integer which has N digits, A is a string.
//      *@param k: Remove k digits.
//      *@return: A string
//      */
//     public String DeleteDigits(String A, int k) {
//         // write your code here
//         StringBuffer sb = new StringBuffer(A);
// 		int i, j;
// 		for (i = 0; i < k; i++) {
// 			for (j = 0; j < sb.length() - 1; j++) {
// 			    if (sb.charAt(j) <= sb.charAt(j + 1)) {
// 			        continue;
// 			    } else {
// 			        break;
// 			    }
// 			}
// 			sb.delete(j, j + 1);//如果nums[i] > nums[i+1],删掉nums[i]
// 		}
//         while (sb.length() > 1 && sb.charAt(0)=='0') {
//              sb.delete(0,1);
//         }
// 		return sb.toString();
//     }
// }