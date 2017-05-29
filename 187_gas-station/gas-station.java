/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/gas-station
@Language: Java
@Datetime: 17-01-18 09:57
*/

public class Solution {
    /**
     * @param gas: an array of integers
     * @param cost: an array of integers
     * @return: an integer
     */
     public int canCompleteCircuit(int[] gas, int[] cost) {
         //this method use a little trick, when we exit for loop, if we get an index i,
         //then the sum 'M' of the subarray which ends up with i - 1 is smaller than zero;
         //if total is greater than 0, this means the sum 'N' of the subarray which starts from i is greater than 0 and M + N > 0, so i is the starting point
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
            return -1;
        }

        int sum = 0;
        int total = 0;
        int index = 0;
        //int index = -1;

        for (int i = 0; i < gas.length; i++) {
            if (sum < 0) {
                index = i;
                sum = gas[i] - cost[i];
                total += gas[i] - cost[i];
            } else {
                sum += gas[i] - cost[i];
                total += gas[i] - cost[i];
            }
        }
        return total < 0 ? -1 : index;
        // index should be updated here for cases ([5], [4]);
        // total < 0 is for case [2], [2]
    }
    // public int canCompleteCircuit(int[] gas, int[] cost) {
    //     if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
    //         return -1;
    //     }

    //     int sum = 0;
    //     int total = 0;
    //     int index = 0;
    //     //int index = -1;

    //     for(int i = 0; i < gas.length; i++) {
    //         // sum += gas[i] - cost[i];
    //         // total += gas[i] - cost[i];
    //         if(sum < 0) {
    //             index = i;
    //             sum = 0;
    //         }
    //         sum += gas[i] - cost[i];
    //         total += gas[i] - cost[i];
    //     }
    //     return total < 0 ? -1 : index;
    //     // index should be updated here for cases ([5], [4]);
    //     // total < 0 is for case [2], [2]
    // }
    // public int canCompleteCircuit(int[] gas, int[] cost) {
    //     // write your code here
    //     if (gas == null || gas.length == 0) {
    //         return 0;
    //     }
    //     int sum = 0;
    //     for (int i = 0; i < gas.length; i++) {
    //         gas[i] = gas[i] - cost[i];
    //         sum += gas[i];
    //     }
    //     if (sum < 0) {
    //         return -1;
    //     }
    //     ArrayList<Integer> forth = max(gas);
    //     for (int i = 0; i < gas.length; i++) {
    //         gas[i] = -gas[i];
    //     }
    //     int forth_max = forth.get(2);
    //     int forth_start = forth.get(0);
    //     int forth_end = forth.get(1);
    //     ArrayList<Integer> back = max(gas);
    //     int back_max = back.get(2);
    //     int back_start = back.get(0);
    //     int back_end = back.get(1);
    //     return forth_max >= sum + back_max ? forth_start : back_end == gas.length - 1 ? 0 : back_end + 1;
    // }
    // public ArrayList<Integer> max(int[] gas) {
    //     ArrayList<Integer> res = new ArrayList<Integer>();
    //     res.add(0);
    //     res.add(0);
    //     res.add(0);
    //     int start = 0;
    //     int end = 0;
    //     int sum = 0;
    //     int max = Integer.MIN_VALUE;
    //     for (int i = 0; i < gas.length; i++) {
    //         if (sum < 0) {
    //             start = i;
    //             end = i;
    //             sum = 0;
    //         }
    //         sum += gas[i];
    //         end = i;
    //         if (sum > max) {
    //             max = sum;
    //             res.set(0, start);
    //             res.set(1, end);
    //             res.set(2, max);
    //         }
    //     }
    //     res.add(start);
    //     res.add(end);
    //     res.add(max);
    //     return res;
    // }
}