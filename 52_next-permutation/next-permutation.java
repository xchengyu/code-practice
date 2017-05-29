/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/next-permutation
@Language: Java
@Datetime: 16-12-28 09:36
*/

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
    public int[] nextPermutation(int[] nums) {
        // write your code here
        if (nums == null || nums.length < 2) {
            return nums;
        }
        boolean found = false;
        int index = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                found = true;
                index = i;
                break;
            }
        }
        if (!found) {
            reverse(nums, 0, nums.length - 1);
            return nums;
        }
        int invertedIndex = 0;
        for (int i = nums.length - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                invertedIndex = i;
                break;
            }
        }
        swap(nums, index, invertedIndex);
        reverse(nums, index + 1, nums.length - 1);
        return nums;
    }
    
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
    
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
// public class Solution {
//     /**
//      * @param nums: an array of integers
//      * @return: return nothing (void), do not return anything, modify nums in-place instead
//      */
//     public int[] nextPermutation(int[] nums) {
//         // write your code here
//         if (nums == null || nums.length < 2) {
//             return nums;
//         }
//         boolean found = false;
//         int index = 0;
//         for (int i = nums.length - 2; i >= 0; i--) {
//             if (nums[i] < nums[i + 1]) {
//                 found = true;
//                 index = i;
//                 break;
//             }
//         }
//         if (!found) {
//             reverse(nums, 0, nums.length - 1);
//             return nums;
//         }
//         int invertIndex = 0;
//         for (int i = nums.length - 1; i > index; i--) {
//             if (nums[i] > nums[index]) {
//                 invertIndex = i;
//                 break;
//             }
//         }
//         swap(nums, index, invertIndex);
//         reverse(nums, index + 1, nums.length - 1);
//         return nums;
//     }
//     public void swap(int[] nums, int i, int j) {
//         int tmp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = tmp;
//         return;
//     }
    
//     public void reverse(int[] nums, int left, int right) {
//         while (left < right) {
//             swap(nums, left, right);
//             left++;
//             right--;
//         }
//         return;
//     }
// }