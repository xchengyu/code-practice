/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/single-number-iii
@Language: Java
@Datetime: 16-07-23 06:29
*/

public class Solution {
    /**
     * @param A : An integer array
     * @return : Two integers
     */
    public List<Integer> singleNumberIII(int[] A) {
        // write your code here
        int xor = 0;
        for (int i = 0; i < A.length; i++) {
            xor ^= A[i];
        }//此时xor = elem1 ^ elem2; xor中为1的位表示elem1 and elem2 are different at this bit.
        xor = xor - (xor & (xor - 1));//find the last "1" bit
        int group1 = 0;
        int group2 = 0;
        for (int i = 0; i < A.length; i++) {
            if ((A[i] & xor) == 0) {//use this 1 bit to divide the A into two group, one group contains elements which are 0 at this bit, another group contains elements which are 1 at this bit
                group1 ^= A[i];
            } else {
                group2 ^= A[i];
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        res.add(group1);
        res.add(group2);
        return res;
    }
}