```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/create-maximum-number
@Language: Markdown
@Datetime: 16-08-03 09:50
```

此题思路是在第一个数组里面选一个由m个数构成的最大数A，在第二个数组里面选一个由n个数构成的最大数B，m + n == k，求出所有可能的（A， B）组合中能merge出一个最大的数的一个组合，并返回这个最大数。A和B组合的时候用merge sort求出（A，B）组合能组合出的最大数。
getMax()函数有玄机，不能用recursion的方法，亲测会stackoverflow。对于getMax函数中的循环部分：
for (int j = 0; j < nums.length; ++j) {
            while (nums.length - j + i > k && i > 0 && results[i-1] < nums[j]) {
                i--;
			}
            if (i < k) {
                results[i++] = nums[j];
			}
}
nums.length - j 代表数组剩余部分可选的数的个数，i 代表已经选出的个数(注意，i 虽然是index，但在上一轮for循环结束之前 i 已经加过1了，所以这时的 i 代表已经选出的个数 )，i 和 j 在这里都是index。i 是results数组的index，j 是nums数组的index。results数组在循环的时候就像一个栈，稍微改写一下上面的循环：
Stack<Integer> stack = new Stack<Integer>();
        for (int j = 0; j < nums.length; ++j) {
            while (nums.length - j + stack.size() > k && !stack.isEmpty() && stack.peek() < nums[j]) {
                stack.pop();
    		}
            if (stack.size() < k) {
                stack.push(nums[j]);
            }
}