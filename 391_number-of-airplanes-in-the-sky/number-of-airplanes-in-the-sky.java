/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/number-of-airplanes-in-the-sky
@Language: Java
@Datetime: 17-01-16 05:23
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
class Point {
    public int time;
    public int island;//0 means land, 1 means fly
    public Point(int time, int island) {
        this.time = time;
        this.island = island;
    }
}
class Order implements Comparator<Point> {
    public int compare(Point a, Point b) {
        if (a.time == b.time) {
            return a.island - b.island;
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
        List<Point> points = new ArrayList<Point>();
        for (Interval interval : airplanes) {
            points.add(new Point(interval.start, 1));
            points.add(new Point(interval.end, 0));
        }
        Collections.sort(points, new Order());
        int count = 0;
        int max = 0;
        for (Point point : points) {
            if (point.island > 0) {
                count++;
                max = Math.max(max, count);
            } else {
                count--;
            }
        }
        return max;
    }
}