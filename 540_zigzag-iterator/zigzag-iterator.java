/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/zigzag-iterator
@Language: Java
@Datetime: 16-08-10 00:21
*/

public class ZigzagIterator {
    /**
     * @param v1 v2 two 1d vectors
     */
    ListIterator<Integer> iter1;
    ListIterator<Integer> iter2;
    boolean turn;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        // initialize your data structure here.
        this.iter1 = v1.listIterator();
        this.iter2 = v2.listIterator();
        this.turn = false;
    }

    public int next() {
        // Write your code here
        if (!turn) {
            if (iter1.hasNext()) {
                turn = true;
                return iter1.next();
            } else {
                turn = true;
                return iter2.next();
            }
        } else {
            if (iter2.hasNext()) {
                turn = false;
                return iter2.next();
            } else {
                turn = false;
                return iter1.next();
            }
        }
    }

    public boolean hasNext() {
        // Write your code here
        return iter1.hasNext() || iter2.hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator solution = new ZigzagIterator(v1, v2);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */