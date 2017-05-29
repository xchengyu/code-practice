/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/flatten-2d-vector
@Language: Java
@Datetime: 17-01-23 01:57
*/

public class Vector2D implements Iterator<Integer> {
    public List<List<Integer>> data;
    public ListIterator<Integer> iter;
    public int index;
    public Vector2D(List<List<Integer>> vec2d) {
        // Initialize your data structure here
        data = new ArrayList<List<Integer>>();
        for (List<Integer> list : vec2d) {
            if (list.size() != 0) {
                data.add(list);
            }
        }
        this.index = 0;
        if (data.size() != 0) {
            iter = data.get(index).listIterator();
        } else {
            iter = null;
        }
    }

    @Override
    public Integer next() {
        // Write your code here
        return iter.next();
    }

    @Override
    public boolean hasNext() {
        // Write your code here
        if (iter == null) {
            return false;
        }
        if (index == data.size()) {
            return false;
        }
        if (iter.hasNext()) {
            return true;
        } else {
            index++;
            if (index == data.size()) {
                return false;
            } else {
                iter = data.get(index).listIterator();
                return true;
            }
        }
    }

    @Override
    public void remove() {}
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */