/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/3sum-closest
@Language: Java
@Datetime: 16-08-16 06:31
*/

public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        // write your code here
        if (numbers == null || numbers.length == 0) {
            return 0;
        }
        Arrays.sort(numbers);
        int diff = Integer.MAX_VALUE;
        int bestSum = 0;
        for (int i = 0; i < numbers.length - 2; i++) {
            int left = i + 1;
            int right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[i] + numbers[left] + numbers[right];
                if (sum < target) {
                    left++;
                    bestSum = target - sum < diff ? sum : bestSum;
                    diff = Math.min(diff, target - sum);
                } else if (sum == target) {
                    return sum;
                } else {
                    right--;
                    bestSum = sum - target < diff ? sum : bestSum;
                    diff = Math.min(diff, sum - target);
                }
            }
        }
        return bestSum;
    }
}
