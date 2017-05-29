/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/find-minimum-in-rotated-sorted-array
@Language: Java
@Datetime: 16-12-26 10:11
*/

public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                return nums[mid];
            } else if (nums[mid] > nums[left] && nums[mid] > nums[right]) {
                left = mid;
            } else if (nums[mid] < nums[right] && nums[mid] < nums[left]) {
                right = mid;
            } else {
                return nums[left];//no rotate
            }
        }
        return nums[left] < nums[right] ? nums[left] : nums[right];
        // if (nums == null || nums.length == 0) {
        //     return 0;
        // }
        // if(nums.length == 1) {
        //     return nums[0];
        // }
        // int left = 0;
        // int right = nums.length - 1;
        // while (left + 1 < right) {
        //     int mid = left + (right - left) / 2;
        //     if (nums[mid] <= nums[right]) {
        //         right = mid;
        //     } else {
        //         left = mid;
        //     }
        // }
        // return nums[left] < nums[right] ? nums[left] : nums[right];
    }
}
// public class Solution {
//     /**
//      * @param num: a rotated sorted array
//      * @return: the minimum number in the array
//      */
//     public int findMin(int[] num) {
//         // write your code here
//         if (num == null || num.length <= 1) {
//             return 0;
//         }
//         int start = 0;
//         int end = num.length - 1;
//         int mid = 0;
//         while (start < end) {
//             mid = start + (end - start) / 2;
//             if (mid > start && mid < end && num[mid] < num[mid - 1] && num[mid] < num[mid + 1]) {
//                 return num[mid];
//             }
//             if (num[mid] < num[end] && num[mid] < num[start]) {
//                 end = mid;
//             } else if (num[mid] > num[start] && num[mid] > num[end]) {
//                 start = mid + 1;
//             } else if (num[mid] >= num[start] && num[mid] < num[end]) {
//                 return num[start];
//             } else {
//                 return num[end];
//             }
//         }
//         return num[mid];
//     }
// }