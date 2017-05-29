```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/string-to-integer-ii
@Language: Markdown
@Datetime: 16-12-24 10:57
```

http://blog.sina.com.cn/s/blog_915ffce701011tu1.html
1、如果用“.”作为分隔的话，必须是如下写法：String.split("\\."),这样才能正确的分隔开，不能用String.split(".");
2、如果用“|”作为分隔的话，必须是如下写法：String.split("\\|"),这样才能正确的分隔开，不能用String.split("|");
“.”和“|”都是转义字符，必须得加"\";
3、如果在一个字符串中有多个分隔符，可以用“|”作为连字符，比如：“acount=? and uu =? or n=?”,把三个都分隔出来，可以用String.split("and|or");
使用String.split方法分隔字符串时，分隔符如果用到一些特殊字符，可能会得不到我们预期的结果。
我们看jdk doc中说明  
public String[] split(String regex)
 Splits this string around matches of the given regular expression.
参数regex是一个 regular-expression的匹配模式而不是一个简单的String，他对一些特殊的字符可能会出现你预想不到的结果，比如测试下面的代码：
用竖线 | 分隔字符串，你将得不到预期的结果
    String[] aa = "aaa|bbb|ccc".split("|");
    //String[] aa = "aaa|bbb|ccc".split("\\|"); 这样才能得到正确的结果
    for (int i = 0 ; i <aa.length ; i++ ) {
      System.out.println("--"+aa[i]);
    }
用竖 * 分隔字符串运行将抛出java.util.regex.PatternSyntaxException异常，用加号 + 也是如此。
    String[] aa = "aaa*bbb*ccc".split("*");
    //String[] aa = "aaa|bbb|ccc".split("\\*"); 这样才能得到正确的结果   
    for (int i = 0 ; i <aa.length ; i++ ) {
      System.out.println("--"+aa[i]);
    }
显然，+ * 不是有效的模式匹配规则表达式，用"\\*" "\\+"转义后即可得到正确的结果。
"|" 分隔串时虽然能够执行，但是却不是预期的目的，"\\|"转义后即可得到正确的结果。
还有如果想在串中使用""字符，则也需要转义.首先要表达"aaaa\bbbb"这个串就应该用"aaaa\\bbbb",如果要分隔就应该这样才能得到正确结果：
String[] aa = "aaa\\bbb\\bccc".split("\\\");
public class Solution {
    /**
     * @param str: A string
     * @return An integer
     */
    public int atoi(String str) {
        // write your code here
        if (str == null || str.length() < 1)
		return 0;
        
	    // trim white spaces
	    str = str.trim();
 
	    char flag = '+';
 
	    // check negative or positive
	    int i = 0;
	    if (str.charAt(0) == '-') {
		    flag = '-';
		    i++;
	    } else if (str.charAt(0) == '+') {
		    i++;
	    }
	    // use double to store result
	    double result = 0;
    
	    // calculate value
	    while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
		    result = result * 10 + (str.charAt(i) - '0');
		    i++;
	    }
 
	    if (flag == '-')
		    result = -result;
 
	    // handle max and min
	    if (result > Integer.MAX_VALUE)
		    return Integer.MAX_VALUE;
 
	    if (result < Integer.MIN_VALUE)
		    return Integer.MIN_VALUE;
 
	    return (int) result;
    }
}