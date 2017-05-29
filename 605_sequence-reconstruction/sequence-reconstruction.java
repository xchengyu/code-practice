/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/sequence-reconstruction
@Language: Java
@Datetime: 17-01-22 10:24
*/

public class Solution {
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        int len = org.length;
        int[] map = new int[len + 1];//map number to its index
        Arrays.fill(map, -1);
        int[] memo = new int[org.length];//count how many numbers are smaller(on the right)
        for (int i = 0; i < len; i++) {
            map[org[i]] = i;
        }
        for (int[] seq : seqs) {
            if (seq.length == 0) continue;
            int prev = seq[0];
            if (prev <= 0 || prev > len || map[prev] == -1) return false;
            for (int i = 1; i < seq.length; i++) {
                int curr = seq[i];
                if (curr <= 0 || curr > len || map[curr] == -1) return false;
                memo[map[prev]] = Math.max(memo[map[prev]], len - map[curr] + 1);
                prev = curr;
            }
            memo[map[prev]] = Math.max(memo[map[prev]], 1);
        }
        for (int i = 0; i < memo.length; i++) {
            if (memo[i] != len - i) return false;
        }
        return true;
    }
}