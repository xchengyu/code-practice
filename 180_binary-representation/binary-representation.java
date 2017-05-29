/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/binary-representation
@Language: Java
@Datetime: 16-12-27 08:58
*/

public class Solution {
    /**
     *@param n: Given a decimal number that is passed in as a string
     *@return: A string
     */
    public String binaryRepresentation(String n) {
        // write your code here
        if (n == null) {
            return "0";
        }
        n = n.trim();
        if (n.length() == 0) {
            return "0";
        }
        if (n.indexOf(".") == -1) {
            return parseInt(n);
        }
        String left = n.split("\\.")[0];
        String right = n.split("\\.")[1];
        String leftResult = parseInt(left);
        String rightResult = parseDouble(right);
        if (leftResult.equals("ERROR") || rightResult.equals("ERROR")) {
            return "ERROR";
        }
        if (rightResult.equals("") || rightResult.equals("0")) {
            return leftResult;
        }
        return leftResult + "." + rightResult;
    }
    
    private String parseInt(String str) {
        if (str == null || str.length() == 0 || str.equals("0")) {
            return "0";
        }
        int num = Integer.parseInt(str);
        String res = "";
        while (num > 0) {
            if ((num & 1) == 1) {
                res = "1" + res;
            } else {
                res = "0" + res;
            }
            num = num >> 1;
        }
        return res;
    }
    
    private String parseDouble(String str) {
        if (str == null || str.length() == 0 || str.equals("0")) {
            return "0";
        }
        double num = Double.parseDouble("0." + str);
        Set<Double> visit = new HashSet<Double>();
        String res = "";
        while (num > 0) {
            if (visit.contains(num)) {
                return "ERROR";
            }
            if (res.length() >= 32) {
                return "ERROR";
            }
            visit.add(num);
            num = num * 2.0;
            if (num >= 1) {
                res += "1";
                num -= 1;
            } else {
                res += "0";
            }
        }
        return res;
    }
}
// public class Solution {
//     /**
//      *@param n: Given a decimal number that is passed in as a string
//      *@return: A string
//      */
//     public String binaryRepresentation(String n) {
//         // write your code here
//         if (n.indexOf(".") == -1) {
//             return parseInteger(n);
//         }
//         String[] nums = n.split("\\.");
//         String decimal = parseFloat(nums[1]);
//         if (decimal.equals("ERROR")) {
//             return decimal;
//         }
//         if (decimal.equals("") || decimal.equals("0")) {
//             return parseInteger(nums[0]);
//         }
//         return parseInteger(nums[0]) + "." + decimal;
//     }
    
//     public String parseInteger(String str) {
//         if (str == null || str.length() == 0 || str.equals("0")) {
//             return "0";
//         }
//         int num = Integer.parseInt(str);
//         String res = "";
//         while (num > 0) {
//             if ((num & 1) == 1) {
//                 res = "1" + res;
//             } else {
//                 res = "0" + res;
//             }
//             num >>= 1;
//         }
//         return res;
//     }
    
//     public String parseFloat(String str) {
//         if (str == null || str.length() == 0 || str.equals("0")) {
//             return "0";
//         }
//         double num = Double.parseDouble("0." + str);
//         String res = "";
//         Set<Double> set = new HashSet<Double>();
//         while (num > 0) {
//             if (res.length() > 32 || set.contains(num)) {
//                 return "ERROR";
//             }
//             set.add(num);
//             num *= 2.0;
//             if (num >= 1) {
//                 res += "1";
//                 num -= 1;
//             } else {
//                 res += "0";
//             }
//         }
//         return res;
//     }
// }