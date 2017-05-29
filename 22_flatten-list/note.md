```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/flatten-list
@Language: Markdown
@Datetime: 17-05-14 09:59
```

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List&lt;NestedInteger&gt; getList();
 * }
 */
class NestedIterator implements Iterator&lt;Integer&gt; {
        Stack&lt;Iterator&lt;NestedInteger&gt;&gt; stack;
        Iterator&lt;NestedInteger&gt; itr;
        NestedInteger cur;
    
        public NestedIterator(List&lt;NestedInteger&gt; nestedList) {
            stack = new Stack();
            itr = nestedList.iterator();
            cur = null;
        }
    
        @Override
        public Integer next() {
            Integer x = cur.getInteger();
            cur = null;
            return x;
        }
    
        @Override
        public boolean hasNext() {
            if (cur != null) return true;
            while (!stack.isEmpty() || itr.hasNext()) {
                while (itr.hasNext()) {
                    cur = itr.next();
                    if (cur.isInteger()) return true;
                    else {
                        stack.push(itr);
                        itr = cur.getList().iterator();
                    }
                }
                itr = stack.pop();
            }
            return false;
        }
        public void remove() {
            
        }
    }  
public class Solution {

    // @param nestedList a list of NestedInteger
    // @return a list of integer
    public List&lt;Integer&gt; flatten(List&lt;NestedInteger&gt; nestedList) {
        // Write your code here
        List&lt;Integer&gt; res = new ArrayList&lt;Integer&gt;();
        NestedIterator iter = new NestedIterator(nestedList);
        while (iter.hasNext()) {
            res.add(iter.next());
        }
        return res;
    }
}

public class Solution {

    // @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
        List<Integer> result = new ArrayList<Integer>();
        if (nestedList == null || nestedList.size() == 0) {
            return result;
        }
        Stack<NestedInteger> stack = new Stack<NestedInteger>();
        for (NestedInteger element : nestedList) {
            if (element.isInteger()) {
                result.add(element.getInteger());
            } else {
                int index = result.size();
                for (NestedInteger subElement : element.getList()) {
                    stack.push(subElement);
                }
                while (!stack.isEmpty()) {
                    NestedInteger cur = stack.pop();
                    if (cur.isInteger()) {
                        result.add(index, cur.getInteger());
                    } else {
                        for (NestedInteger tmpElement : cur.getList()) {
                            stack.push(tmpElement);
                        }
                    }
                }
            }
        }
        return result;
    }
}