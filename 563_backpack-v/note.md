```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/backpack-v
@Language: Markdown
@Datetime: 17-01-14 10:18
```

public class Solution {
    /**
     * @param nums an integer array and all positive numbers
     * @param target an integer
     * @return an integer
     */
    public int backPackV(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length == 0 || target == 0) {
            return 0;
        }
        int[] res = new int[target + 1];
        res[0] = 1;
        for (int i = 0; i < nums.length; i++) {//which target can be realized by first i + 1 number
            for (int j = target; j >= nums[i]; j--) {//one item can only be used once
            //for example, target = 4, nums = [2]. If we calculate from nums[i] to target,
            //then res[2] and res[4] can be realized. But if we calculate from target to nums[i],
            //then only res[2] can be realized.
                res[j] += res[j - nums[i]];
            }
        }
        return res[target];
    }
}