/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/remove-duplicates-from-sorted-array
@Language: Java
@Datetime: 17-01-12 10:29
*/

// public class Solution {
//     /**
//      * @param A: a array of integers
//      * @return : return an integer
//      */
//     public int removeDuplicates(int[] nums) {
//         // write your code here
//         if (nums == null) {
//             return 0;
//         }
//         int i,j;
//         int cur = 0;
//         for (i = 0; i < nums.length;) {
//             int now = nums[i];
//             for (j = i; j < nums.length; j++) {
//                 if (nums[j] != now) {
//                     break;
//                 }
//                 if (j == i) {
//                     nums[cur++] = now;
//                 }
//             }
//             i = j;
//         }
//         return cur;
//     }
// }
public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // int len = nums.length;
        // int cur = 0;
        // //int pre = nums[0];
        // for (int i = 0; i < len; i++) {
        //     int j = i;
        //     for ( ; j < len; j++) {
        //         if (j == i) {
        //             nums[cur++] = nums[i];
        //         }
        //         if (nums[j] != nums[i]) {
        //             i = j - 1;
        //             break;
        //         }
        //     }
        //     if (j == len) {
        //         break;
        //     }
        // }
        // return cur;
        int cur = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            nums[cur++] = nums[i];
            int j = i + 1;
            while (j < len && nums[j] == nums[i]) {
                j++;
            }
            if (j == len) {
                break;
            } else {
                i = j - 1;
            }
        }
        return cur;
    }
}