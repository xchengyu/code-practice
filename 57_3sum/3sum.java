/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/3sum
@Language: Java
@Datetime: 17-01-28 08:33
*/

public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (numbers == null || numbers.length < 3) {
            return res;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            if (i != 0 && numbers[i] == numbers[i - 1]) {
                continue;
            } else {
                int target = 0 - numbers[i];
                int left = i + 1;
                int right = numbers.length - 1;
                while (left < right) {
                    if (numbers[left] + numbers[right] < target) {
                        left++;
                    } else if (numbers[left] + numbers[right] > target) {
                        right--;
                    } else {
                        ArrayList<Integer> triplets = new ArrayList<Integer>();
                        triplets.add(numbers[i]);
                        triplets.add(numbers[left]);
                        triplets.add(numbers[right]);
                        res.add(triplets);
                        left++;
                        right--;
                        while (left < right && numbers[left] == numbers[left - 1]) {
                            left++;
                        }
                        while (left < right && numbers[right] == numbers[right + 1]) {
                            right--;
                        }
                    }
                }
            }
        }
        return res;
    }
}