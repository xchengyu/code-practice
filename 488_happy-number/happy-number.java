/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/happy-number
@Language: Java
@Datetime: 16-07-28 06:36
*/

public class Solution {
    /**
     * @param n an integer
     * @return true if this is a happy number or false
     */
    public boolean isHappy(int n) {
        // Write your code here
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        Set<Integer> visited = new HashSet<Integer>();
        map.put(0, false);
        map.put(1, true);
        while (n != 1) {
            if (visited.contains(n)) {
                return false;
            }
            visited.add(n);
            if (map.containsKey(n)) {
                return map.get(n);
            }
            int tmp = 0;
            while (n > 0) {
                tmp += (n % 10) * (n % 10);
                n = n / 10;
            }
            n = tmp;
        }
        return true;
    }
}