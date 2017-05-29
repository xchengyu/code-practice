/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/inverted-index-map-reduce
@Language: Java
@Datetime: 16-08-01 08:01
*/

/**
 * Definition of OutputCollector:
 * class OutputCollector<K, V> {
 *     public void collect(K key, V value);
 *         // Adds a key/value pair to the output buffer
 * }
 * Definition of Document:
 * class Document {
 *     public int id;
 *     public String content;
 * }
 */
public class InvertedIndex {

    public static class Map {
        public void map(String _, Document value,
                        OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            StringTokenizer st = new StringTokenizer(value.content);
            while (st.hasMoreTokens()) {
                String word = st.nextToken();
                output.collect(word, value.id);
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<Integer> values,
                           OutputCollector<String, List<Integer>> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, List<Integer> value);
            List<Integer> indexes = new ArrayList<Integer>();
            Set<Integer> set = new HashSet<Integer>();
            while (values.hasNext()) {
                set.add(values.next());
            }
            for (Integer id : set) {
                indexes.add(id);
            }
            output.collect(key, indexes);
        }
    }
}
