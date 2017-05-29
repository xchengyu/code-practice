/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/inverted-index
@Language: Java
@Datetime: 16-07-24 08:27
*/

/**
 * Definition of Document:
 * class Document {
 *     public int id;
 *     public String content;
 * }
 */
public class Solution {
    /**
     * @param docs a list of documents
     * @return an inverted index
     */
    public Map<String, List<Integer>> invertedIndex(List<Document> docs) {
        // Write your code here
        Map<String, List<Integer>> res = new HashMap<String, List<Integer>>();
        Map<Integer, Set<String>> total = new HashMap<Integer, Set<String>>();
        Set<String> dict = new HashSet<String>();
        for (Document doc : docs) {
            Set<String> word = new HashSet<String>();
            build(doc.content, word);
            dict.addAll(word);
            total.put(doc.id, word);
        }
        for (String word : dict) {
            for (Map.Entry<Integer, Set<String>> entry : total.entrySet()) {
                int id = entry.getKey();
                if (total.get(id).contains(word)) {
                    if (!res.containsKey(word)) {
                        res.put(word, new ArrayList<Integer>());
                    }
                    res.get(word).add(id);
                }
            }
        }
        for (Map.Entry<String, List<Integer>> entry : res.entrySet()) {
            String word = entry.getKey();
            Collections.sort(res.get(word));
        }
        return res;
    }
    public void build(String content, Set<String> word) {
        if (content == null || content.length() == 0) {
            return;
        }
        String[] res = content.split(" ");
        for (String elem : res) {
            if (elem != null && elem.length() != 0 && !elem.equals(" ")) {
                word.add(elem);
            }
        }
        return;
    }
}