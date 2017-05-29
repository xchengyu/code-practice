```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/heapify
@Language: Markdown
@Datetime: 17-01-25 06:29
```

public void heapify(int[] A) {
        // write your code here
        if (A == null || A.length < 2) {
            return;
        }
        for (int i = A.length / 2; i >= 0; i--) {
            siftdown(A, i);
        }
    }
    public void siftdown(int[] A, int k) {
        while (k < A.length) {//如果root比子节点大，则将root与子节点对换位置，再次检测新的子节点是否比它的子节点大，如果大，则还要继续对换位置，直至当前root节点比其子节点小为止
            int small = k;
            if (2 * k + 1 < A.length && A[2 * k + 1] < A[small]) {
                small = 2 * k + 1;
            }
            if (2 * k + 2 < A.length && A[2 * k + 2] < A[small]) {
                small = 2 * k + 2;
            }//不用else if是为了从root两个子节点中选取最小的节点，将其与root位置对调
            if (small == k) {//root就是最小的
                break;
            }
            int tmp = A[small];
            A[small] = A[k];
            A[k] = tmp;
            k = small;
        }
        return;
    }