```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/connected-component-in-undirected-graph
@Language: Markdown
@Datetime: 17-05-26 06:14
```

public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        for (UndirectedGraphNode node : nodes) {
            if (visited.contains(node)) {
                continue;
            } else {
                Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
                List<Integer> component = new ArrayList<Integer>();
                queue.offer(node);
                while (!queue.isEmpty()) {
                    UndirectedGraphNode cur = queue.poll();
                    if (visited.contains(cur)) {
                        continue;
                    } else {
                        component.add(cur.label);
                        for (UndirectedGraphNode neighbor : cur.neighbors) {
                            if (visited.contains(neighbor)) {
                                continue;
                            } else {
                                queue.offer(neighbor);
                            }
                        }
                    }
                    visited.add(cur);
                }
                Collections.sort(component);
                res.add(component);
            }
        }
        return res;
    }
}
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List&lt;List&lt;Integer&gt;&gt; connectedSet(ArrayList&lt;UndirectedGraphNode&gt; nodes) {
        // Write your code here
        Map&lt;UndirectedGraphNode, Boolean&gt; visit = new HashMap&lt;UndirectedGraphNode, Boolean&gt;();
        List&lt;List&lt;Integer&gt;&gt; res = new ArrayList&lt;List&lt;Integer&gt;&gt;();
        for (UndirectedGraphNode node : nodes) {
            visit.put(node, false);
        }
        for (UndirectedGraphNode node : nodes) {
            if (visit.get(node) == false) {
                bfs(node, visit, res);
            }
        }
        return res;
    }
    public void bfs(UndirectedGraphNode node, Map&lt;UndirectedGraphNode, Boolean&gt; visit, List&lt;List&lt;Integer&gt;&gt; res) {
        Queue&lt;UndirectedGraphNode&gt; queue = new LinkedList&lt;UndirectedGraphNode&gt;();
        List&lt;Integer&gt; part = new ArrayList&lt;Integer&gt;();
        queue.offer(node);
        visit.put(node, true);
        while (!queue.isEmpty()) {
            UndirectedGraphNode tmp = queue.poll();
            part.add(tmp.label);
            for (UndirectedGraphNode neighbor : tmp.neighbors) {
                if (visit.get(neighbor) == false) {
                    queue.offer(neighbor);
                    visit.put(neighbor, true);
                }
            }
        }
        Collections.sort(part);
        res.add(part);
        return;
    }
}