/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/top-k-frequent-words-ii
@Language: Java
@Datetime: 16-10-25 08:48
*/

public class TopK {
    Map<String, Integer> words = null;
    NavigableSet<String> topk = null;
    int k = 0;
    Comparator<String> mycomparator = new Comparator<String>() {
        public int compare(String left, String right) {
            if (left.equals(right)) {
                return 0;
            }
            int left_count = words.get(left);
            int right_count = words.get(right);
            if (left_count != right_count) {
                return right_count - left_count;
            }
            return left.compareTo(right);
        }
    };
    public TopK(int k) {
        // initialize your data structure here
        this.k = k;
        this.words = new HashMap<String, Integer>();
        this.topk = new TreeSet<String>(mycomparator);
    }

    public void add(String word) {
        // Write your code here
        if (words.containsKey(word)) {
            if (topk.contains(word)) {
                topk.remove(word);
            }
            words.put(word, words.get(word) + 1);
        } else {
            words.put(word, 1);
        }
        topk.add(word);
        if (topk.size() > k) {
            topk.pollLast();
        }
    }

    public List<String> topk() {
        // Write your code here
        List<String> result = new ArrayList<String>();
        Iterator iter = topk.iterator();
        while (iter.hasNext()) {
            String str = (String)iter.next();
            result.add(str);
        }
        Collections.sort(result, mycomparator);
        return result;
    }
}