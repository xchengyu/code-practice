```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/binary-representation
@Language: Markdown
@Datetime: 16-12-27 08:58
```

Be careful. Should think about all possible corner cases.
public class Solution {
    /**
     *@param n: Given a decimal number that is passed in as a string
     *@return: A string
     */
    public String binaryRepresentation(String n) {
        // write your code here
        if (n.indexOf(".") == -1) {
            return parseInteger(n);
        }
        String[] nums = n.split("\\.");
        String flt = parseFloat(nums[1]);
        if (flt.equals("ERROR")) {
            return flt;
        }
        if (flt.equals("") || flt.equals("0")) {
            return parseInteger(nums[0]);
        }
        return parseInteger(nums[0]) + "." + flt;
    }
    public String parseInteger(String str) {
        if (str.equals("") || str.equals("0")) {
            return "0";
        }
        int n = Integer.parseInt(str);
        String binary = "";
        while ( n > 0) {
            binary = (n % 2) + binary;
            n = n / 2;
        }
        return binary;
    }
    public String parseFloat(String str) {
        double d = Double.parseDouble("0." + str);
        if (d == 0) {
            return "0";
        }
        String binary = "";
        HashSet<Double> set = new HashSet<Double>();
        while (d > 0) {
            if (binary.length() > 32 || set.contains(d)) {
                return "ERROR";
            }
            set.add(d);
            d = d * 2.0;
            if (d >= 1) {
                binary += "1";
                d -= 1;
            } else {
                binary += "0";
            }
        }
        return binary;
    } 
}