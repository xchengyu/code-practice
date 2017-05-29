/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/topological-sorting
@Language: Java
@Datetime: 17-05-26 07:13
*/

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        if (graph == null || graph.size() == 0) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor.label)) {
                    map.put(neighbor.label, map.get(neighbor.label) + 1);
                } else {
                    map.put(neighbor.label, 1);
                }
            }
        }
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node.label)) {
                queue.offer(node);
            }
        }
        while (!queue.isEmpty()) {
            DirectedGraphNode cur = queue.poll();
            result.add(cur);
            for (DirectedGraphNode neighbor : cur.neighbors) {
                if (map.get(neighbor.label) == 1) {
                    queue.offer(neighbor);
                } else {
                    map.put(neighbor.label, map.get(neighbor.label) - 1);
                }
            }
        }
        return result;
    }
}