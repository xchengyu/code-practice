```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/clone-graph
@Language: Markdown
@Datetime: 17-01-24 09:28
```

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
        HashMap<UndirectedGraphNode, UndirectedGraphNode> allNodes = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> oldQueue = new LinkedList<UndirectedGraphNode>();
        oldQueue.offer(node);
        allNodes.put(node, new UndirectedGraphNode(node.label));
        while (!oldQueue.isEmpty()) {
            UndirectedGraphNode tmp = oldQueue.poll();
            for (UndirectedGraphNode neighbor : tmp.neighbors) {
                if (allNodes.containsKey(neighbor)) {
                    continue;
                } else {
                    oldQueue.offer(neighbor);
                    allNodes.put(neighbor, new UndirectedGraphNode(neighbor.label));
                }
            }
        }
        Queue<UndirectedGraphNode> newQueue = new LinkedList<UndirectedGraphNode>();
        newQueue.offer(node);
        HashSet<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        while (!newQueue.isEmpty()) {
            UndirectedGraphNode tmp = newQueue.poll();
            if (visited.contains(tmp)) {
                continue;
            } else {
                UndirectedGraphNode newNode = allNodes.get(tmp);
                for (UndirectedGraphNode neighbor : tmp.neighbors) {
                    newNode.neighbors.add(allNodes.get(neighbor));
                    newQueue.offer(neighbor);
                }
                visited.add(tmp);
            }
        }
        return allNodes.get(node);
    }
}