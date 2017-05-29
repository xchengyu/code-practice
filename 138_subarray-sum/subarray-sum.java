/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/subarray-sum
@Language: Java
@Datetime: 16-08-06 08:51
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        // ArrayList<Integer> res = new ArrayList<Integer>();
        // if (nums == null || nums.length == 0) {
        //     return res;
        // }
        // Map<Integer, Integer> map = new HashMap<Integer, Integer>();//key is sum and value is the last index
        // map.put(0, -1);
        // int sum = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     sum += nums[i];
        //     if (map.containsKey(sum)) {
        //         res.add(map.get(sum) + 1);
        //         res.add(i);
        //         return res;
        //     }
        //     map.put(sum, i);
        // }
        // return res;
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length < 1) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                res.add(map.get(sum) + 1);
                res.add(i);
                return res;
            } else {
                map.put(sum, i);
            }
        }
        return res;
    }
}