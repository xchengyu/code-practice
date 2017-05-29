/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/candy
@Language: Java
@Datetime: 16-09-02 08:43
*/

public class Solution {
    /**
     * @param ratings Children's ratings
     * @return the minimum candies you must give
     */
    public int candy(int[] ratings) {
        // Write your code here
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 1; i < candies.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = candies.length - 2; i >= 0; i--) {
            if (ratings[i + 1] < ratings[i] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
        }
        int total = 0;
        for (int i = 0; i < candies.length; i++) {
            total += candies[i];
        }
        return total;
    }
}