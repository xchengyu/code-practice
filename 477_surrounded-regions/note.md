```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/surrounded-regions
@Language: Markdown
@Datetime: 17-05-26 08:43
```

public class Solution {
    class UnionFind {
        public HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
        public UnionFind(int n, int m) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int id = convertToId(i, j, m);
                    father.put(id, id);
                }
            }
        }
        public int find(int child) {
            int parent = father.get(child);
            while (parent != father.get(parent)) {
                parent = father.get(parent);
            }
            int tmp = -1;
            int fa = father.get(child);
            father.put(child, parent);
            while (fa != father.get(fa)) {
                tmp = father.get(fa);
                father.put(fa, parent);
                fa = tmp;
            }
            return parent;
        }
        public void union(int x, int y) {
            int fx = father.get(x);
            int fy = father.get(y);
            if (fx != fy) {
                father.put(fx, fy);
            }
            return;
        }
    }
    public int convertToId(int x, int y, int m) {
        return m * x + y;
    }
    /**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
    public void surroundedRegions(char[][] board) {
        // Write your code here
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int n = board.length;
        int m = board[0].length;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        HashSet<Integer> hashset = new HashSet<Integer>();
        UnionFind uf = new UnionFind(n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    int id = convertToId(i, j, m);
                    hashset.add(id);
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (0 <= nx && nx < n && 0 <= ny && ny < m && board[nx][ny] == 'O') {
                            int nid = convertToId(nx, ny, m);
                            int fa = uf.find(id);
                            int nfa = uf.find(nid);
                            if (fa != nfa) {
                                uf.union(id, nid);
                            }
                        }
                    }
                }
            }
        }
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (Integer i : hashset) {
            int fa = uf.find(i);
            if (!map.containsKey(fa)) {
                map.put(fa, new ArrayList<Integer>());
            }
            List<Integer> now = map.get(fa);
            now.add(i);
            map.put(fa, now);
        }
        boolean flip = false;
        for (List<Integer> i : map.values()) {
            flip = true;
            for (Integer id : i) {
                if (id / m == 0 || id / m == n -1 || id % m == 0 || id % m == m - 1) {
                    flip = false;
                    break;
                }
            }
            if (flip) {
                for (Integer id : i) {
                    board[id / m][id % m] = 'X';
                }
            }
        }
        return;
    }
}