/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/partition-array
@Language: Java
@Datetime: 16-12-25 10:25
*/

public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    //write your code here
	    if (nums == null || nums.length < 2) {
	        return 0;
	    }
	    int left = -1;
	    int right = nums.length;
	    int index = 0;
	    while (index < right) {
	        if (nums[index] < k) {
	            left++;
	            swap(nums, index, left);
	            index++;
	        } else if (nums[index] > k) {
	            right--;
	            swap(nums, index, right);
	        } else {
	            index++;
	        }
	    }
	    return left + 1;
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        return;
    }
}
// public class Solution {
// 	/** 
//      *@param nums: The integer array you should partition
//      *@param k: As description
//      *return: The index after partition
//      */
//     public int partitionArray(int[] nums, int k) {
// 	    //write your code here
// 	    if (nums == null || nums.length < 2) {
//             return 0;
//         }
//         // int front = 0;
//         // int last = nums.length - 1;
//         // int i = 0;
//         // while (i <= last) {
//         //     if (nums[i] < k) {
//         //         int tmp = nums[i];
//         //         nums[i] = nums[front];
//         //         nums[front] = tmp;
//         //         i++;
//         //         front++;
//         //     } else if (nums[i] == k) {
//         //         i++;
//         //     } else {
//         //         int tmp = nums[i];
//         //         nums[i] = nums[last];
//         //         nums[last] = tmp;
//         //         last--;
//         //     }
//         // }
//         // return front;
//         int left = -1;
//         int right = nums.length;
//         int index = 0;
//         while (index < right) {
//             if (nums[index] < k) {
//                 left++;
//                 swap(nums, index, left);
//                 index++;
//             } else if (nums[index] == k) {
//                 index++;
//             } else {
//                 right--;
//                 swap(nums, index, right);
//             }
//         }
//         return left + 1;
//     }
//     public void swap(int[] nums, int i, int j) {
//         int tmp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = tmp;
//         return;
//     }
// }