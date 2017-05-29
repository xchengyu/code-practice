/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/kth-smallest-number-in-sorted-matrix
@Language: Java
@Datetime: 16-07-18 05:35
*/

class Element {
    public int val;
    public int row;
    public int col;
    public Element(int val, int row, int col) {
        this.val = val;
        this.row = row;
        this.col = col;
    }
}
class Order implements Comparator<Element> {
    public int compare(Element a, Element b) {
        return a.val - b.val;
    }
}
public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || k <= 0) {
            return Integer.MIN_VALUE;
        }
        int row = matrix.length;
        if (matrix[0].length == 1) {
            return k <= row ? matrix[k - 1][0] : Integer.MAX_VALUE;
        }
        int col = matrix[0].length;
        Queue<Element> heap;
        int ans = 0;
        if (row > col) {
            heap = new PriorityQueue<Element>(row, new Order());
            for (int i = 0; i < row; i++) {
                heap.offer(new Element(matrix[i][0], i, 0));
            }
            int count = k;
            while (count > 0) {
                Element tmp = heap.poll();
                count--;
                ans = tmp.val;
                int x = tmp.row;
                int y = tmp.col;
                if (y + 1 < col) {
                    heap.offer(new Element(matrix[x][y + 1], x, y + 1));
                }
            }
        } else {
            heap = new PriorityQueue<Element>(col, new Order());
            for (int i = 0; i < col; i++) {
                heap.offer(new Element(matrix[0][i], 0, i));
            }
            int count = k;
            while (count > 0) {
                Element tmp = heap.poll();
                count--;
                ans = tmp.val;
                int x = tmp.row;
                int y = tmp.col;
                if (x + 1 < row) {
                    heap.offer(new Element(matrix[x + 1][y], x + 1, y));
                }
            }
        }
        return ans;
    }
}