/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/kth-smallest-sum-in-two-sorted-arrays
@Language: Java
@Datetime: 16-07-13 08:47
*/

class Pair implements Comparable<Pair>{
    public int x;
    public int y;
    public int sum;
    public Pair(int x, int y, int sum) {
        this.x = x;
        this.y = y;
        this.sum = sum;
    }
    public int compareTo(Pair another) {
        if (this.sum == another.sum) {
            return 0;
        }
        return this.sum < another.sum ? -1 : 1;
    }
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair another = (Pair) obj;
        return this.x == another.x && this.y == another.y;
    }
    public int hashCode() {
        return x * 101 + y;
    }
}
public class Solution {
    /**
     * @param A an integer arrays sorted in ascending order
     * @param B an integer arrays sorted in ascending order
     * @param k an integer
     * @return an integer
     */
    public int[] dx = {1, 0};
    public int[] dy = {0, 1};
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // Write your code here
        if ((A == null || A.length == 0) && (B == null || B.length == 0)) {
            return 0;
        }
        if (A == null || A.length == 0) {
            return B[k];
        }
        if (B == null || B.length == 0) {
            return A[k];
        }
        HashSet<Pair> visited = new HashSet<Pair>();
        Queue<Pair> queue = new PriorityQueue<Pair>();//minHeap
        Pair p;
        Pair nextP;
        p = new Pair(0, 0, A[0] + B[0]);
        queue.offer(p);
        visited.add(p);
        int nextX;
        int nextY;
        int nextSum;
        for (int count = 0; count < k - 1; count++) {
            p = queue.poll();
            for (int i = 0; i < 2; i++) {
                nextX = p.x + dx[i];
                nextY = p.y + dy[i];
                nextP = new Pair(nextX, nextY, 0);
                if (nextX >= 0 && nextX < A.length && nextY >= 0 && nextY < B.length && !visited.contains(nextP)) {
                    nextSum = A[nextX] + B[nextY];
                    nextP.sum = nextSum;
                    queue.offer(nextP);
                    visited.add(nextP);
                }
            }
        }
        return queue.peek().sum;
    }
}