/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/subarray-sum-closest
@Language: Java
@Datetime: 17-01-24 10:44
*/

class Pair {
    public int index;
    public int sum;
    public Pair(int index, int sum) {
        this.index = index;
        this.sum = sum;
    }
}
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        int[] res = new int[2];
        if (nums == null || nums.length < 2) {
            return res;
        }
        Pair[] sums = new Pair[nums.length];
        sums[0] = new Pair(0, nums[0]);
        for (int i = 1; i < nums.length; i++) {
            sums[i] = new Pair(i, sums[i - 1].sum + nums[i]);
        }
        Arrays.sort(sums, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return a.sum - b.sum;
            }
        });
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (ans > sums[i].sum - sums[i - 1].sum) {
                ans = sums[i].sum - sums[i - 1].sum;
                res[0] = sums[i - 1].index;
                res[1] = sums[i].index;
                Arrays.sort(res);
                res[0] += 1;
            }
        }
        return res;
    }
}
