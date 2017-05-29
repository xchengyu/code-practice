```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/max-points-on-a-line
@Language: Markdown
@Datetime: 17-01-17 07:23
```

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
        int max = 1;
        Map<Double, Integer> slope = new HashMap<Double, Integer>();
        for (int i = 0; i < points.length; i++) {
            // shared point changed, map should be cleared and server the new point
            slope.clear();
            
            // maybe all points contained in the list are same points,and same points' k is 
            // represented by Integer.MIN_VALUE
            slope.put((double)Integer.MIN_VALUE, 1);
            int dup = 0;
            for (int j = i + 1; j < points.length; j++) {
                if (points[j].x == points[i].x && points[j].y == points[i].y) {
                    dup++;
                    continue;
                }
                
                // look 0.0+(double)(points[j].y-points[i].y)/(double)(points[j].x-points[i].x)
                // because (double)0/-1 is -0.0, so we should use 0.0+-0.0=0.0 to solve 0.0 !=-0.0
                // problem

                // if the line through two points are parallel to y coordinator, then K(slop) is 
                // Integer.MAX_VALUE
                double key = points[j].x - points[i].x == 0 ? 
                Integer.MAX_VALUE : 
                0.0 + (double)(points[j].y - points[i].y) / (double) (points[j].x - points[i].x);
                if (!slope.containsKey(key)) {
                    slope.put(key, 2);//start point, end point
                } else {
                    slope.put(key, slope.get(key) + 1);
                }
            }
            for (int temp: slope.values()) {
                // duplicate may exist
                if (temp + dup > max) {
                    max = temp + dup;
                }
            }
        }
        return max;
    }
}