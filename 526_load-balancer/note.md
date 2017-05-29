```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/load-balancer
@Language: Markdown
@Datetime: 17-05-12 09:43
```

public class LoadBalancer {
    private Map<Integer, Integer> dict;
    private List<Integer> cluster;
    public LoadBalancer() {
        // Initialize your data structure here.
        dict = new HashMap<Integer, Integer>();
        cluster = new ArrayList<Integer>();
    }

    // @param server_id add a new server to the cluster 
    // @return void
    public void add(int server_id) {
        // Write your code here
        int size = cluster.size();
        dict.put(server_id, size);
        cluster.add(server_id);
    }

    // @param server_id server_id remove a bad server from the cluster
    // @return void
    public void remove(int server_id) {
        // Write your code here
        int index = dict.get(server_id);
        int lastId = cluster.get(cluster.size() - 1);
        dict.put(lastId, index);
        cluster.set(index, lastId);
        cluster.remove(cluster.size() - 1);
        dict.remove(server_id);
    }

    // @return pick a server in the cluster randomly with equal probability
    public int pick() {
        // Write your code here
        Random rd = new Random();
        int size = cluster.size();
        int index = Math.abs(rd.nextInt(size));
        return cluster.get(index);
    } 
}