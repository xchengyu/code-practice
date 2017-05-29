```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/previous-permutation
@Language: Markdown
@Datetime: 16-08-16 06:17
```

public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
		// write your code
		if (nums == null || nums.size() < 2) {
		    return nums;
		}
		int big = Integer.MAX_VALUE;
		for (int i = nums.size() - 2; i >= 0; i--) {
		    if (nums.get(i) > nums.get(i + 1)) {
		        big = i;
		        break;
		    }
		}
		if (big == Integer.MAX_VALUE) {
		    reverse(nums, 0, nums.size() - 1);
		    return nums;
		}
		int firstSmall = 0;
		for (int i = nums.size() - 1; i >= big; i--) {
		    if (nums.get(i) < nums.get(big)) {
		        firstSmall = i;
		        break;
		    }
		}
		int tmp = nums.get(big);
		nums.set(big, nums.get(firstSmall));
		nums.set(firstSmall, tmp);
		reverse(nums, big + 1, nums.size() - 1);
		return nums;
    }
    public void reverse(ArrayList<Integer> nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        while (left < right) {
            int tmp = nums.get(left);
            nums.set(left, nums.get(right));
            nums.set(right, tmp);
            left++;
            right--;
        }
        return;
    }