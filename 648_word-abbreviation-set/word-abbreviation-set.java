/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/word-abbreviation-set
@Language: Java
@Datetime: 17-05-11 10:14
*/

public class ValidWordAbbr {

    private Map<String,Set<String>> d;

    // @param dictionary a list of word
    public ValidWordAbbr(String[] dictionary) {
        // Write your code here
        d = new HashMap<String, Set<String>>();
        for (int i = 0;i < dictionary.length; i++) {
            String w = dictionary[i];
            String abbr = getAbbr(w); 
        
            if (d.containsKey(abbr)) {
                Set<String> s = d.get(abbr);
                if (!s.contains(w)) s.add(w);
            } else {
                Set<String> s = new HashSet<String>();
                s.add(w);
                d.put(abbr,s);
            }
        }
    }

    /**
     * @param word a string
     * @return true if its abbreviation is unique or false
     */
    public boolean isUnique(String word) {
        // Write your code here
        String a = getAbbr(word);
        if (d.containsKey(a)) {
            Set<String> s = d.get(a);
            if (s.size() == 1 && s.contains(word)) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    private String getAbbr(String w){
        int len = w.length() - 2;
        if (len <= 0) {
            return w;
        }
        return "" + w.charAt(0) + len + w.charAt(w.length() - 1);
    }
}
/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param = obj.isUnique(word);
 */