```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/find-the-weak-connected-component-in-the-directed-graph
@Language: Markdown
@Datetime: 17-01-17 08:10
```

class UnionFind {
     public HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
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
     * @param nodes a array of Directed graph node
     * @return a connected set of a directed graph
     */
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        // Write your code here
        HashSet<Integer> hashset = new HashSet<Integer>();
        for (DirectedGraphNode node : nodes) {
            hashset.add(node.label);
            for (DirectedGraphNode neighbor : node.neighbors) {
                hashset.add(neighbor.label);
            }
        }
        UnionFind uf = new UnionFind(hashset);
        for (DirectedGraphNode node : nodes) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                int fnode = uf.find(node.label);
                int fneighbor = uf.find(neighbor.label);
                if (fnode != fneighbor) {
                    uf.union(node.label, neighbor.label);
                }
            }
        }
        return print(hashset, uf, nodes.size());
    }
    public List<List<Integer>> print(HashSet<Integer> hashset, UnionFind uf, int size) {
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (Integer i : hashset) {
            int fa = uf.find(i);
            if (!map.containsKey(fa)) {
                map.put(fa, new ArrayList<Integer>());
            }
            List<Integer> now = map.get(fa);
            now.add(i);
            map.put(fa, now);
        }
        for (List<Integer> part : map.values()) {
            Collections.sort(part);
            res.add(part);
        }
        return res;
    }
}