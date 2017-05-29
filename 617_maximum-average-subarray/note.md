```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/maximum-average-subarray
@Language: Markdown
@Datetime: 17-01-13 10:25
```

public class Solution {
    /**
     * @param nums an array with positive and negative numbers
     * @param k an integer
     * @return the maximum average
     */
    public double maxAverage(int[] nums, int k) {
        // Write your code here
        double small = Integer.MAX_VALUE;
        double big = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] < small) {
                small = nums[i];
            }
            if (nums[i] > big) {
                big = nums[i];
            }
        }
        double[] sum = new double[n + 1];
        sum[0] = 0;
        boolean find = false;
        while (big - small >= 1e-6) {
            double mid = (big + small) / 2.0;
            double min_pre = 0;
            find = false;
            for (int i = 1; i <= n; i++) {
                sum[i] = sum[i - 1] + nums[i - 1] - mid;
                if (i >= k && sum[i] - min_pre >= 0) {
                    find = true;
                    break;
                }
                if (i >= k) {
                    min_pre = Math.min(min_pre, sum[i - k + 1]);
                    //min_pre要么是sum[i - k + 1]，要么是前sum[j], j < i - k + 1
					//min_pre是下轮循环的min_pre，所以有可能是sum[i - k + 1]
                }
            }
            if (find) {
                small = mid;
            } else {
                big = mid;
            }
        }
        return small;
    }
}
first we do a binary search on the average and let it be x 
we decrease x from all of the array elements and if there exists a sub array with lengh more than k whose sum is more than zero then we can say that we have such a sub array whose average is more than x other wise we can say that there doesnt exist any such sub array 
how to find out if there is a sub array whose sum is more than zero and its length is more than k? we can say that a sub array [l, r) equals sum[1, r) — sum[1, l) so if we get the partial sums and fix the r of the sub array we just need an l which sum[1, r) >= sum[1, l) and l <= r — k this can be done with partial minimum of the partial sums
这题的思路是：
这个数组中的平均值最大不会超过数组中的最大值，平均值最小不会超过数组中的最小值，利用这个特点我们可以进行binary search，初始预估平均值是数组最大值和最小值的平均值，如果该数组中存在某个subarray的平均值大于等于这个平均值，则我们调高预估平均值，然后再继续在数组中找是否有subarray的平均值大于等于这个预估平均值，如果没有，则调低预估平均值。。。以此类推，直至平均值上下限的差值小于double的最小区分度。