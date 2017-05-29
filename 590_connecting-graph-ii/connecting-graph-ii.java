/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/connecting-graph-ii
@Language: Java
@Datetime: 16-12-17 10:31
*/

public class ConnectingGraph2 {
    private int[] father;
    private int[] size;
    public ConnectingGraph2(int n) {
        // initialize your data structure here.
        father = new int[n + 1];
        size = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            father[i] = 0;
            size[i] = 1;
        }
    }
    
    private int find(int a) {
        if (father[a] == 0) {
            return a;
        }
        return father[a] = find(father[a]);
    }
    
    public void connect(int a, int b) {
        // Write your code here
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            father[fb] = fa;
            size[fa] += size[fb];
        }
    }
        
    public int query(int a) {
        // Write your code here
        int fa = find(a);
        return size[fa];
    }
}