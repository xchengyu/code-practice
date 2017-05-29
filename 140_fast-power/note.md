```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/fast-power
@Language: Markdown
@Datetime: 17-01-24 09:47
```

public int fastPower(int a, int b, int n) {
        // write your code here
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return b == 1 ? 0 : 1;
        }
        if (n == 1) {
            return a % b;
        }
        long halfRes = fastPower(a, b, n / 2);
        long totalRes = (halfRes * halfRes) % b;
        if (n % 2 == 1) {
            totalRes = (totalRes * a) % b;
        }
        return (int) totalRes;
    }