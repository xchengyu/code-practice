```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/candy
@Language: Markdown
@Datetime: 16-09-02 08:43
```

two rounds. from left to right and then from right to left
【思路】

先从左到右扫描一遍，使得右边比左边得分高的小朋友糖果数比左边多。

再从右到左扫描一遍，使得左边比右边得分高的小朋友糖果数比右边多。
public class Solution {
    /**
     * @param ratings Children's ratings
     * @return the minimum candies you must give
     */
    public int candy(int[] ratings) {
        // Write your code here
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int[] counts = new int[ratings.length];
        Arrays.fill(counts, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                counts[i] = counts[i - 1] + 1;
            }
        }
        int sum = 0;
        for (int i = ratings.length - 1; i >= 1; i--) {
            sum += counts[i];
            if (ratings[i - 1] > ratings[i] && counts[i - 1] <= counts[i]) {
                counts[i - 1] = counts[i] + 1;
            }
        }
        sum += counts[0];
        return sum;
    }
}