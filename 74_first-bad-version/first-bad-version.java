/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/first-bad-version
@Language: Java
@Datetime: 16-06-27 05:41
*/

/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        if (n <= 1) {
            return 1;
        }
        int start = 1;
        int end = n;
        while (n > 0) {
            if (SVNRepo.isBadVersion(n)) {
                end = n;
                n >>= 1;
            } else {
                start = n + 1;
                break;
            }
        }
        int mid = 1;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (SVNRepo.isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
