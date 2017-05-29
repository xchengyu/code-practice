```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/update-bits
@Language: Markdown
@Datetime: 17-01-20 05:44
```

char类型：0=0x00,~0=0xFF
short类型：0=0x0000,~0=0xFFFF
32位int类型：0=0x00000000,~0=0xFFFFFFFF
int max = ~0; /* All 1’s */
        //char类型：0=0x00,~0=0xFF
        //short类型：0=0x0000,~0=0xFFFF
        //32位int类型：0=0x00000000,~0=0xFFFFFFFF
        // 1’s through position j, then 0’s
        if (j == 31)
            j = max;
        else
            j = (1 << (j + 1)) - 1;
        int left = max - j;
        // 1’s after position i
	    int right = ((1 << i) - 1);
	    // 1’s, with 0s between i and j
        int mask = left | right;
        // Clear i through j, then put m in there
        return ((n & mask) | (m << i));