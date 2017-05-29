/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/largest-number
@Language: Java
@Datetime: 17-01-18 09:58
*/

public class Solution {
    /**
     *@param num: A list of non negative integers
     *@return: A string
     */
    public String largestNumber(int[] num) {
        // write your code here
        if (num == null || num.length == 0) {
            return "";
        }
        String[] str = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            str[i] = num[i] + "";
        }
        Arrays.sort(str, new Comparator<String>(){
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        });
        String res = "";
        if (str[0].equals("0")) {
            return "0";//trick here
        }
        for (int i = 0; i < str.length; i++) {
            res += str[i];
        }
        return res;
    }
}
// public class Solution {
//     /**
//      *@param num: A list of non negative integers
//      *@return: A string
//      */
//     public String largestNumber(int[] num) {
//         // write your code here
//         if (num == null || num.length == 0) {
//             return "";
//         }
//         String[] str = new String[num.length];
//         for (int i = 0; i < num.length; i++) {
//             str[i] = num[i] + "";
//         }
//         Arrays.sort(str, new Comparator<String>(){
//             public int compare(String a, String b) {
//                 return (b + a).compareTo(a + b);
//             }
//         });
//         String res = "";
//         if (str[0].equals("0")) {
//             return "0";
//         }
//         for (int i = 0; i < str.length; i++) {
//             res += str[i];
//         }
//         return res;
//     }
// }