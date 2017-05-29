```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/sort-colors
@Language: Markdown
@Datetime: 17-05-17 09:15
```

class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if (nums == null || nums.length < 2) {
            return;
        }
        int front = 0;
        int last = nums.length - 1;
        int i = 0;
        while (i <= last) {
            if (nums[i] < 1) {
                int tmp = nums[i];
                nums[i] = nums[front];
                nums[front] = tmp;
                i++;
                front++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                int tmp = nums[i];
                nums[i] = nums[last];
                nums[last] = tmp;
                last--;
            }
        }
        return;
    }
}