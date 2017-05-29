```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/zigzag-iterator-ii
@Language: Markdown
@Datetime: 17-01-14 11:00
```

private List<Iterator<Integer>> iterList;
     private int turn;
    public ZigzagIterator2(ArrayList<ArrayList<Integer>> vecs) {
        // initialize your data structure here.
        this.iterList = new LinkedList<Iterator<Integer>>();
        for (ArrayList<Integer> vec : vecs) {
            if (vec.size() > 0) {
                iterList.add(vec.listIterator());
            }
        }
        turn = 0;
    }

    public int next() {
        // Write your code here
        if (!this.hasNext()) {
            return 0;
        }
        int pos = turn % iterList.size();
        int res = 0;
        if (iterList.get(pos).hasNext()) {
            res = iterList.get(pos).next();
            if (!iterList.get(pos).hasNext()) {
                iterList.remove(pos);
                turn = pos - 1;
            }
        }
        turn++;
        return res;
    }

    public boolean hasNext() {
        // Write your code here
        return iterList.size() != 0;
    }