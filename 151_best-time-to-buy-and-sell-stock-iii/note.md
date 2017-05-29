```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock-iii
@Language: Markdown
@Datetime: 17-01-24 06:08
```

if(prices.length == 0) {
            return 0;
        }
        int ans = 0;
        int n = prices.length;
        
        //正向遍历，opt[i]表示 prices[0...i]内做一次交易的最大收益.
        int opt[] = new int[n];
        opt[0] = 0;
        int low = prices[0];
        int curAns = 0;
        for (int i = 1; i<n; i++) {
            low = Math.min(low, prices[i]);
            curAns = Math.max(curAns, prices[i] - low);
            opt[i] = curAns;
        }
        
        //逆向遍历, optReverse[i]表示 prices[i...n-1]内做一次交易的最大收益.
        int optReverse[] = new int[n];
        optReverse[n - 1] = 0;
        curAns = 0;
        int high = prices[n - 1];
        for (int i=n-2; i>=0; i--) {
            high = Math.max(high, prices[i]);
            curAns = Math.max(curAns, high - prices[i]);
            optReverse[i] = curAns;
        }
        
        //再进行划分，分别计算两个部分
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            tmp = opt[i] + optReverse[i];
            ans = Math.max(ans, tmp);
        }
        return ans;