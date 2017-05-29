```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/ugly-number-ii
@Language: Markdown
@Datetime: 17-02-01 09:44
```

http://blog.csdn.net/guang09080908/article/details/47780619
这个应该是微软的一道面试题，首先需要明白丑数的概念。1是一个特殊的丑数，其次只含有2,3,5质因数的数被定义为丑数。 
关于解题的思路可以参考： 
http://www.geeksforgeeks.org/ugly-numbers/ 
1到N的丑数为 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … ； 
可以分成如下三组：

(1) 1×2, 2×2, 3×2, 4×2, 5×2, …
(2) 1×3, 2×3, 3×3, 4×3, 5×3, …
(3) 1×5, 2×5, 3×5, 4×5, 5×5, …
1
2
3
1
2
3
只需要保证每次迭代的过程中选取最小的丑数（或者说是质因数），可以理解为后面的数字是前面的数组针对2,3,5的乘积。 
C++可以AC的代码如下：

    //求三个数的最小值
    int min(int a, int b, int c){
        int minNum = a > b ? b : a;
        return minNum > c ? c : minNum;
    }
    //求第N个丑数
    int nthUglyNumber(int n) {
        int *ugly = new int[n];
        memset(ugly, 0, sizeof(int) * n);
        ugly[0] = 1;

        int factor2 = 2, factor3 = 3, factor5 = 5;
        int index2, index3, index5;
        index2 = index3 = index5 = 0;

        for(int i=1; i<n; i++){
            int minNum = min(factor2, factor3, factor5);
            ugly[i] = minNum;

            if(factor2 == minNum)
                 factor2 = 2 * ugly[++index2];
            if(factor3 == minNum)
                 factor3 = 3 * ugly[++index3];
            if(factor5 == minNum)
                 factor5 = 5 * ugly[++index5];
        }

        return ugly[n-1];
    }