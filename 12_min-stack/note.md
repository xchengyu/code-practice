```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/min-stack
@Language: Markdown
@Datetime: 17-02-01 09:49
```

两个Integer比大小要用equals
// public class MinStack {
//     private Stack<Integer> min;
//     private Stack<Integer> total;
//     public MinStack() {
//         // do initialize if necessary
//         min = new Stack<Integer>();
//         total = new Stack<Integer>();
//     }

//     public void push(int number) {
//         // write your code here
//         if (min.isEmpty() || number <= (int) min.peek()) {
//             min.push(number);
//         }
//         total.push(number);
//         return;
//     }

//     public int pop() {
//         // write your code here
//         if (min.peek().equals(total.peek())) {
//             min.pop();
//         }
//         return total.pop();
//     }

//     public int min() {
//         // write your code here
//         return min.peek();
//     }
// }
public class MinStack {
    public Stack<Integer> total;
    public Stack<Integer> min;
    public MinStack() {
        // do initialize if necessary
        this.total = new Stack<Integer>();
        this.min = new Stack<Integer>();
    }

    public void push(int number) {
        // write your code here
        if (min.isEmpty() || number <= (int) min.peek()) {
            min.push(number);
        }
        total.push(number);
        return;
    }

    public int pop() {
        // write your code here
        if (min.peek().equals(total.peek())) {
            min.pop();
        }
        return total.pop();
    }

    public int min() {
        // write your code here
        return min.peek();
    }
}
