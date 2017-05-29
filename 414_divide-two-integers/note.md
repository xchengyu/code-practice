```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/divide-two-integers
@Language: Markdown
@Datetime: 17-01-18 08:54
```

二分思想，位运算（stackoverflow），负数two's complement represent
1. 基本思想是不断地减掉除数，直到为0为止。但是这样会太慢。

2. 我们可以使用2分法来加速这个过程。不断对除数*2，直到它比被除数还大为止。加倍的同时，也记录下cnt，将被除数减掉加倍后的值，并且结果+cnt。

因为是2倍地加大，所以速度会很快，指数级的速度。

3. 另外要注意的是：最小值的越界问题。对最小的正数取abs，得到的还是它。。。 因为最小的正数的绝对值大于最大的正数（INT）

所以，我们使用Long来接住这个集合就可以了。
1. 返回值的时候，判断是不是越界，越界返回最大值。

例子：

Input: -2147483648, -1
Expected:	2147483647
》》是带符号右移 (-1 ^ 1) >> 31 = -1;
》》》是不带符号右移，(-1 ^ 1) >>>31 = 1; 
http://stackoverflow.com/questions/141525/what-are-bitwise-shift-bit-shift-operators-and-how-do-they-work
long a = Math.abs(Long.valueOf(dividend));
        long b = Math.abs(Long.valueOf(divisor));
        long res = 0;
        while (a >= b) {// 这里必须是 = 因为相等时也可以减
            for (long tmp = b, count = 1; a >= tmp; tmp <<= 1, count <<= 1) {//只要a >= tmp，则count至少为1
                res += count;
                a -= tmp;
            }
        }
        res = (((dividend ^ divisor) >> 31) & 1) == 1 ? -res : res;//(Integer.MIN_VALUE / -1)
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) res;