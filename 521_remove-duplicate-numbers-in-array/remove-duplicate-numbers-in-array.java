/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/remove-duplicate-numbers-in-array
@Language: Java
@Datetime: 17-02-24 10:00
*/

// public class Solution {
//     /**
//      * @param nums an array of integers
//      * @return the number of unique integers
//      */
//     public int deduplication(int[] nums) {
//         // Write your code here
//         if (nums == null || nums.length == 0) {
//             return 0;
//         }
//         Arrays.sort(nums);
//         int insert = 1;
//         for (int i = 1; i < nums.length; i++) {
//             if (nums[i] != nums[insert - 1]) {
//                 swap(i, insert, nums);
//                 insert++;
//             }
//         }
//         return insert;
//     }
//     public void swap(int a, int b, int[] nums) {
//         int tmp = nums[a];
//         nums[a] = nums[b];
//         nums[b] = tmp;
//     }
// }
public class Solution {
    /**
     * @param nums an array of integers
     * @return the number of unique integers
     */
    public int deduplication(int[] nums) {
        // Write your code here
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; ++i)
            set.add(nums[i]);

        int result = 0;
        for (Integer value : set) {
            nums[result++] = value;
        }
        return result;
    }
}