/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/find-the-weak-connected-component-in-the-directed-graph
@Language: Java
@Datetime: 17-01-17 08:10
*/

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
class UnionFind {
    public Map<Integer, Integer> fathers;
    public UnionFind(Set<Integer> set) {
        fathers = new HashMap<Integer, Integer>();
        for (Integer num : set) {
            if (fathers.containsKey(num)) {
                continue;
            } else {
                fathers.put(num, num);
            }
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
     * @param nodes a array of Directed graph node
     * @return a connected set of a directed graph
     */
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nodes == null || nodes.size() == 0) {
            return res;
        }
        Set<Integer> set = new HashSet<Integer>();
        for (DirectedGraphNode node : nodes) {
            set.add(node.label);
        }
        UnionFind uf = new UnionFind(set);
        for (DirectedGraphNode node : nodes) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                uf.union(node.label, neighbor.label);
            }
        }
        print(res, uf, set);
        return res;
    }
    public void print(List<List<Integer>> res, UnionFind uf, Set<Integer> set) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (Integer num : set) {
            int father = uf.find(num);
            if (!map.containsKey(father)) {
                map.put(father, new ArrayList<Integer>());
            }
            map.get(father).add(num);
        }
        for (List<Integer> component : map.values()) {
            Collections.sort(component);
            res.add(component);
        }
        return;
    }
}