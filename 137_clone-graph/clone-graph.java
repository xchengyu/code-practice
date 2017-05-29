/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/clone-graph
@Language: Java
@Datetime: 17-01-24 09:28
*/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) {
            return null;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> nodes = 
                        new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            if (!nodes.containsKey(cur)) {
                nodes.put(cur, new UndirectedGraphNode(cur.label));
            }
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                if (!nodes.containsKey(neighbor)) {
                    queue.offer(neighbor);
                }
            }
        }
        queue.offer(node);
        Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        visited.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            UndirectedGraphNode newCur = nodes.get(cur);
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                newCur.neighbors.add(nodes.get(neighbor));
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return nodes.get(node);
    }
}