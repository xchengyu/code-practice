```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/number-of-airplanes-in-the-sky
@Language: Markdown
@Datetime: 17-01-16 05:23
```

class Point {
    public int time;
    public int flag;//start : 1, end : 0
    public Point(int time, int flag) {
        this.time = time;
        this.flag = flag;
    }
}
class Order implements Comparator<Point> {
    public int compare (Point a, Point b) {
        if (a.time == b.time) {
            return a.flag - b.flag;
        }
        return a.time - b.time;
    }
}
class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here
        if (airplanes == null || airplanes.size() == 0) {
            return 0;
        }
        List<Point> list = new ArrayList<Point>();
        for (Interval now : airplanes) {
            list.add(new Point(now.start, 1));
            list.add(new Point(now.end, 0));
        }
        Collections.sort(list, new Order());
        int max = Integer. MIN_VALUE;
        int count = 0;
        for (Point now : list) {
            if (now.flag == 1) {
                count++;
            } else {
                count--;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}