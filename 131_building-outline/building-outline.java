/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/building-outline
@Language: Java
@Datetime: 16-09-02 01:04
*/

class Edge {
    public int pos;
    public boolean flag;//true means start point, false means end point
    public int height;
    public Edge(int pos, boolean flag, int height) {
        this.pos = pos;
        this.flag = flag;
        this.height = height;
    }
}
class Order implements Comparator<Edge> {
    public int compare(Edge a, Edge b) {
        if (a.pos != b.pos) {
            return a.pos - b.pos;
        }
        if (a.flag && b.flag) {
            return b.height - a.height;
        }
        if (!a.flag && !b.flag) {
            return a.height - b.height;
        }
        return a.flag ? -1 : 1;
    }
}
public class Solution {
    /**
     * @param buildings: A list of lists of integers
     * @return: Find the outline of those buildings
     */
    public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (buildings == null || buildings.length == 0
                            || buildings[0].length == 0) {
            return res;
        }
        ArrayList<Edge> edges = new ArrayList<Edge>();
        for (int i = 0; i < buildings.length; i++) {
            edges.add(new Edge(buildings[i][0], true, buildings[i][2]));
            edges.add(new Edge(buildings[i][1], false, buildings[i][2]));
        }
        Collections.sort(edges, new Order());
        ArrayList<Integer> cur = null;
        Queue<Integer> queue = new PriorityQueue<Integer>(buildings.length, new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                return b - a;
            }
            
        });
        for (Edge edge : edges) {
            if (edge.flag) {
                if (queue.isEmpty() || queue.peek() < edge.height) {
                    cur = new ArrayList<Integer>(Arrays.asList(edge.pos, edge.height));
                    res.add(cur);
                }
                queue.offer(edge.height);
            } else {
                queue.remove(edge.height);
                if (queue.isEmpty()) {
                    cur = new ArrayList<Integer>(Arrays.asList(edge.pos, 0));
                    res.add(cur);
                } else if (queue.peek() < edge.height) {
                    cur = new ArrayList<Integer>(Arrays.asList(edge.pos, queue.peek()));
                    res.add(cur);
                }
            }   
        }
        return output(res);
    }
    
    public ArrayList<ArrayList<Integer>> output(ArrayList<ArrayList<Integer>> res) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = null;
        for (int i = 0; i < res.size() - 1; i++) {
            if (res.get(i).get(1) > 0) {
                tmp = new ArrayList<Integer>(Arrays.asList(res.get(i).get(0), res.get(i + 1).get(0), res.get(i).get(1)));
                ans.add(tmp);
            }
        }
        return ans; 
    }
}