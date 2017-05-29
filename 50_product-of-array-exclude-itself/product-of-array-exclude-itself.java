/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/product-of-array-exclude-itself
@Language: Java
@Datetime: 16-08-07 05:26
*/

public class Solution {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
        // ArrayList<Long> res = new ArrayList<Long>();
        // if (A == null || A.size() == 0) {
        //     return res;
        // }
        // Long[] product = new Long[A.size()];
        // product[product.length - 1] = Long.valueOf(1);
        // for (int i = product.length - 2; i >= 0; i--) {
        //     product[i] = product[i + 1] * Long.valueOf(A.get(i + 1));
        // }
        // Long tmp = Long.valueOf(A.get(0));
        // res.add(product[0]);
        // for (int i = 1; i < A.size(); i++) {
        //     Long ans = tmp * product[i];
        //     res.add(ans);
        //     tmp *= Long.valueOf(A.get(i));
        // }
        // return res;
        ArrayList<Long> res = new ArrayList<Long>();
        if (A == null || A.size() == 0) {
            return res;
        }
        Long[] forth = new Long[A.size() + 1];
        forth[0] = Long.valueOf(1);
        forth[1] = Long.valueOf(1);

        for (int i = 2; i < forth.length; i++) {
            forth[i] = forth[i - 1] * Long.valueOf(A.get(i - 2));
        }
        Long[] back = new Long[A.size() + 1];
        back[back.length - 1] = Long.valueOf(1);
        back[back.length - 2] = Long.valueOf(1);
        for (int i = back.length - 3; i >= 0; i--) {
            back[i] = back[i + 1] * Long.valueOf(A.get(i + 1));
        }
        for (int i = 0; i < back.length - 1; i++) {
            res.add(back[i] * forth[i + 1]);
        }
        return res;
    }
}
