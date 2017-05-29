/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/word-ladder
@Language: Java
@Datetime: 17-01-10 11:11
*/

public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (start.equals(end)) {
            return 1;
        }
        if (dict.size() == 0) {
            return 0;
        }
        Map<String, List<String>> neighbors = new HashMap<String, List<String>>();
        dict.add(start);
        dict.add(end);
        buildNeighbor(start, dict, neighbors);
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        queue.offer(start);
        int distance = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if (str.equals(end)) {
                    return distance;
                } else {
                    List<String> neighbor = neighbors.get(str);
                    for (String cur : neighbor) {
                        if (!visited.contains(cur)) {
                            queue.offer(cur);
                        }
                    }
                }
                visited.add(str);
            }
            distance++;
        }
        return 0;
    }
    
    private void buildNeighbor(String start, Set<String> dict, Map<String, List<String>> neighbors) {
        for (String str : dict) {
            neighbors.put(str, new ArrayList<String>());
        }
        Queue<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        queue.offer(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            String str = queue.poll();
            List<String> neighbor = expand(dict, str);
            for (String cur : neighbor) {
                if (!visited.contains(cur)) {
                    queue.offer(cur);
                    visited.add(cur);
                }
                neighbors.get(str).add(cur);
            }
        }
    }
    private List<String> expand(Set<String> dict, String str) {
        List<String> results = new ArrayList<String>();
        for (int i = 0; i < str.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (str.charAt(i) != ch) {
                    String newStr = str.substring(0, i) + ch + str.substring(i + 1);
                    if (dict.contains(newStr)) {
                        results.add(newStr);
                    }
                }
            }
        }
        return results;
    }
}
// public class Solution {
//     /**
//       * @param start, a string
//       * @param end, a string
//       * @param dict, a set of string
//       * @return an integer
//       */
//     public int ladderLength(String start, String end, Set<String> dict) {
//         // write your code here
//         if (start.equals(end)) {
//             return 1;
//         }
//         if (dict.size() == 0) {
//             return 0;
//         }
//         Map<String, List<String>> neighbors = new HashMap<String, List<String>>();
//         dict.add(start);
//         dict.add(end);
//         buildNeighbor(neighbors, start, dict);
//         Queue<String> queue = new LinkedList<String>();
//         queue.offer(end);
//         Set<String> visit = new HashSet<String>();
//         visit.add(end);
//         int length = 1;
//         while (!queue.isEmpty()) {
//             length++;
//             int size = queue.size();
//             for (int i = 0; i < size; i++) {
//                 String cur = queue.poll();
//                 for (String tmp : neighbors.get(cur)) {
//                     if (visit.contains(tmp)) {
//                         continue;
//                     } else {
//                         if (tmp.equals(start)) {
//                             return length;
//                         } else {
//                             visit.add(tmp);
//                             queue.offer(tmp);
//                         }
//                     }
//                 }
//             }
//         }
//         return 0;
//     }
    
//     public void buildNeighbor(Map<String, List<String>> neighbors, String start, Set<String> dict) {
//         Set<String> visit = new HashSet<String>();
//         for (String str : dict) {
//             neighbors.put(str, new ArrayList<String>());
//         }
//         Queue<String> queue = new LinkedList<String>();
//         queue.offer(start);
//         visit.add(start);
//         while (!queue.isEmpty()) {
//             String tmp = queue.poll();
//             List<String> neighbor = expand(tmp, dict);
//             for (String str : neighbor) {
//                 if (!visit.contains(str)) {
//                     visit.add(str);
//                     queue.offer(str);
//                 }
//                 neighbors.get(tmp).add(str);
//             }
//         }
//         return;
//     }
    
//     public List<String> expand(String tmp, Set<String> dict) {
//         List<String> neighbor = new ArrayList<String>();
//         for (int i = 0; i < tmp.length(); i++) {
//             for (char ch = 'a'; ch <= 'z'; ch++) {
//                 if (ch != tmp.charAt(i)) {
//                     String str = tmp.substring(0, i) + ch + tmp.substring(i + 1);
//                     if (dict.contains(str)) {
//                         neighbor.add(str);
//                     }
//                 }
//             }
//         }
//         return neighbor;
//     }
// }