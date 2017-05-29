/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/number-of-islands-ii
@Language: Java
@Datetime: 16-07-12 08:18
*/

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
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
     * @param n an integer
     * @param m an integer
     * @param operators an array of point
     * @return an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // Write your code here
        List<Integer> ans = new ArrayList<Integer>();
        if (operators == null || operators.length == 0) {
            return ans;
        }
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int[][] island = new int[n][m];
        UnionFind uf = new UnionFind(n, m);
        int count = 0;
        for (int i = 0; i < operators.length; i++) {
            count++;
            int x = operators[i].x;
            int y = operators[i].y;
            if (island[x][y] != 1) {
                island[x][y] = 1;
                int id = convertToId(x, y, m);
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (0 <= nx && nx < n && 0 <= ny && ny < m && island[nx][ny] == 1) {
                        int nid = convertToId(nx, ny, m);
                        int fa = uf.find(id);
                        int nfa = uf.find(nid);
                        if (fa != nfa) {
                            count--;
                            uf.union(id, nid);
                        }
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }
}