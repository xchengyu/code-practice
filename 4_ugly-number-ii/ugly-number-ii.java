/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/ugly-number-ii
@Language: Java
@Datetime: 17-02-01 09:44
*/

class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // Write your code here
        //method 1 priorityqueue + hashmap nlog(n)
        // Queue<Long> Q = new PriorityQueue<Long>();
        // HashMap<Long, Boolean> inQ = new HashMap<Long, Boolean>();
        // Long[] primes = new Long[3];
        // primes[0] = Long.valueOf(2);
        // primes[1] = Long.valueOf(3);
        // primes[2] = Long.valueOf(5);
        // for (int i = 0; i < 3; i++) {
        //     Q.add(primes[i]);
        //     inQ.put(primes[i], true);
        // }
        // Long number = Long.valueOf(1);
        // for (int i = 0; i < n; i++) {
        //     number = (i == 0)? Long.valueOf(1) : Q.poll();
        //     for (int j = 0; j < 3; j++) {
        //         if (!inQ.containsKey(primes[j] * number)) {
        //             Q.add(number * primes[j]);
        //             inQ.put(number * primes[j], true);
        //         }
        //     }
        // }
        // return Integer.valueOf(number.toString());
        /////////////////////////////////////////////////////////////////
        //method 2
        // int[] ugly = new int[n];
        // ugly[0] = 1;
        // int index2 = 0;
        // int index3 = 0;
        // int index5 = 0;
        // int factor2 = 2;
        // int factor3 = 3;
        // int factor5 = 5;
        // for (int i = 1; i < n; i++) {
        //     int number = Math.min(factor2, Math.min(factor3, factor5));
        //     ugly[i] = number;
        //     if (number == factor2) {
        //         factor2 = 2 * ugly[++index2];
        //     }
        //     if (number == factor3) {
        //         factor3 = 3 * ugly[++index3];
        //     }
        //     if (number == factor5) {
        //         factor5 = 5 * ugly[++index5];
        //     }//not using "else if" is to avoid repulicating
        // }
        // return ugly[n - 1];
        // Queue<Long> queue = new PriorityQueue<Long>();
        // queue.offer(Long.valueOf(1));
        // long res = Long.valueOf(0);
        // Set<Long> visit = new HashSet<Long>();
        // while (n > 0 && !queue.isEmpty()) {
        //     res = queue.poll();
        //     long two = res * Long.valueOf(2);
        //     long three = res * Long.valueOf(3);
        //     long five = res * Long.valueOf(5);
        //     if (!visit.contains(two)) {
        //         queue.offer(two);
        //         visit.add(two);
        //     } 
        //     if (!visit.contains(three)) {
        //         queue.offer(three);
        //         visit.add(three);
        //     }
        //     if (!visit.contains(five)) {
        //         queue.offer(five);
        //         visit.add(five);
        //     }
        //     n--;
        // }
        // return (int) res;
        Queue<Long> queue = new PriorityQueue<Long>();
        queue.offer(Long.valueOf(1));
        Set<Long> visited = new HashSet<Long>();
        long res = Long.valueOf(1);
        while (n > 0 && !queue.isEmpty()) {
            res = queue.poll();
            long two = res * Long.valueOf(2);
            long three = res * Long.valueOf(3);
            long five = res * Long.valueOf(5);
            if (!visited.contains(two)) {
                queue.offer(two);
                visited.add(two);
            }
            if (!visited.contains(three)) {
                queue.offer(three);
                visited.add(three);
            }
            if (!visited.contains(five)) {
                queue.offer(five);
                visited.add(five);
            }
            n--;
        }
        return (int) res;
    }
};
