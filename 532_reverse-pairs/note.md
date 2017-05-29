```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/reverse-pairs
@Language: Markdown
@Datetime: 17-01-15 07:58
```

public class Solution {
    /**
     * @param A an array
     * @return total of reverse pairs
     */
    public long reversePairs(int[] A) {
        return mergeSort(A, 0, A.length - 1);
    }
    
    private int mergeSort(int[] A, int start, int end) {
        if (start >= end) {
            return 0;
        }
        
        int mid = (start + end) / 2;
        int sum = 0;
        sum += mergeSort(A, start, mid);//merge sort 左半部分，sort的时候统计左半部分的逆序对个数
        sum += mergeSort(A, mid+1, end);//merge sort 右半部分，sort的时候统计右半部分的逆序对个数
        sum += merge(A, start, mid, end);//merge sort整体，此时左右两部分均已是升序序列，sort的时候统计整体的逆序对
        return sum;
    }
    
    private int merge(int[] A, int start, int mid, int end) {
        int[] temp = new int[A.length];
        int leftIndex = start;
        int rightIndex = mid + 1;
        int index = start;
        int sum = 0;
        
        while (leftIndex <= mid && rightIndex <= end) {
            if (A[leftIndex] <= A[rightIndex]) {
                temp[index++] = A[leftIndex++];
            } else {
                temp[index++] = A[rightIndex++];
                sum += mid - leftIndex + 1;//A的左右两部分已是升序序列，所以如果A[leftindex] > A[rightindex],
                //则从A[leftindex]开始到A[mid]的数都比A[rightindex]大
            }
        }
        while (leftIndex <= mid) {
            temp[index++] = A[leftIndex++];
        }
        while (rightIndex <= end) {
            temp[index++] = A[rightIndex++];
        }
        
        for (int i = start; i <= end; i++) {//merge sort
            A[i] = temp[i];
        }
        
        return sum;
    }
}