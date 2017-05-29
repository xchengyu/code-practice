```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/median-of-two-sorted-arrays
@Language: Markdown
@Datetime: 16-07-04 06:54
```

http://www.cnblogs.com/yuzhangcmu/p/4138184.html
SOLTION 1:

1. 我们借用findKthNumber的思想。先实现findKthNumber，如果是偶数个，则把中间2个加起来平均，奇数就用中间的。

2. 为了达到LOG级的复杂度，我们可以这样：

每次在A，B取前k/2个元素。有以下这些情况：

1).  A的元素不够k/2. 则我们可以丢弃B前k/2. 反之亦然

证明：

我们使用反证法。

假设第K大在B的前k/2中，例如位置在索引m(m <= k/2-1)那么A必然拥有前k中的k -(m+1)个元素，而

m <= k/2-1,则 m+1 <= k/2  , k - (m+1) > k/2与条件：A的元素不够k/2矛盾，所以假设不成立，得证。

举个栗子：

A: 6 7 8

B: 1 2 3 4 5

找第8大的数字，

2). A[mid] < B[mid] (mid是k/2 -1索引处的元素）。

这种情况下，我们可以丢弃A前k/2。

证明：

我们使用反证法。

假设第K大在A的前k/2中记为maxK，例如位置在索引m(m <= k/2-1)那么B必然拥有前k中的k -(m+1)个元素，而

m <= k/2-1,则 m+1 <= k/2  , k - (m+1) > k/2

推出B[mid] <= maxK

而A[mid] >= maxK 推出 A[mid]>=B[mid], 与题设矛盾。所以假设不能成立。

举个栗子：

A: 1 2

B: 4 5 6 7 8

找第四大的数字 我们就可以首先排除1，2.
class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int len = A.length + B.length;
        if (len % 2 == 1) {
            return findKth(A, 0, B, 0, len / 2 + 1);
        } else {
            return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0;
        }
    }
    public double findKth(int[] A, int A_start, int[] B, int B_start, int k) {
        if (A_start >= A.length) {
            return B[B_start + k - 1];
        }
        if (B_start >= B.length) {
            return A[A_start + k - 1];
        }
        if (k == 1) {
            return Math.min(A[A_start], B[B_start]);
        }
        int A_mid = A_start + k / 2 - 1 < A.length ? A[A_start + k / 2 - 1] : Integer.MAX_VALUE;
        int B_mid = B_start + k / 2 - 1 < B.length ? B[B_start + k / 2 - 1] : Integer.MAX_VALUE;
        if (A_mid < B_mid) {
            return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
        } else {
            return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
        }
    }
}