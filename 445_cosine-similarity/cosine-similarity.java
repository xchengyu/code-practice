/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/cosine-similarity
@Language: Java
@Datetime: 16-07-28 05:47
*/

class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: Cosine similarity.
     */
    public double cosineSimilarity(int[] A, int[] B) {
        // write your code here
        int dividor = 0;
        for (int i = 0; i < A.length; i++) {
            dividor += A[i] * B[i];
        }
        
        int dividenA = 0;
        for (int i = 0; i < A.length; i++) {
            dividenA += A[i] * A[i];
        }
        if (dividenA == 0) {
            return 2;
        }
        
        int dividenB = 0;
        for (int i = 0; i < B.length; i++) {
            dividenB += B[i] * B[i];
        }
        
        if (dividenB == 0) {
            return 2;
        }
        
        return dividor / Math.sqrt(dividenA) /Math.sqrt(dividenB);
    }
}
