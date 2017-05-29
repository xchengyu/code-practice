/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/find-minimum-in-rotated-sorted-array-ii
@Language: Java
@Datetime: 16-08-18 06:06
*/

public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        if (num == null || num.length == 0) {
            return 0;
        }
        if(num.length == 1) {
            return num[0];
        }
        int left = 0;
        int right = num.length - 1;
        while (left + 1 < right) {
            if (num[left] == num[right]) {
                left++;
            } else {
                break;
            }
        }
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (num[mid] <= num[right]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return num[left] < num[right] ? num[left] : num[right];
    }
}