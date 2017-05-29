/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/two-sum
@Language: Java
@Datetime: 16-07-04 04:50
*/

public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        if (numbers == null || numbers.length < 2) {
            return new int[0];
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                int[] res = new int[2];
                int index = map.get(target - numbers[i]);
                if (index > i) {
                    res[0] = i + 1;
                    res[1] = index + 1;
                    return res;
                } else if (index < i) {
                    res[0] = index + 1;
                    res[1] = i + 1;
                    return res;
                } else {
                    continue;
                }
            }
        }
        return new int[0];
    }
}