/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/two-sum-difference-equals-to-target
@Language: Java
@Datetime: 17-01-23 02:07
*/

public class Solution {
    /*
     * @param nums an array of Integer
     * @param target an integer
     * @return [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum7(int[] nums, int target) {
        // write your code here
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int small = nums[i] - target;
            int big = nums[i] + target;
            if (map.containsKey(small)) {
                res[0] = Math.min(map.get(small), i) + 1;
                res[1] = Math.max(map.get(small), i) + 1;
                break;
            } else if (map.containsKey(big)) {
                res[0] = Math.min(map.get(big), i) + 1;
                res[1] = Math.max(map.get(big), i) + 1;
                break;
            } else {
                continue;
            }
        }
        return res;
    }
}