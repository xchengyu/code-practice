```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/maximum-subarray-difference
@Language: Markdown
@Datetime: 17-01-10 07:58
```

是subarray不是subsequence
if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] forwardMax = new int[nums.length];
        int[] forwardMin = new int[nums.length];
        int[] backwardMax = new int[nums.length];
        int[] backwardMin = new int[nums.length];
        int[] negativeCopy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            negativeCopy[i] = (-1) * nums[i];
        }
        int sum = 0;
        int minSum = 0;
        int max = Integer.MIN_VALUE;
        // find forward max
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            forwardMax[i] = max;
        }
        // find forward min by finding forward max in negativeCopy array.
        sum = 0;
        minSum = 0;
        max = Integer.MIN_VALUE;
        for (int i = 0; i < negativeCopy.length; i++) {
            sum += negativeCopy[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            forwardMin[i] = (-1) * max;
        }
        // find backward max
        sum = 0;
        minSum = 0;
        max = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            backwardMax[i] = max;
        }
        // find backward min by finding backward max in negativeCopy array.
        sum = 0;
        minSum = 0;
        max = Integer.MIN_VALUE;
        for (int i = negativeCopy.length - 1; i >= 0; i--) {
            sum += negativeCopy[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
            backwardMin[i] = (-1) * max;
        }
        int diff = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            diff = Math.max(diff,Math.abs(forwardMax[i] - backwardMin[i + 1]));
            diff = Math.max(diff,Math.abs(forwardMin[i] - backwardMax[i + 1]));
        }
        return diff;