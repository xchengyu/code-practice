/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/url-parser
@Language: Java
@Datetime: 16-08-24 00:24
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HtmlParser {
    /**
     * @param content source code
     * @return a list of links
     */
    private static String url = "\\s*href\\s*=\\s*\"?\'?([^\"\'>\\s]*)";
    public List<String> parseUrls(String content) {
        // Write your code here
        Pattern p = Pattern.compile(url, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(content);
        List<String> links = new ArrayList<String>();
        while (m.find()) {
            String tmp = m.group(1);
            if (tmp.length() == 0 || tmp.startsWith("#")) {
                continue;
            } else {
                links.add(tmp);
            }
        }
        return links;
    }
}
