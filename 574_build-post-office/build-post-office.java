/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/build-post-office
@Language: Java
@Datetime: 16-09-18 18:48
*/

public class Solution {
    /**
     * @param grid a 2D grid
     * @return an integer
     */
    public int shortestDistance(int[][] grid) {
        // Write your code here
        if (grid == null) {
            return -1;
        }
        int row = grid.length;
        if (row == 0) {
            return -1;
        }
        int col = grid[0].length;
        if (col == 0) {
            return -1;
        }
        List<Integer> x = new ArrayList<Integer>();
        List<Integer> y = new ArrayList<Integer>();
        List<Integer> sumx = new ArrayList<Integer>();
        List<Integer> sumy = new ArrayList<Integer>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    x.add(i);
                    y.add(j);
                }
            }
        }
        Collections.sort(x);
        Collections.sort(y);
        sumx.add(0);//distance from house's x index to zero
        sumy.add(0);//distance from house's y index to zero
        for (int i = 1; i <= x.size(); i++) {
            sumx.add(sumx.get(i - 1) + x.get(i - 1));
            sumy.add(sumy.get(i - 1) + y.get(i - 1));
        }
        int result = Integer.MAX_VALUE;
        int resX = 0;
        int resY = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    int costX = get_cost(x, sumx, i);
                    int costY = get_cost(y, sumy, j);
                    int total = costX + costY;
                    result = Math.min(total, result);
                }
            }
        }
        return result;
    }
    
    private int get_cost(List<Integer> points, List<Integer> sum, int pos) {
        int num = points.size();
        if (num == 0) {
            return 0;
        }
        if (points.get(0) >= pos) {
            return sum.get(num) - num * pos;
        }
        if (points.get(points.size() - 1) <= pos) {
            return num * pos - sum.get(num);
        }
        int left = 0;
        int right = points.size() - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (points.get(mid) <= pos) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        int index = 0;
        if (points.get(right) <= pos) {
            index = right;
        } else {
            index = left;
        }
        return sum.get(num) - sum.get(index + 1) - 
            (num - 1 - index) * pos + pos * (index + 1) - sum.get(index + 1);// the size of sum is one bigger than the size of points 
    }
}