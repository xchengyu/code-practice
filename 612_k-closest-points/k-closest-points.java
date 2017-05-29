/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/k-closest-points
@Language: Java
@Datetime: 17-01-23 06:24
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
class Order implements Comparator<Point> {
    public Point origin;
    public Order(Point origin) {
        this.origin = origin;
    }
    public int compare(Point a, Point b) {
        double distance_a = Math.pow((a.x - origin.x), 2) + Math.pow((a.y - origin.y), 2);
        double distance_b = Math.pow((b.x - origin.x), 2) + Math.pow((b.y - origin.y), 2);
        if (distance_b != distance_a) {
            return (int) (distance_b - distance_a);
        }
        if (a.x != b.x) {
            return a.x - b.x;
        }
        if (a.y != b.y) {
            return a.y - b.y;
        }
        return 0;
    }
}
public class Solution {
    /**
     * @param points a list of points
     * @param origin a point
     * @param k an integer
     * @return the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // Write your code here
        int len = Math.min(points.length, k);
        Point[] res = new Point[len];
        Queue<Point> queue = new PriorityQueue<Point>(k, new Order(origin));
        for (Point elem : points) {
            if (queue.size() < k) {
                queue.offer(elem);
            } else {
                Point top = queue.peek();
                double distance_elem = Math.pow((elem.x - origin.x), 2) + Math.pow((elem.y - origin.y), 2);
                double distance_top = Math.pow((top.x - origin.x), 2) + Math.pow((top.y - origin.y), 2);
                if (distance_top > distance_elem) {
                    queue.poll();
                    queue.offer(elem);
                } else if (distance_top == distance_elem) {
                    if (top.x < elem.x) {
                        queue.poll();
                        queue.offer(elem);
                    } else if (top.x == elem.x && top.y < elem.y) {
                        queue.poll();
                        queue.offer(elem);
                    }
                }
            }
        }
        int index = len - 1;
        while (!queue.isEmpty()) {
            res[index] = queue.poll();
            index--;
        }
        return res;
    }
}