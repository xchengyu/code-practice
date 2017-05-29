/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/guess-number-game
@Language: Java
@Datetime: 17-05-12 09:47
*/

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    /**
     * @param n an integer
     * @return the number you guess
     */
    public int guessNumber(int n) {
        // Write your code here
        int start = 1;
        int end = n;
        int mid = start + (end - start) / 2;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            int result = guess(mid);
            if (result == 1) {
                start = mid;
            } else if (result == 0) {
                return mid;
            } else {
                end = mid;
            }
        }
        return guess(start) == 0 ? start : end;
    }
}