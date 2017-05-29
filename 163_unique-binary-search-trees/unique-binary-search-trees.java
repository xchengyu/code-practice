/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/unique-binary-search-trees
@Language: Java
@Datetime: 16-12-27 07:34
*/

public class Solution {
    /**
     * @paramn n: An integer
     * @return: An integer
     */
    public int numTrees(int n) {
        // write your code here
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j <= i - 1; j++) {
                res[i] += res[j] * res[i - j - 1];
            }
        }
        return res[n];
    }
}
// public class Solution {
//     /**
//      * @paramn n: An integer
//      * @return: An integer
//      */
//     public int numTrees(int n) {
//         // write your code here
//         if (n <= 0) {
//             return 1;
//         }
//         if (n == 1) {
//             return 1;
//         }
//         int[] res = new int[n + 1];
//         res[0] = 1;
//         res[1] = 1;
//         for (int i = 2; i < n + 1; i++) {
//             for (int j = 0; j <= i - 1; j++) {
//                 res[i] += res[j] * res[i - j - 1];
//             }
//         }
//         return res[n];
//     }
// }