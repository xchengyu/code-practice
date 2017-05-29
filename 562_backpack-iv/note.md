```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/backpack-iv
@Language: Markdown
@Datetime: 17-01-14 10:16
```

要考虑重复的情况，比如nums =【2，3，6，7】,target = 7正常输出应该是2，如果注释掉的代码计算（我原来的代码）就是4. 比如当 target = 5的时候，我原来把【2，3】和【3，2】当成了不同的组合，计数计了两次
public class Solution {
    /**
     * @param nums an integer array and all positive numbers, no duplicates
     * @param target an integer
     * @return an integer
     */
    public int backPackIV(int[] nums, int target) {
        // Write your code here
        if (nums == null || nums.length == 0 || target == 0) {
            return 0;
        }
/*********************************wrong code*********************************************/
        // int[] f = new int[target + 1];
        // f[0] = 1;
        // for (int i = 1; i <= target; ++i)
        //     for (int  j = 0; j < nums.length; ++j)
        //         if (i >= nums[j])
        //             f[i] += f[i - nums[j]];

        // return f[target];
/*********************************wrong code*********************************************/
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int i = 0; i < nums.length; ++i) {//前i + 1个数能够实现的target，避免了重复
            for (int  j = nums[i]; j <= target; ++j) {
                f[j] += f[j - nums[i]];
            }
        }
        return f[target];
    }
}