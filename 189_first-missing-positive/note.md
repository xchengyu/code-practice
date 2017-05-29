```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/first-missing-positive
@Language: Markdown
@Datetime: 17-01-18 07:13
```

各种corner case。
A【i】为负数，A【i】为0， A【i】比A.length大。
两数交换后，要重新检查当前位置的值
public class Solution {
    /**    
     * @param A: an array of integers
     * @return: an integer
     */
    public int firstMissingPositive(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 1;
        }
        int index = 0;
        while (index < A.length) {
            if (A[index] == index + 1) {
                index++;
            } else {
                int tmpIndex = A[index] - 1;
                if (tmpIndex < 0 || tmpIndex >= A.length) {
                    index++;
                } else {
                    if (A[tmpIndex] != tmpIndex + 1) {
                        swap(A, index, tmpIndex);
                    } else {
                        index++;
                    }
                }
            }
        }
        int res = A.length + 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                res = i + 1;
                break;
            }
        }
        return res;
    }
    
    private void swap(int[] A, int index_a, int index_b) {
        int tmp = A[index_a];
        A[index_a] = A[index_b];
        A[index_b] = tmp;
    }
}