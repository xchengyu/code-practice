```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/zigzag-iterator
@Language: Markdown
@Datetime: 16-08-10 00:21
```

private ListIterator<Integer> iter1;
    private ListIterator<Integer> iter2;
    private int turn;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        // initialize your data structure here.
        this.iter1 = v1.listIterator();
        this.iter2 = v2.listIterator();
        this.turn = 0;
    }

    public int next() {
        // Write your code here
        if (!this.hasNext()) {
            return 0;
        }
        turn++;
        // 如果是第奇数个，且第一个列表也有下一个元素时，返回第一个列表的下一个
        // 如果第二个列表已经没有，返回第一个列表的下一个
        if((turn % 2 == 1 && iter1.hasNext()) || (!iter2.hasNext())){
            return iter1.next();
        // 如果是第偶数个，且第二个列表也有下一个元素时，返回第二个列表的下一个
        // 如果第一个列表已经没有，返回第二个列表的下一个
        } else if((turn % 2 == 0 && iter2.hasNext()) || (!iter1.hasNext())){
            return iter2.next();
        }
        return 0;
    }

    public boolean hasNext() {
        // Write your code here
        return iter1.hasNext() || iter2.hasNext();
    }