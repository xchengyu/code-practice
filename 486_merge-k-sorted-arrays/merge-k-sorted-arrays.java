/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/merge-k-sorted-arrays
@Language: Java
@Datetime: 16-08-22 20:54
*/

class Order implements Comparator<ResultType> {
    public int compare(ResultType a, ResultType b) {
        return (int) (a.val - b.val);
    }
}
class ResultType{
    public int val;
    public int row;
    public int col;
    public ResultType(int val, int row, int col) {
        this.val = val;
        this.row = row;
        this.col = col;
    }
}
public class Solution {
    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
    public List<Integer> mergekSortedArrays(int[][] arrays) {
        // Write your code here
        List<Integer> res = new ArrayList<Integer>();
        if (arrays == null || arrays.length == 0) {
            return res;
        }
        int row = arrays.length;
        PriorityQueue<ResultType> queue = new PriorityQueue<ResultType>(arrays.length, new Order());
        for (int i = 0; i < row; i++) {
            if (arrays[i].length > 0) {
                queue.add(new ResultType(arrays[i][0], i, 0));
            }
        }
        while (!queue.isEmpty()) {
            ResultType tmp = queue.poll();
            res.add(tmp.val);
            if (arrays[tmp.row].length - 1 > tmp.col) {
                queue.add(new ResultType(arrays[tmp.row][tmp.col + 1], tmp.row, tmp.col + 1));
            }
        }
        return res;
    }
}