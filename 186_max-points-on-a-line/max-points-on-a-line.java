/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/max-points-on-a-line
@Language: Java
@Datetime: 17-01-17 07:23
*/

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param points an array of point
     * @return an integer
     */
    public int maxPoints(Point[] points) {
        // Write your code here
        if (points == null || points.length == 0) {
            return 0;
        }
        Map<Double, Integer> slope = new HashMap<Double, Integer>();
        int dup = 0;
        int max = 1;
        for (int i = 0; i < points.length; i++) {
            dup = 0;
            slope.clear();
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    dup++;
                } else {
                    double key = points[j].x - points[i].x == 0 ? Integer.MAX_VALUE :
                    0.0 + ((double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x));
                    if (slope.containsKey(key)) {
                        slope.put(key, slope.get(key) + 1);
                    } else {
                        slope.put(key, 2);
                    }
                }
            }
            if (slope.size() == 0) {
                max = Math.max(max, dup + 1);
            } else {
                for (Map.Entry<Double, Integer> entry : slope.entrySet()) {
                    int tmp = entry.getValue();
                    max = Math.max(max, dup + tmp);
                }
            }
        }
        return max;
    }
}