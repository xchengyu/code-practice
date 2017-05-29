/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/missing-interval
@Language: Java
@Datetime: 17-05-12 09:34
*/

public class Solution {
    /**
     * @param nums a sorted integer array
     * @param lower an integer
     * @param upper an integer
     * @return a list of its missing ranges
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        // Write your code here
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == Integer.MIN_VALUE) {
                lower = nums[i] + 1;
                continue;
            }
            if (lower <= nums[i] - 1) {
                create(result, lower, nums[i] - 1);
            }
            if (nums[i] == Integer.MAX_VALUE) {
                return result;
            }
            lower = nums[i] + 1;
        }
        if (lower <= upper) {
            create(result, lower, upper);
        }
        return result;
    }
    
    private void create(List<String> result, int a, int b) {
        if (a > b) {
            return;
        }
        if (a == b) {
            result.add(a + "");
            return;
        }
        result.add(a + "->" + b);
        return;
    }
}