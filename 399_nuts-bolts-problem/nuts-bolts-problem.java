/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/nuts-bolts-problem
@Language: Java
@Datetime: 17-01-17 09:12
*/

/**
 * public class NBCompare {
 *     public int cmp(String a, String b);
 * }
 * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
 * if "a" is bigger than "b", it will return 1, else if they are equal,
 * it will return 0, else if "a" is smaller than "b", it will return -1.
 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
*/
public class Solution {
    /**
     * @param nuts: an array of integers
     * @param bolts: an array of integers
     * @param compare: a instance of Comparator
     * @return: nothing
     */
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        // write your code here
        if (nuts == null || nuts.length == 0 || bolts == null || bolts.length == 0) {
            return;
        }
        if (nuts.length != bolts.length) {
            return;
        }
        qsort(nuts, bolts, 0, nuts.length - 1, compare);
        return;
    }
    public void qsort(String[] nuts, String[] bolts, int left, int right, NBComparator compare) {
        if (left >= right) {
            return;
        }
        int pivot_index = partition(nuts, bolts[left], left, right, compare);
        partition(bolts, nuts[pivot_index], left, right, compare);
        qsort(nuts, bolts, left, pivot_index - 1, compare);
        qsort(nuts, bolts, pivot_index + 1, right, compare);
        return;
    }
    public int partition(String[] items, String pivot, int left, int right, NBComparator compare) {
        if (left == right) {
            return left;
        }
        int l = left - 1;
        int r = right + 1;
        int index = left;
        while (index < r) {
            if (compare.cmp(items[index], pivot) == 0 || compare.cmp(pivot, items[index]) == 0) {
                index++;
            } else if (compare.cmp(items[index], pivot) == 1 || compare.cmp(pivot, items[index]) == -1) {
                r--;
                swap(items, index, r);
            } else {
                l++;
                swap(items, index, l);
                index++;
            }
        }
        return r - 1;
    }
    public void swap(String[] items, int i, int j) {
        String tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }
};