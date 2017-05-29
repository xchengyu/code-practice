/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/six-degrees
@Language: Java
@Datetime: 17-01-14 10:05
*/

/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph a list of Undirected graph node
     * @param s, t two Undirected graph nodes
     * @return an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph,
                          UndirectedGraphNode s,
                          UndirectedGraphNode t) {
        // Write your code here
        if (s == t) {
            return 0;
        }
        Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(s);
        visited.add(s);
        int len = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode cur = queue.poll();
                if (cur.label == t.label) {
                    return len;
                }
                for (UndirectedGraphNode neighbor : cur.neighbors) {
                    if (visited.contains(neighbor)) {
                        continue;
                    } else {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            len++;
        }
        return -1;
    }
}