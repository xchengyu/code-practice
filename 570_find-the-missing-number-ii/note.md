```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/find-the-missing-number-ii
@Language: Markdown
@Datetime: 17-01-14 08:26
```

public class Solution {
    /**
     * @param n an integer
     * @param str a string with number from 1-n
     *            in random order and miss one number
     * @return an integer
     */
    public int findMissing2(int n, String str) {
        // Write your code here
        if (str == null || str.length() == 0 || str.equals(" ")) {
            return 1;
        }
        if (n <= 9) {
            int sum = 0;
            for (int i = 0; i < str.length(); i++) {
                sum += (int) str.charAt(i);
            }
            return (n + 1) * n / 2 - sum;
        }
        Set<String> visited = new HashSet<String>();
        Set<Integer> list = new HashSet<Integer>();
        dfs(n, str, visited, new ArrayList<Integer>(), list);
        int sum = 0;
        for (Integer num : list) {
            sum += num;
        }
         return (n + 1) * n / 2 - sum;
    }
    
    private void dfs(int n, String str, Set<String> visited, List<Integer> path, Set<Integer> list) {
        if (str.length() == 0) {
            if (path.size() != n - 1) {
                return;
            } else {
                for (Integer num : path) {
                    list.add(num);
                }
                return;
            }
        }
        if (str.length() >= 2) {
            String tmp = str.substring(0, 2);
            if (isValid(n, tmp, visited)) {
                path.add(Integer.parseInt(tmp));
                visited.add(tmp);
                dfs(n, str.substring(2), visited, path, list);
                visited.remove(tmp);
                path.remove(path.size() - 1);
            }
            tmp = str.substring(0, 1);
            if (isValid(n, tmp, visited)) {
                path.add(Integer.parseInt(tmp));
                visited.add(tmp);
                dfs(n, str.substring(1), visited, path, list);
                visited.remove(tmp);
                path.remove(path.size() - 1);
            }
            return;
        }
        String tmp = str.substring(0, 1);
        if (isValid(n, tmp, visited)) {
            path.add(Integer.parseInt(tmp));
            visited.add(tmp);
            dfs(n, str.substring(1), visited, path, list);
            visited.remove(tmp);
            path.remove(path.size() - 1);
        }
        return;
    }
    
    private boolean isValid(int n, String tmp, Set<String> visited) {
        if (tmp.charAt(0) == '0') {
            return false;
        }
        int num = Integer.parseInt(tmp);
        if (num > n || visited.contains(tmp)) {
            return false;
        }
        return true;
    }
}