```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/continuous-subarray-sum
@Language: Markdown
@Datetime: 17-05-26 10:12
```

public ArrayList<Integer> continuousSubarraySum(int[] A) {
        // Write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(0);
        res.add(0);
        int start = 0;
        int end = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (sum < 0) {
                sum = A[i];
                start = end = i;
            } else {
                sum += A[i];
                end = i;
            }
            if (sum > max) {
                max = sum;
                res.set(0, start);
                res.set(1, end);
            }
        }
        return res;
    }