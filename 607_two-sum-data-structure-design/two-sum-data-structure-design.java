/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/two-sum-data-structure-design
@Language: Java
@Datetime: 17-01-23 03:02
*/

public class TwoSum {
    Map<Integer, Integer> map;
    public TwoSum() {
        this.map = new HashMap<Integer, Integer>();
    }
    // Add the number to an internal data structure.
    public void add(int number) {
        // Write your code here
        if (map.containsKey(number)) {
            map.put(number, map.get(number) + 1);
        } else {
            map.put(number, 1);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        // Write your code here
        for (Integer num : map.keySet()) {
            if (map.containsKey(value - num)) {
                if(value != 2 * num) {
                    return true;
                } else {
                    if (map.get(num) > 1) {
                        return true;
                    } else {
                        continue;
                    }
                }
            }
        }
        return false;
    }
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);