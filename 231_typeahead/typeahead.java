/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/typeahead
@Language: Java
@Datetime: 16-07-24 09:57
*/

public class Typeahead {
    // @param dict A dictionary of words dict
    public Map<String, List<String>> map = new HashMap<String, List<String>>();
    public Typeahead(Set<String> dict) {
        // do initialize if necessary
        for (String word : dict) {
            int len = word.length();
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j <= len; j++) {
                    String tmp = word.substring(i, j);//用户输入的可能不是一个完整的单词，可能只是单词的某一部分
                    if (!map.containsKey(tmp)) {
                        map.put(tmp, new ArrayList<String>());
                        map.get(tmp).add(word);
                    } else {
                        if (!map.get(tmp).contains(word)) {
                            map.get(tmp).add(word);
                        }
                    }
                }
            }
        }
    }

    // @param str: a string
    // @return a list of words
    public List<String> search(String str) {
        // Write your code here
        if (!map.containsKey(str)) {
            return new ArrayList<String>();
        }
        return map.get(str);
    }
}