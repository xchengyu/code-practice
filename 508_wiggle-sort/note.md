```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/wiggle-sort
@Language: Markdown
@Datetime: 16-08-22 21:19
```

    public void wiggleSort(int[] nums) {
        // Write your code here
        if (nums == null || nums.length < 2) {
            return;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if ((i % 2 == 0 && nums[i] > nums[i + 1]) || (i % 2 == 1 && nums[i] < nums[i + 1])) {
                // swap nums[i] and nums[i + 1] will not affect nums[0] ~ nums[i - 1]
                int tmp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = tmp;
            }
        }
        return;
    }