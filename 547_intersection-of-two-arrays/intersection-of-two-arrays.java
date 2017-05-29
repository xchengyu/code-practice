/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/intersection-of-two-arrays
@Language: Java
@Datetime: 16-07-04 03:27
*/

public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> resSet = new HashSet<Integer>();
        Set<Integer> record = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            record.add(nums1[i]);
        }
        for (int num : nums2) {
            if (record.contains(num)) {
                resSet.add(num);
            }
        }
        int[] res = new int[resSet.size()];
        int index = 0;
        for (Integer num : resSet) {
            res[index++] = (int) num;
        }
        return res;
    }
}