```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/merge-intervals
@Language: Markdown
@Datetime: 17-05-14 07:25
```

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
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        List<Interval> results = new ArrayList<Interval>();
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        Interval last = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval cur = intervals.get(i);
            if (last.end >= cur.start) {
                last.end = Math.max(last.end, cur.end);
            } else {
                results.add(last);
                last = cur;
            }
        }
        results.add(last);
        return results;
    }

}