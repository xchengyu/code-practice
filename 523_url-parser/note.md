```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/url-parser
@Language: Markdown
@Datetime: 16-08-24 00:24
```

test case 太变态，href后面的【^\"\'>\\s】都可以视作正确的url，醉了。
http://www.cnblogs.com/ggjucheng/p/3423731.html
public class HtmlParser {
    private static final String HTML_HREF_TAG_PATTERN = "\\s*href\\s*=\\s*\"?\'?([^\"\'>\\s]*)";
    //(?i)启动不分大小写模式，\是转义字符，需要加一个\，这样编译过后\\s会被编译成\s，即regex里的空格
    /**
     * @param content source code
     * @return a list of links
     */
    public List<String> parseUrls(String content) {
        // Write your code here
        List<String> links = new ArrayList<String>();
        Pattern pattern = Pattern.compile(HTML_HREF_TAG_PATTERN, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);
        String url = null;
        while (matcher.find()) {
            url = matcher.group(1);//要了解捕获组的概念，详情见Notes
            if (url.length() == 0 || url.startsWith("#"))
                continue;
            links.add(url);
        }
        return links;
    }
}
