/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/super-ugly-number
@Language: Java
@Datetime: 16-07-30 08:35
*/

public class Solution {
    /**
     * @param n a positive integer
     * @param primes the given prime list
     * @return the nth super ugly number
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        // Write your code here
        Queue<Long> queue = new PriorityQueue<Long>();
        queue.offer(Long.valueOf(1));
        if (primes == null || primes.length == 0 || n == 0) {
            return 0;
        }
        int count = n;
        long res = 1;
        HashSet<Long> visit = new HashSet<Long>();
        visit.add(Long.valueOf(1));
        while (!queue.isEmpty() && count > 0) {
            res = queue.poll();
            for (int i = 0; i < primes.length; i++) {
                long cur = ((long) primes[i]) * res;
                if (visit.contains(cur)) {
                    continue;
                }
                queue.offer(cur);
                visit.add(cur);
            }
            count--;
        }
        return (int) res;
    }
}