```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/flatten-nested-list-iterator
@Language: Markdown
@Datetime: 17-01-14 11:37
```

import java.util.Iterator;

public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> elements;

    public NestedIterator(List<NestedInteger> nestedList) {
        // Initialize your data structure here.
        elements = new Stack<NestedInteger>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
           elements.push(nestedList.get(i));
        }
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        // Write your code here
        NestedInteger tmp = elements.pop();
        return tmp.getInteger();
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        // Write your code here
        while (!elements.isEmpty()) {
            NestedInteger tmp = elements.peek();
            if (tmp.isInteger()) {
                return true;
            }
            elements.pop();
            for (int i = tmp.getList().size() - 1; i >= 0; i--) {
                elements.push(tmp.getList().get(i));
            }
        }
        return false;
    }

    @Override
    public void remove() {}
}