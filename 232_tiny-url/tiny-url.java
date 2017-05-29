/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/tiny-url
@Language: Java
@Datetime: 16-07-27 08:58
*/

public class TinyUrl {
    private int id = 0;
    private Map<Integer, String> idToLong = new HashMap<Integer, String>();
    private Map<String, Integer> longToId = new HashMap<String, Integer>();
    public int toBase62(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'z') {
            return c - 'a' + 10;
        }
        return c - 'A' + 36;
    }
    /**
     * @param url a long url
     * @return a short url starts with http://tiny.url/
     */
    public String longToShort(String url) {
        if (url == null || url.length() == 0) {
            return "";
        }
        String head = "http://tiny.url/";
        String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (longToId.containsKey(url)) {
            int ID = longToId.get(url);
            if (ID == 0) {
                return head + "000000";
            }
            String shorts = "";
            while (ID > 0) {
                int digit = ID % 62;
                shorts = chars.substring(digit, digit + 1) + shorts;
                ID = ID / 62;
            }
            while (shorts.length() < 6) {
                shorts = "0" + shorts;
            }
            return head + shorts;
        }
        // Write your code here
        
        String shorts = "";
        if (id == 0) {
            idToLong.put(id, url);
            longToId.put(url, id);
            id++;
            return head + "000000";
        }
        int pre = id;
        while (id > 0) {
            int digit = id % 62;
            shorts = chars.substring(digit, digit + 1) + shorts;
            id = id / 62;
        }
        idToLong.put(pre, url);
        longToId.put(url, pre);
        id = pre + 1;
        while (shorts.length() < 6) {
            shorts = "0" + shorts;
        }
        return head + shorts;
    }

    /**
     * @param url a short url starts with http://tiny.url/
     * @return a long url
     */
    public String shortToLong(String url) {
        if (url == null || url.length() < 6) {
            return "";
        }
        String tiny = url.substring(url.length() - 6);
        // Write your code here
        int num = 0;
        for (int i = 0; i < tiny.length(); i++) {
            num = num * 62 + this.toBase62(tiny.charAt(i));
        }
        return idToLong.get(num);
    }
}