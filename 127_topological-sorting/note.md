```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/topological-sorting
@Language: Markdown
@Datetime: 17-05-26 07:13
```

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
    //method 1 bfs
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
        Map<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    map.put(neighbor, 1);
                }
            }
        }
        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                q.offer(node);
                res.add(node);
            }
        }
        while (!q.isEmpty()) {
            DirectedGraphNode node = q.poll();
            for (DirectedGraphNode neighbor : node.neighbors) {
                map.put(neighbor, map.get(neighbor) - 1);
                if (map.get(neighbor) == 0) {
                    q.offer(neighbor);
                    res.add(neighbor);
                }
            }
        }
        return res;
    }
    //method 2 dfs
    // public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
    //     // write your code here
    //     ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
    //     Map<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
    //     for (DirectedGraphNode node : graph) {
    //         for (DirectedGraphNode neighbor : node.neighbors) {
    //             if (map.containsKey(neighbor)) {
    //                 map.put(neighbor, map.get(neighbor) + 1);
    //             } else {
    //                 map.put(neighbor, 1);
    //             }
    //         }
    //     }
    //     Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
    //     for (DirectedGraphNode node : graph) {
    //         if (!map.containsKey(node)) {
    //             q.offer(node);
    //             res.add(node);
    //             while (!q.isEmpty()) {
    //                 DirectedGraphNode n = q.poll();
    //                 for (DirectedGraphNode neighbor : n.neighbors) {
    //                     map.put(neighbor, map.get(neighbor) - 1);
    //                     if (map.get(neighbor) == 0) {
    //                         q.offer(neighbor);
    //                         res.add(neighbor);
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     return res;
    // }
}