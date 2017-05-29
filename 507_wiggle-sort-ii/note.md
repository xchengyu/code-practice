```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/wiggle-sort-ii
@Language: Markdown
@Datetime: 17-01-15 10:30
```

public void wiggleSort(int[] nums) {
        // Write your code here
        if (nums == null || nums.length < 2) {
            return;
        }
        int mid = partition(nums, 0, nums.length - 1, nums.length / 2);
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = mid;
        }
        int l, r;
        if (nums.length % 2 == 0) {
            l = nums.length - 2;
            r = 1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < mid) {
                    ans[l] = nums[i];
                    l -= 2;
                } else if (nums[i] > mid) {
                    ans[r] = nums[i];
                    r += 2;
                }
            }
        } else {
            l = 0;
            r = nums.length - 2;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < mid) {
                    ans[l] = nums[i];
                    l += 2;
                } else if (nums[i] > mid) {
                    ans[r] = nums[i];
                    r -= 2;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ans[i];
        }
        return;
    }
    public int partition(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        int pivot = nums[start + (end - start) / 2];
        int left = start;
        int right = end;
        int index = start;
        while (index <= right) {
            if (nums[index] < pivot) {
                swap(nums, index, left);
                left++;
                index++;
            } else if (nums[index] == pivot) {
                index++;
            } else {
                swap(nums, index, right);
                right--;
            }
        }
        if (left - start + 1 == k) {
            return nums[left];
        }
        if (left - start + 1 < k) {
            return partition(nums, left + 1, end, k - (left - start + 1));
        }
        return partition(nums, start, left, k);
    }
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        return;
    }