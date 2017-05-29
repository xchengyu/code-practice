```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/six-degrees
@Language: Markdown
@Datetime: 17-01-14 10:05
```

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
        Map<UndirectedGraphNode, Integer> map = new HashMap<UndirectedGraphNode, Integer>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        map.put(s, 0);
        queue.offer(s);
        while (!queue.isEmpty()) {
            UndirectedGraphNode node = queue.poll();
            int step = map.get(node);
            for (UndirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor)) {
                    continue;
                } else {
                    map.put(neighbor, step + 1);
                    queue.offer(neighbor);
                    if (neighbor == t) {
                        return step + 1;
                    }
                }
            }
        }
        return -1;
    }
}