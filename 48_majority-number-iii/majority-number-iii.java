/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/majority-number-iii
@Language: Java
@Datetime: 16-08-16 05:40
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        // write your code
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (Integer num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
            if (map.size() >= k) {
                update(map);
            }
        }
        if (map.size() == 0) {
            return -1;
        }
        for (Integer num : map.keySet()) {
            map.put(num, 0);
        }
        for (Integer num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }
        }
        int max = Integer.MIN_VALUE;
        int maxKey = Integer.MIN_VALUE;
        for (Integer elem : map.keySet()) {
            if (map.get(elem) > max) {
                max = map.get(elem);
                maxKey = elem;
            } else {
                continue;
            }
        }
        return maxKey;
    }
    
    public void update(Map<Integer, Integer> map) {
        List<Integer> removeList = new ArrayList<Integer>();
        for (Integer elem : map.keySet()) {
            map.put(elem, map.get(elem) - 1);
            if (map.get(elem) == 0) {
                removeList.add(elem);
            }
        }
        for (Integer elem : removeList) {
            map.remove(elem);
        }
        return;
    }
}
