/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/search-in-a-big-sorted-array
@Language: Java
@Datetime: 16-06-27 03:42
*/

/**
 * Definition of ArrayReader:
 * 
 * class ArrayReader {
 *      // get the number at index, return -1 if index is less than zero.
 *      public int get(int index);
 * }
 */
public class Solution {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        if (reader.get(0) == target) {
            return 0;
        }
        int cur = 1;
        int pre = 1;
        while (true) {
            if (reader.get(cur) == target) {
                while (cur - 1 >= 0) {
                    if (reader.get(cur - 1) == target) {
                        cur--;
                    } else {
                        break;
                    }
                }
                return cur;
            } else if (reader.get(cur) > target) {
                break;
            } else {
                pre = cur;
                cur <<= 1;
            }
        }
        while (pre <= cur) {
            int mid = pre + (cur - pre) / 2;
            if (reader.get(mid) == target) {
                while (mid - 1 >= 0) {
                    if (reader.get(mid - 1) == target) {
                        mid--;
                    } else {
                        break;
                    }
                }
                return mid;
            } else if (reader.get(mid) < target) {
                pre = mid + 1;
            } else {
                cur = mid - 1;
            }
        }
        return -1;
    }
}