```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/next-permutation
@Language: Markdown
@Datetime: 16-12-28 09:36
```

从后往前搜索，当遇到nums【i】 < nums【i + 1】时停下，记录此时的index，令index = i，再从后往前搜索，找到第一个比nums【index】大的element nums【j】，交换nums【index】和 nums【j】,这时从index +1 到nums.length-1形成一个递减序列，此时我们将这个序列reverse即可得到所求值。
注意【4，3，2，1】.next = 【1，2，3，4】这种特殊情况。
if (nums == null || nums.length < 2) {
            return nums;
        }
        Stack<Integer> up = new Stack<Integer>();//from bottom to top
        Stack<Integer> down = new Stack<Integer>();//from bottom to top
        up.push(nums[nums.length - 1]);
        int index = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (up.peek() > nums[i]) {
                index = i;
                break;
            } else {
                up.push(nums[i]);
            }
        }
        if (up.size() == nums.length) {
            int start = 0;
            int end = nums.length - 1;
            while (start < end) {
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
                start++;
                end--;
            }
            return nums;
        }
        int target = nums[index];
        while (!up.isEmpty() && up.peek() > target) {
            down.push(up.pop());
        }
        up.push(target);
        nums[index++] = down.pop();
        while (!up.isEmpty()) {
            down.push(up.pop());
        }
        while (!down.isEmpty()) {
            nums[index++] = down.pop();
        }
        return nums;