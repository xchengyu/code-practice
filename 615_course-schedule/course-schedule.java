/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/course-schedule
@Language: Java
@Datetime: 17-05-26 08:44
*/

public class Solution {
    /**
     * @param numCourses a total of n courses
     * @param prerequisites a list of prerequisite pairs
     * @return true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] outAdj = (List<Integer>[])new List[numCourses];
        List<Integer>[] inAdj = (List<Integer>[])new List[numCourses];
        for(int i=0; i<numCourses; i++) {
            outAdj[i] = new ArrayList<Integer>();
            inAdj[i] = new ArrayList<Integer>();
        }
        for(int[] e : prerequisites) {
            outAdj[e[0]].add(e[1]);
            inAdj[e[1]].add(e[0]);
        }
        
        ArrayList<Integer> coursesToFinish = new ArrayList<Integer>();
        for(int i=0; i<numCourses; i++)
            if(inAdj[i].size()==0)
                coursesToFinish.add(i);
        
        while(numCourses > 0) {
            if(coursesToFinish.isEmpty())
                return false;
            numCourses -= coursesToFinish.size();
            ArrayList<Integer> nextCoursesToFinish = new ArrayList<Integer>();
            for(Integer course : coursesToFinish) {
                for(Integer nextCourse : outAdj[course]) {
                    inAdj[nextCourse].remove(course);
                    if (inAdj[nextCourse].size()==0)
                        nextCoursesToFinish.add(nextCourse);
                }
            }
            coursesToFinish = nextCoursesToFinish;
        } 
    
    return true;
}
}