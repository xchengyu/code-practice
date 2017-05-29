/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/connecting-graph-iii
@Language: Java
@Datetime: 16-12-17 10:36
*/

public class ConnectingGraph3 {
    private int[] father = null;
    private int num;
    public ConnectingGraph3(int n) {
        // initialize your data structure here.
        father = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            father[i] = 0;
        }
        num = n;
    }

    public int find(int a) {
        if (father[a] == 0) {
            return a;
        }
        father[a] = find(father[a]);
        return father[a];
    }
    
    public void connect(int a, int b) {
        // Write your code here
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            father[fa] = fb;
            num--;
        }
    }
        
    public int query() {
        // Write your code here
        return num;
    }
}