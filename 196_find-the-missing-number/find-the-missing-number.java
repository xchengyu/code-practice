/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/find-the-missing-number
@Language: Java
@Datetime: 16-07-29 02:56
*/

public class Solution {
    /**    
     * @param nums: an array of integers
     * @return: an integer
     */
    public int findMissing(int[] nums) {
        // write your code here
        int n = nums.length, i = 0;
        while (i<n) {
            while (nums[i]!=i && nums[i]<n) {
                int t = nums[i];
                nums[i] = nums[t];
                nums[t] = t;
            }
            ++i;
        }
        for (i=0; i<n; ++i)
            if (nums[i]!=i) return i;
        return n;
    }
}