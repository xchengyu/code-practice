/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/majority-number
@Language: Java
@Datetime: 16-12-27 09:53
*/

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        if (nums == null || nums.size() == 0) {
            return 0;
        }
        Iterator<Integer> iter = nums.iterator();
        int count = 0;
        int res = 0;
        while (iter.hasNext()) {
            int cur = iter.next();
            if (res == cur) {
                count++;
            } else {
                count--;
                if (count < 0) {
                    res = cur;
                    count = 1;
                }
            }
        }
        return res;
    }
}
// public class Solution {
//     /**
//      * @param nums: a list of integers
//      * @return: find a  majority number
//      */
//     public int majorityNumber(ArrayList<Integer> nums) {
//         // write your code
//         if (nums == null || nums.size() == 0) {
//             return 0;
//         }
//         int count = 0;
//         int res = 0;
//         Iterator<Integer> iter = nums.iterator();
//         res = iter.next();
//         count++;
//         while (iter.hasNext()) {
//             int tmp = iter.next();
//             if (tmp == res) {
//                 count++;
//             } else {
//                 count--;
//                 if (count < 0) {
//                     res = tmp;
//                     count = 1;
//                 }
//             }
//         }
//         return res;
//     }
// }