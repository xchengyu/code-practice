/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/insert-interval
@Language: Java
@Datetime: 17-01-12 09:10
*/

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * Insert newInterval into intervals.
     * @param intervals: Sorted interval list.
     * @param newInterval: A new interval.
     * @return: A new sorted interval list.
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        // ArrayList<Interval> result = new ArrayList<Interval>();
        // // write your code here
        // if (intervals == null || newInterval == null) {
        //     return result;
        // }
        // int insert = 0;
        // for (Interval interval : intervals) {
        //     if (interval.end < newInterval.start) {
        //         result.add(interval);
        //         insert++;
        //     } else if (interval.start > newInterval.end) {
        //         result.add(interval);
        //     } else {
        //         newInterval.start = Math.min(newInterval.start, interval.start);
        //         newInterval.end = Math.max(newInterval.end, interval.end);
        //     }
        // }
        // result.add(insert, newInterval);
        // return result;
        // ArrayList<Interval> res = new ArrayList<Interval>();
        // if (intervals == null || intervals.size() == 0) {
        //     if (newInterval == null) {
        //         return res;
        //     }
        //     res.add(newInterval);
        //     return res;
        // }
        // int insertPos = 0;
        // for (int i = 0; i < intervals.size(); i++) {
        //     Interval cur = intervals.get(i);
        //     if (cur.end < newInterval.start) {
        //         res.add(cur);
        //         insertPos++;
        //     } else if (cur.start > newInterval.end) {
        //         res.add(cur);
        //     } else {
        //         newInterval.start = Math.min(newInterval.start, cur.start);
        //         newInterval.end = Math.max(newInterval.end, cur.end);
        //     }
        // }
        // res.add(insertPos, newInterval);
        // return res;
        ArrayList<Interval> res = new ArrayList<Interval>();
        int insertIndex = 0;
        if (intervals == null || intervals.size() == 0) {
            if (newInterval != null) {
                res.add(newInterval);
            }
            return res;
        }
        for (int i = 0; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (cur.end < newInterval.start) {
                insertIndex++;
                res.add(cur);
            } else if (cur.start > newInterval.end) {
                res.add(cur);
            } else {
                newInterval.start = Math.min(cur.start, newInterval.start);
                newInterval.end = Math.max(cur.end, newInterval.end);
            }
        }
        res.add(insertIndex, newInterval);
        return res;
    }
}