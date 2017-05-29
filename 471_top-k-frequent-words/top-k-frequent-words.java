/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/top-k-frequent-words
@Language: Java
@Datetime: 16-07-07 00:14
*/

class Element {
    public String key;
    public int freq;
    public Element(String key, int freq){
        this.key = key;
        this.freq = freq;
    }
}
public class Solution {
    /**
     * @param words an array of string
     * @param k an integer
     * @return an array of string
     */
    public String[] topKFrequentWords(String[] words, int k) {
        // Write your code here
        if (words == null || words.length == 0) {
            return new String[0];
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            } else {
                map.put(words[i], 1);
            }
        }
        Set<String> set = map.keySet();
        ArrayList<Element> list = new ArrayList<Element>();
        for (String i : set) {
            list.add(new Element(i, map.get(i)));
        }
        Collections.sort(list, new Comparator<Element>(){
            public int compare(Element a, Element b) {
                if (a.freq > b.freq) {
                    return -1;
                } else if (a.freq < b.freq) {
                    return 1;
                } else {
                    return a.key.compareTo(b.key);
                }
            }
        });
        String[] res;
        if (k <= list.size()) {
            res = new String[k];
            for (int i = 0; i < k; i++) {
                res[i] = list.get(i).key;
            }
        } else {
            res = new String[list.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = list.get(i).key;
            }
        }
        return res;
    }
}