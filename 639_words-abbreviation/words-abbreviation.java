/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/words-abbreviation
@Language: Java
@Datetime: 17-05-08 01:26
*/

public class Solution {
    /**
     * @param dict an array of n distinct non-empty strings
     * @return an array of minimal possible abbreviations for every word
     */
    public String[] wordsAbbreviation(String[] dict) {
        // Write your code here
        if (dict == null || dict.length == 0) {
            return new String[0];
        }
        String[] res = new String[dict.length];
        Map<String, String> map = new HashMap<String, String>();
        Map<String, List<String>> translate = new HashMap<String, List<String>>();
        Queue<String> queue = new LinkedList<String>();
        int len = 1;
        for (String str : dict) {
            queue.offer(str);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                String newStr = generate(str, len);
                if (!translate.containsKey(newStr)) {
                    List<String> list = new ArrayList<String>();
                    list.add(str);
                    translate.put(newStr, list);
                } else {
                    translate.get(newStr).add(str);
                }
            }
            for (Map.Entry<String, List<String>> entry : translate.entrySet()) {
                List<String> list = entry.getValue();
                if (list.size() == 1) {
                    map.put(list.get(0), entry.getKey());
                } else {
                    for (String str : list) {
                        queue.offer(str);
                    }
                }
            }
            translate.clear();
            len++;
        }
        for (int i = 0; i < dict.length; i++) {
            res[i] = map.get(dict[i]);
        }
        return res;
    }
    
    private String generate(String str, int len) {
        if (str.length() <= 2 + len) {
            return str;
        }
        String newStr = str.substring(0, len) + (str.length() - len - 1) + str.substring(str.length() - 1);
        return newStr;
    }
}