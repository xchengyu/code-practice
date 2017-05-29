/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/graph-valid-tree
@Language: Java
@Datetime: 17-01-16 08:21
*/

class UnionFind {
    public Map<Integer, Integer> fathers;
    public UnionFind(Set<Integer> set) {
        this.fathers = new HashMap<Integer, Integer>();
        for (Integer num : set) {
            fathers.put(num, num);
        }
    }
    
    public int find(int x) {
        int father = fathers.get(x);
        while (father != fathers.get(father)) {
            father = fathers.get(father);
        }
        int parent = father;
        father = fathers.get(x);
        fathers.put(x, parent);
        while (father != fathers.get(father)) {
            int tmp = fathers.get(father);
            fathers.put(father, parent);
            father = tmp;
        }
        return parent;
    }
    
    public void union(int x, int y) {
        int fa_x = find(x);
        int fa_y = find(y);
        if (fa_x != fa_y) {
            fathers.put(fa_x, fa_y);
        }
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
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            set.add(i);
        }
        UnionFind uf = new UnionFind(set);
        for (int i = 0; i < edges.length; i++) {
            int fa_0 = uf.find(edges[i][0]);
            int fa_1 = uf.find(edges[i][1]);
            if (fa_0 == fa_1) {
                return false;
            } else {
                uf.union(fa_0, fa_1);
            }
        }
        return true;
    }
}