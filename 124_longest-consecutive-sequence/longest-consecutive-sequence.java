/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/longest-consecutive-sequence
@Language: Java
@Datetime: 17-01-24 10:35
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        // write you code here
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < num.length; i++) {
            set.add(num[i]);
        }
        int max = 0;
        for (int i = 0; i < num.length; i++) {
            int tmp = num[i];
            int up = num[i] + 1;
            int down = num[i] - 1;
            while (set.contains(up)) {
                set.remove(up);
                up++;
            }
            while (set.contains(down)) {
                set.remove(down);
                down--;
            }
            max = Math.max(max, up - down - 1);
        }
        return max;
    }
}