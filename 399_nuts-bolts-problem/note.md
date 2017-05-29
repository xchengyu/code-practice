```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/nuts-bolts-problem
@Language: Markdown
@Datetime: 17-01-17 09:12
```

public class Solution {
    /**
     * @param nuts: an array of integers
     * @param bolts: an array of integers
     * @param compare: a instance of Comparator
     * @return: nothing
     */
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        if (nuts == null || bolts == null) return;
        if (nuts.length != bolts.length) return;

        qsort(nuts, bolts, compare, 0, nuts.length - 1);
    }

    private void qsort(String[] nuts, String[] bolts, NBComparator compare, 
                       int l, int u) {
        if (l >= u) return;
        // find the partition index for nuts with bolts[l]
        int part_inx = partition(nuts, bolts[l], compare, l, u);
        // partition bolts with nuts[part_inx]
        partition(bolts, nuts[part_inx], compare, l, u);
        // qsort recursively
        qsort(nuts, bolts, compare, l, part_inx - 1);
        qsort(nuts, bolts, compare, part_inx + 1, u);
    }
    private int partition(String[] str, String pivot, NBComparator compare, 
                          int l, int u) {
        // first partition method
        // int left = l; 
        // int right = u;
        // while (left < right) {
        //     while (left < right && 
        //     (compare.cmp(str[right], pivot) == -1 || 
        //     compare.cmp(pivot, str[right]) == 1)) {
        //         right--;
        //     }
            
        //     while (left < right && 
        //     (compare.cmp(str[left], pivot) == 1 || 
        //     compare.cmp(pivot, str[left]) == -1)) {
        //         left++;
        //     }

        //     if (left < right) {
        //         swap(str, left, right);
        //     }
        // }
        ////////////////////////////////////////////////////////////////////////////
        //second partition method which is my favorite methid 
        int left = l; 
        int right = u;
        int index = l;
        while (index <= right) {
            if(compare.cmp(str[index], pivot) == 1 || compare.cmp(pivot, str[index]) == -1) {
               swap(str, index, right);
               right--;
            } else if(compare.cmp(str[index], pivot) == 0 || compare.cmp(pivot, str[index]) == 0) {
                index++;
            } else{
                swap(str, index, left);
                left++;
                index++;
            }
        }
        return left;
    }

    private void swap(String[] str, int l, int r) {
        String temp = str[l];
        str[l] = str[r];
        str[r] = temp;
    }
};