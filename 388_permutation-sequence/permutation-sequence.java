/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/permutation-sequence
@Language: Java
@Datetime: 17-01-18 08:25
*/

class Solution {
    /**
      * @param n: n
      * @param k: the kth permutation
      * @return: return the k-th permutation
      */
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int factor = 1;
        for (int i = 1; i <= n - 1; i++) {
            factor *= i;
        }
        boolean[] used = new boolean[n];
        k = k - 1;
        for (int i = n - 1; i >= 0; i--) {
            int rank = k / factor;
            for (int j = 0; j < n; j++) {
                if (used[j] == false) {
                    if (rank == 0) {
                        sb.append(j + 1);
                        used[j] = true;
                        break;
                    } else {
                        rank--;
                    }
                }
            }
            k = k % factor;
            if (i != 0) {
                factor = factor / i;
            }
        }
        return sb.toString();
    }
}
