/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/triangle-count
@Language: Java
@Datetime: 16-07-11 07:00
*/

public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int S[]) {
        // write your code here
        if (S == null || S.length < 3) {
            return 0;
        }
        Arrays.sort(S);
        int res = 0;
        for (int i = S.length - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (S[left] + S[right] > S[i]) {
                    res += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
}
