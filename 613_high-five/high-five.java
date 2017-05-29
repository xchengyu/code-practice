/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/high-five
@Language: Java
@Datetime: 17-01-23 03:18
*/

/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
class Order implements Comparator<Integer>{
    public int compare(Integer a, Integer b) {
        return b - a;
    }
}
public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (Record elem : results) {
            if (map.containsKey(elem.id)) {
                map.get(elem.id).add(elem.score);
            } else {
                map.put(elem.id, new ArrayList<Integer>());
                map.get(elem.id).add(elem.score);
            }
        }
        Map<Integer, Double> res = new HashMap<Integer, Double>();
        for (Integer elem : map.keySet()) {
            Collections.sort(map.get(elem), new Order());
            double sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += map.get(elem).get(i);
            }
            res.put(elem, sum / 5.0);
        }
        return res;
    }
}