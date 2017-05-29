/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/dices-sum
@Language: Java
@Datetime: 16-08-22 04:29
*/

public class Solution {
    /**
     * @param n an integer
     * @return a list of Map.Entry<sum, probability>
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
        List<Map.Entry<Integer, Double>> res 
                                = new ArrayList<Map.Entry<Integer, Double>>();
        if (n <= 0) {
            return res;
        }
        Map<Integer, Long> map = helper(n);
        long frequency = 0;
        for (Integer key : map.keySet()) {
            frequency += map.get(key);
        }
        Map<Integer, Double> tmp = new HashMap<Integer, Double>();
        for (Integer key : map.keySet()) {
            tmp.put(key, (map.get(key) * 1.00) / ((double) frequency));
        }
        res.addAll(tmp.entrySet());
        Collections.sort(res, new Comparator<Map.Entry<Integer, Double>>() {
            public int compare(Map.Entry<Integer, Double> a, 
                                                Map.Entry<Integer, Double> b) {
                return a.getKey() - b.getKey();                                        
            }    
        });
        return res;
    }
    
    public Map<Integer, Long> helper(int n) {
        if (n == 0) {
            return new HashMap<Integer, Long>();
        }
        Map<Integer, Long> oneMap = new HashMap<Integer, Long>();
        for (int i = 1; i <= 6; i++) {
                oneMap.put(i, Long.valueOf(1));
        }
        if (n == 1) {
            return oneMap;
        }
        Map<Integer, Long> left = helper(n / 2);
        Map<Integer, Long> right = left;
        Map<Integer, Long> res = merge(left, right);
        if ( n % 2 == 1) {
            return merge(res, oneMap);
        }
        return res;
    }
    
    public Map<Integer, Long> merge(Map<Integer, Long> left, 
                                                Map<Integer, Long> right) {
        Map<Integer, Long> res = new HashMap<Integer, Long>();
        for (Integer key1 : left.keySet()) {
            for (Integer key2 : right.keySet()) {
                int newKey = key1 + key2;
                long value = left.get(key1) * right.get(key2);
                if (res.containsKey(newKey)) {
                    res.put(newKey, res.get(newKey) + value);
                } else {
                    res.put(newKey, value);
                }
            }
        }
        return res;
    }
}