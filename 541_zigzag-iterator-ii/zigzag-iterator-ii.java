/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/zigzag-iterator-ii
@Language: Java
@Datetime: 17-01-14 11:00
*/

public class ZigzagIterator2 {
    private ArrayList<Iterator<Integer>> iters;
    private int pointer;
    /**
     * @param vecs a list of 1d vectors
     */
    public ZigzagIterator2(ArrayList<ArrayList<Integer>> vecs) {
        // initialize your data structure here.
        this.iters = new ArrayList<Iterator<Integer>>();
        for (ArrayList<Integer> vec : vecs) {
            if (vec.size() > 0) {
                iters.add(vec.listIterator());
            }
        }
        this.pointer = 0;
    }

    public int next() {
        // Write your code here
        if (!this.hasNext()) {
            return 0;
        }
        int pos = pointer % iters.size();
        int res = 0;
        if (iters.get(pos).hasNext()) {
            res = iters.get(pos).next();
            if (!iters.get(pos).hasNext()) {
                iters.remove(pos);
                pointer = pos - 1;
            }
        }
        pointer++;
        return res;
    }

    public boolean hasNext() {
        // Write your code here
        return iters.size() > 0;
    }
}

/**
 * Your ZigzagIterator2 object will be instantiated and called as such:
 * ZigzagIterator2 solution = new ZigzagIterator2(vecs);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */