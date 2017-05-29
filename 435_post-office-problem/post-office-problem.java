/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/post-office-problem
@Language: Java
@Datetime: 16-07-20 05:30
*/

public class Solution {
    /**
     * @param A an integer array
     * @param k an integer
     * @return an integer
     */
    public int postOffice(int[] A, int k) {
        // Write your code here
        int n = A.length;
        Arrays.sort(A);//test case中A数组可能是无序数组
        int[][] dis = init(A);
        int[][] dp = new int[n + 1][k + 1];//前n个村子建k个邮局的总距离
        if (n == 0 || k >= n) {
            return 0;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[i][1] = dis[1][i];
        }
        
        for(int nk = 2; nk <= k; nk++) {//建2到k个邮局
            for(int i = nk; i <= n; i++) {//i < nk的时候总距离为0。因为可以在每个村落建个邮局
                dp[i][nk] = Integer.MAX_VALUE;
                for(int j = 0; j < i; j++) {  
                    if(dp[i][nk] == Integer.MAX_VALUE || dp[i][nk] > dp[j][nk-1] + dis[j+1][i]) //前j个村落建nk-1个邮局，从第j+1个邮局到第i个邮局建一个邮局的总距离 
                        dp[i][nk] = dp[j][nk-1] + dis[j+1][i];   
                }  
            }
        }
        return dp[n][k];
    }
    public int[][] init(int[] A) {
        int n = A.length;
        int[][] dis = new int[n + 1][n + 1];
        //在村落i到村落j间建一个邮局的最短总距离，这个邮局一定是建在处在中间位置的村落（可以数学证明）
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int mid = i + (j - i) / 2;
                for (int k = i; k <= j; k++) {
                    dis[i][j] += Math.abs(A[mid - 1] - A[k - 1]);
                }
            }
        }
        return dis;
    }
}