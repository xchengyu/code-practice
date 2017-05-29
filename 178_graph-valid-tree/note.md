```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/graph-valid-tree
@Language: Markdown
@Datetime: 17-01-16 08:21
```

class UnionFind {
    HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
    public UnionFind(HashSet<Integer> hashset) {
        for (Integer i : hashset) {
            father.put(i, i);
        }
    }
    public int find(int child) {
        int parent = father.get(child); 
        while (parent != father.get(parent)) {
            parent = father.get(parent);
        }
        int tmp = -1;
        int fa = father.get(child);
        father.put(child, parent);
        while (fa != father.get(fa)) {
            tmp = father.get(fa);
            father.put(fa, parent);
            fa = tmp;
        }
        return parent;
    }
    public void union(int x, int y) {
        int fx = father.get(x);
        int fy = father.get(y);
        if (fx != fy) {
            father.put(fx, fy);
        }
        return;
    }
}
public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        if (edges.length != n - 1) {
            return false;
        }
        HashSet<Integer> hashset = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            hashset.add(i);
        }
        UnionFind uf = new UnionFind(hashset);
        int m = edges.length;
        for (int i = 0; i < m; i++) {
            int fx = uf.find(edges[i][0]);
            int fy = uf.find(edges[i][1]);
            if (fx == fy) {
                return false;//有环. 在添加当前edge前就已经有路径将这两点连接在一起了
            } else {
                uf.union(edges[i][0], edges[i][1]);
            }
        }
        return true;
    }
}