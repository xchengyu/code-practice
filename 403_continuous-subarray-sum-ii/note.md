```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/continuous-subarray-sum-ii
@Language: Markdown
@Datetime: 17-01-17 08:50
```

先求出原始数组中数的总值sum, 再求出一个不循环时的最大值A，再将原数组中的数取反，再在这个新数组中计算一个不循环时的最大值B，这个最大值就是原数组中不循环时的子数组的最小值，如果 A > sum - (-B)， 则不循环时所求的值为最终的值，否则就是循环时所求的值为最终值，这时候我们只要将B结果返回回来的start坐标-1变成我们要的end，再把B结果返回回来的end坐标+1变成我们要的start，返回即可。
注意 ，如果原始数组中的数全是负数，则上述方法不可行，我们只用返回数组中的最大值坐标即可。
如果原始数组中的数全是非负数，则可以直接返回【0，A.length - 1】.
    public ArrayList<Integer> continuousSubarraySumII(int[] A) {
        // Write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (A == null || A.length < 2) {
            res.add(0);
            res.add(0);
            return res;
        }
        boolean allNegative = true;
        int totalSum = 0;
        int maxNeg = Integer.MIN_VALUE;
        int maxNegIndex = 0;
        int[] reverse = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            totalSum += A[i];
            reverse[i] = - A[i];
            if (A[i] > 0) {
                allNegative = false;
            }
            if (A[i] < 0 && A[i] > maxNeg) {
                maxNeg = A[i];
                maxNegIndex = i;
            }
        }
        if (allNegative) {
            res.add(maxNegIndex);
            res.add(maxNegIndex);
            return res;
        }
        ArrayList<Integer> non_wrapping = continuousSubarraySum(A);
        ArrayList<Integer> wrapping = continuousSubarraySum(reverse);
        int non_wrapping_max = non_wrapping.get(2);
        int wrapping_max = totalSum - (-wrapping.get(2));
        if (non_wrapping_max > wrapping_max) {
            res.add(non_wrapping.get(0));
            res.add(non_wrapping.get(1));
        } else {
            int start = wrapping.get(1) + 1;
            if (start == A.length) {
                start = 0;
            }
            int end = wrapping.get(0) - 1;
            if (end == -1) {
                end = A.length - 1;
            }
            res.add(start);
            res.add(end);
        }
        return res;
    }
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(0);
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
                res.set(2, max);
            }
        }
        return res;
    }