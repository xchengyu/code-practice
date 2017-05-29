/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/search-graph-nodes
@Language: Java
@Datetime: 17-01-22 09:00
*/

/**
 * Definition for graph node.
 * class GraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph a list of Undirected graph node
     * @param values a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node an Undirected graph node
     * @param target an integer
     * @return the a node
     */
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        // Write your code here
        if (graph == null || graph.size() == 0 || node == null || values == null || values.size() == 0) {
            return null;
        }
        Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode cur = queue.poll();
                if (values.get(cur) == target) {
                    return cur;
                }
                for (UndirectedGraphNode neighbor : cur.neighbors) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                    }
                }
                visited.add(cur);
            }
        }
        return null;
    }
}