/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/connected-component-in-undirected-graph
@Language: Java
@Datetime: 17-05-26 06:14
*/

/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
class UnionFind {
    Map<Integer, Integer> parents;
    public UnionFind(List<UndirectedGraphNode> nodes) {
        this.parents = new HashMap<Integer, Integer>();
        for (UndirectedGraphNode node : nodes) {
             parents.put(node.label, node.label);
        }
    }
    
    public int find(int a) {
        int father = parents.get(a);
        while (father != parents.get(father)) {
            father = parents.get(father);
        }
        int parent = father;
        father = parents.get(a);
        parents.put(a, parent);
        while (father != parents.get(father)) {
            int tmp = parents.get(father);
            parents.put(father, parent);
            father = tmp;
        }
        return parent;
    }
    
    public void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) {
            parents.put(pa, pb);
        }
        return;
    }
    
    public List<List<Integer>> getResult() {
        Map<Integer, List<Integer>> component = new HashMap<Integer, List<Integer>>();
        for (Map.Entry<Integer, Integer> entry : parents.entrySet()) {
            int child = entry.getKey();
            int father = find(child);
            if (!component.containsKey(father)) {
                component.put(father, new ArrayList<Integer>());
            }
            component.get(father).add(child);
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (Map.Entry<Integer, List<Integer>> entry : component.entrySet()) {
            Collections.sort(entry.getValue());
            result.add(entry.getValue());
        }
        return result;
    }
}
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        if (nodes == null || nodes.size() == 0) {
            return new ArrayList<List<Integer>>();
        }
        UnionFind uf = new UnionFind(nodes);
        for (UndirectedGraphNode node : nodes) {
            for (UndirectedGraphNode neighbor : node.neighbors) {
                uf.union(node.label, neighbor.label);
            }
        }
        return uf.getResult();
    }
}