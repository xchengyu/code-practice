```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/longest-common-prefix
@Language: Markdown
@Datetime: 17-01-27 10:23
```

if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            while (j < strs[i].length() && j < prefix.length() && prefix.charAt(j) == strs[i].charAt(j)) {
                j++;
            }
            if (j == 0) {
                return "";
            }
            prefix = prefix.substring(0, j);
        }
        return prefix;