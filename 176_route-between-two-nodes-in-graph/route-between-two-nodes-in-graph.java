/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/route-between-two-nodes-in-graph
@Language: Java
@Datetime: 16-07-30 09:41
*/

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * };
 */
public class Solution {
   /**
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, 
                            DirectedGraphNode s, DirectedGraphNode t) {
        // write your code here
        if (s == t) {
            return true;
        }
        HashSet<DirectedGraphNode> visit = new HashSet<DirectedGraphNode>();
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        queue.offer(s);
        while (!queue.isEmpty()) {
            DirectedGraphNode tmp = queue.poll();
            for (DirectedGraphNode neighbor : tmp.neighbors) {
                if (neighbor == t) {
                    return true;
                }
                if (visit.contains(neighbor)) {
                    continue;
                } else {
                    queue.offer(neighbor);
                    visit.add(neighbor);
                }
            }
        }
        return false;
    }
}