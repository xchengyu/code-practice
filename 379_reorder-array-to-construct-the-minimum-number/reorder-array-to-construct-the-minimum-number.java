/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/reorder-array-to-construct-the-minimum-number
@Language: Java
@Datetime: 16-08-22 01:52
*/

public class Solution {
    /**
     * @param nums n non-negative integer array
     * @return a string
     */
    public String minNumber(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] strs = new String[nums.length];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = nums[i] + "";
        }
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String a, String b) {
                return (a + b).compareTo(b + a);
            }
        });
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            res += strs[i];
        }
        int index = 0;
        while (index < res.length() && res.charAt(index) == '0') {
            index++;
        }
        return index == res.length() ? "0" : res.substring(index);
    }
}