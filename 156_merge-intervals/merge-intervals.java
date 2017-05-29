/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/merge-intervals
@Language: Java
@Datetime: 17-05-14 07:25
*/

/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals, a collection of intervals
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        List<Interval> result = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            return result;
        }
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                if (a.start != b.start) {
                    return a.start - b.start;
                }
                if (a.end != b.end) {
                    return a.end - b.end;
                }
                return 0;
            } 
        });
        Interval previous = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (previous.end < cur.start) {
                result.add(previous);
                previous = cur;
            } else {
                previous.end = Math.max(previous.end, cur.end);
            }
        }
        result.add(previous);
        return result;
    }

}