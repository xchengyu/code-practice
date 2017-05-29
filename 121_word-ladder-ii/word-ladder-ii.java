/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/word-ladder-ii
@Language: Java
@Datetime: 17-01-10 11:56
*/

public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return a list of lists of string
      */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here
        List<List<String>> ladder = new ArrayList<List<String>>();
        Map<String, List<String>> neighbors = new HashMap<String, List<String>>();
        Map<String, Integer> distance = new HashMap<String, Integer>();
        dict.add(start);
        dict.add(end);
        bfs(start, neighbors, distance, dict);
        dfs(end, start, neighbors, distance, new ArrayList<String>(), ladder);
        return ladder;
    }
    public void bfs(String start, Map<String, List<String>> neighbors, 
        Map<String, Integer> distance, Set<String> dict) {
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        for (String str : dict) {
            neighbors.put(str, new ArrayList<String>());
        }
        int len = 0;
        distance.put(start, len);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            List<String> neighbor = expand(cur, dict);
            neighbors.put(cur, neighbor);
            for (String next : neighbor) {
                if (!distance.containsKey(next)) {
                    queue.offer(next);
                    distance.put(next, distance.get(cur) + 1);
                }
            }
            len++;
        }
        return;
    }
    public List<String> expand(String word, Set<String> dict) {
        List<String> neighbor = new ArrayList<String>();
        for (int i = 0; i < word.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch != word.charAt(i)) {
                    String tmp = word.substring(0, i) + ch + word.substring(i + 1);
                    if (dict.contains(tmp)) {
                        neighbor.add(tmp);
                    }
                }
            }
        }
        return neighbor;
    }
    
    public void dfs(String end, String start, Map<String, List<String>> neighbors, 
    Map<String, Integer> distance, List<String> path, List<List<String>> ladder) {
        path.add(end);
        if (end.equals(start)) {
            Collections.reverse(path);
            ladder.add(new ArrayList<String>(path));
            Collections.reverse(path);
            path.remove(path.size() - 1);
            return;
        }
        for (String next : neighbors.get(end)) {
            if (distance.get(end) - 1 == distance.get(next)) {
                dfs(next, start, neighbors, distance, path, ladder);
            }
        }
        path.remove(path.size() - 1);
        return;
    }
}
// public class Solution {
//     /**
//       * @param start, a string
//       * @param end, a string
//       * @param dict, a set of string
//       * @return a list of lists of string
//       */
//     public List<List<String>> findLadders(String start, String end, Set<String> dict) {
//         // write your code here
//         List<List<String>> ladder = new ArrayList<List<String>>();
//         Map<String, List<String>> neighbors = new HashMap<String, List<String>>();
//         Map<String, Integer> distance = new HashMap<String, Integer>();
//         dict.add(start);
//         dict.add(end);
//         bfs(start, end, neighbors, distance, dict);
//         dfs(end, start, neighbors, distance, new ArrayList<String>(), ladder);
//         return ladder;
//     }
    
//     public void bfs(String start, String end, Map<String, List<String>> neighbors, 
//     Map<String, Integer> distance, Set<String> dict) {
//         Queue<String> queue = new LinkedList<String>();
//         for (String tmp : dict) {
//             neighbors.put(tmp, new ArrayList<String>());
//         }
//         queue.offer(start);
//         distance.put(start, 0);
//         while (!queue.isEmpty()) {
//             String cur = queue.poll();
//             List<String> neighbor = expand(cur, dict);
//             neighbors.put(cur, neighbor);
//             for (String tmp : neighbor) {
//                 if (!distance.containsKey(tmp)) {
//                     distance.put(tmp, distance.get(cur) + 1);
//                     queue.offer(tmp);
//                 }
//             }
//         }
//         return;
//     }
    
//     public List<String> expand(String word, Set<String> dict) {
//         List<String> neighbor = new ArrayList<String>();
//         for (int i = 0; i < word.length(); i++) {
//             for (char ch = 'a'; ch <= 'z'; ch++) {
//                 if (ch != word.charAt(i)) {
//                     String tmp = word.substring(0, i) + ch + word.substring(i + 1);
//                     if (dict.contains(tmp)) {
//                         neighbor.add(tmp);
//                     }
//                 }
//             }
//         }
//         return neighbor;
//     }
    
//     public void dfs(String end, String start, Map<String, List<String>> neighbors, 
//     Map<String, Integer> distance, List<String> path, List<List<String>> ladder) {
//         path.add(end);
//         if (start.equals(end)) {
//             Collections.reverse(path);
//             ladder.add(new ArrayList<String>(path));
//             Collections.reverse(path);
//         } else {
//             for (String next : neighbors.get(end)) {
//                 if (distance.containsKey(next) && distance.get(end) - 1 == distance.get(next)) {
//                     dfs(next, start, neighbors, distance, path, ladder);
//                 }
//             }
//         }
//         path.remove(path.size() - 1);
//         return;
//     }
// }