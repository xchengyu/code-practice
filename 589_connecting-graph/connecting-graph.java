/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/connecting-graph
@Language: Java
@Datetime: 17-01-13 08:02
*/

public class ConnectingGraph { 
    public int[] father = null;
    public ConnectingGraph(int n) {
        // initialize your data structure here.
        father = new int[n + 1];
        Arrays.fill(father, 0);
    }

    public void connect(int a, int b) {
        // Write your code here
        int root_a = find(a);
        int root_b = find(b);
        if (root_a != root_b) {
            father[root_a] = root_b;
        }
    }
        
    public boolean  query(int a, int b) {
        // Write your code here
        int root_a = find(a);
        int root_b = find(b);
        return root_a == root_b;
    }
    
    private int find(int x) {
        if (father[x] == 0) {
            return x;
        }
        return find(father[x]);
    }
}