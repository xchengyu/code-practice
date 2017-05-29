/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/course-schedule-ii
@Language: Java
@Datetime: 17-02-24 03:49
*/

public class Solution {
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Write your code here
        List[] edges = new List[numCourses];
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        int[] order = new int[numCourses];
        int count = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            order[count++] = cur;
            for (int i = 0; i < edges[cur].size(); i++) {
                int next = (int) edges[cur].get(i);
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        if (count == numCourses) {
            return order;
        }
        return new int[0];
    }
}