/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/find-the-missing-number-ii
@Language: Java
@Datetime: 17-01-14 08:26
*/

// public class Solution {
//     /**
//      * @param n an integer
//      * @param str a string with number from 1-n
//      *            in random order and miss one number
//      * @return an integer
//      */
//     public int findMissing2(int n, String str) {
//         // Write your code here
//         if (str == null || str.length() == 0 || str.equals(" ")) {
//             return 1;
//         }
//         if (n <= 9) {
//             int sum = 0;
//             for (int i = 0; i < str.length(); i++) {
//                 sum += (int) str.charAt(i);
//             }
//             return (n + 1) * n / 2 - sum;
//         }
//         Set<String> visited = new HashSet<String>();
//         Set<Integer> list = new HashSet<Integer>();
//         dfs(n, str, visited, new ArrayList<Integer>(), list);
//         int sum = 0;
//         for (Integer num : list) {
//             sum += num;
//         }
//          return (n + 1) * n / 2 - sum;
//     }
    
//     private void dfs(int n, String str, Set<String> visited, List<Integer> path, Set<Integer> list) {
//         if (str.length() == 0) {
//             if (path.size() != n - 1) {
//                 return;
//             } else {
//                 for (Integer num : path) {
//                     list.add(num);
//                 }
//                 return;
//             }
//         }
//         if (str.length() >= 2) {
//             String tmp = str.substring(0, 2);
//             if (isValid(n, tmp, visited)) {
//                 path.add(Integer.parseInt(tmp));
//                 visited.add(tmp);
//                 dfs(n, str.substring(2), visited, path, list);
//                 visited.remove(tmp);
//                 path.remove(path.size() - 1);
//             }
//         }
//         String tmp = str.substring(0, 1);
//         if (isValid(n, tmp, visited)) {
//             path.add(Integer.parseInt(tmp));
//             visited.add(tmp);
//             dfs(n, str.substring(1), visited, path, list);
//             visited.remove(tmp);
//             path.remove(path.size() - 1);
//         }
//         return;
//     }
    
//     private boolean isValid(int n, String tmp, Set<String> visited) {
//         if (tmp.charAt(0) == '0') {
//             return false;
//         }
//         int num = Integer.parseInt(tmp);
//         if (num > n || visited.contains(tmp)) {
//             return false;
//         }
//         return true;
//     }
// }
public class Solution {
    /**
     * @param n an integer
     * @param str a string with number from 1-n
     *            in random order and miss one number
     * @return an integer
     */
    public int findMissing2(int n, String str) {
        // Write your code here
        if (str == null) {
            return 1;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 1;
        }
        if (n <= 9) {
            int sum = 0;
            for (int i = 0; i < str.length(); i++) {
                sum += str.charAt(i) - '0';
            }
            return n * (n + 1) / 2 - sum;
        }
        Set<Integer> visited = new HashSet<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(str, n, visited, new ArrayList<Integer>(), res);
        if (res.size() == 0) {
            return -1;
        }
        return res.get(0).get(n - 1);
    }
    public void dfs(String str, int n, Set<Integer> visited, List<Integer> path, List<List<Integer>> res) {
        if (str.length() == 0) {
            int size = path.size();
            if (size != n - 1) {
                return;
            }
            int sum = 0;
            for (Integer num : path) {
                sum += num;
            }
            int temp = n * (n + 1) / 2 - sum;
            if (temp >= 1 && temp <= n) {
                if (visited.contains(temp)) {
                    return;
                }
                path.add(temp);
                res.add(new ArrayList<Integer>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        if (str.length() >= 2) {
            String cur = str.substring(0, 2);
            if (isValid(cur, n)) {
                int num = Integer.parseInt(cur);
                if (!visited.contains(num)) {
                    visited.add(num);
                    path.add(num);
                    dfs(str.substring(2), n, visited, path, res);
                    path.remove(path.size() - 1);
                    visited.remove(num);
                }
            }
        }
        String cur = str.substring(0, 1);
        if (isValid(cur, n)) {
            int num = Integer.parseInt(cur);
            if (!visited.contains(num)) {
                visited.add(num);
                path.add(num);
                dfs(str.substring(1), n, visited, path, res);
                path.remove(path.size() - 1);
                visited.remove(num);
            }
        }
        return;
    }
    public boolean isValid(String str, int n) {
        if (str.charAt(0) == '0') {
            return false;
        }
        int num = Integer.parseInt(str);
        if (num > n || num < 1) {
            return false;
        }
        return true;
    }
}