```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/integer-to-roman
@Language: Markdown
@Datetime: 17-01-17 06:11
```

        if(n <= 0) {
			return "";
		}
	    int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
	    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	    StringBuilder sb = new StringBuilder();
	    int digit = 0;
	    while (n > 0) {
	        int time = n / nums[digit];
	        n -= nums[digit] * time;
	        for (; time > 0; time--) {
	            sb.append(symbols[digit]);
	        }
	        digit++;
	    }
	    return sb.toString();