```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/word-ladder
@Language: Markdown
@Datetime: 17-01-10 11:11
```

public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        Map<String, List<String>> neighbors = new HashMap<String, List<String>>();
        if (start.equals(end)) {
            return 1;
        }
        dict.add(start);
        dict.add(end);
        bfs(neighbors, start, end, dict);//建neighbor表
        HashSet<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        visited.add(start);
        int length = 1;
        while (!queue.isEmpty()) {
            length++;
            int size = queue.size();//bfs按层遍历
            for (int i = 0; i < size; i++) {
                String tmp = queue.poll();
                for (String neighbor : neighbors.get(tmp)) {
                    if (visited.contains(neighbor)) {
                        continue;
                    } else {
                        if (neighbor.equals(end)) {
                            return length;
                        } else {
                            queue.offer(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
            }
        }

        return 0;
    }
    public void bfs(Map<String, List<String>> neighbors, String start, 
    String end, Set<String> dict) {
        Queue<String> queue = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();
        for(String i : dict) {
            neighbors.put(i, new ArrayList<String>());
        }
        queue.offer(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            String tmp = queue.poll();
            ArrayList<String> res = expand(tmp, dict);
            for (String i : res) {
                neighbors.get(i).add(tmp);
                if (!visited.contains(i)) {
                    visited.add(i);
                    queue.offer(i);
                }
            }
        }
        return;
    }
    
    public ArrayList<String> expand(String cur, Set<String> dict) {
        int len = cur.length();
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < len; i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {//tricky
                if (ch != cur.charAt(i)) {
                    String tmp = cur.substring(0, i) + ch + cur.substring(i + 1);
                    if (dict.contains(tmp)) {
                        list.add(tmp);
                    }
                }
            }
        }
        return list;
    }