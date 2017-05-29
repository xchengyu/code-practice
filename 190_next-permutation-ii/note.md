```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/next-permutation-ii
@Language: Markdown
@Datetime: 17-01-18 07:59
```

    public void nextPermutation(int[] nums) {
        // write your code here
        if (nums == null || nums.length < 2) {
            return;
        }
        int small = Integer.MIN_VALUE;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {// find the last increase index, the last the reverse pair.
                small = i;
                break;
            }
        }
        if (small == Integer.MIN_VALUE) {// no reverse pair
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int firstLarge = 0;// find the first bigger one
        // example:
        // [2, 4, 3, 1] -> [3, 4, 2, 1] -> [3, 1, 2, 4]
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[small]) {
                firstLarge = i;
                break;
            }
        }
        
        // swap them to make the permutation bigger
        int tmp = nums[firstLarge];
        nums[firstLarge] = nums[small];
        nums[small] = tmp;
        // reverse the last part
        reverse(nums, small + 1, nums.length - 1);
        return;
    }
    public void reverse(int[] num, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
        return;
    }