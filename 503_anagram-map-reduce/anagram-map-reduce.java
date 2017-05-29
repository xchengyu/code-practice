/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/anagram-map-reduce
@Language: Java
@Datetime: 16-08-22 19:29
*/

/**
 * Definition of OutputCollector:
 * class OutputCollector<K, V> {
 *     public void collect(K key, V value);
 *         // Adds a key/value pair to the output buffer
 * }
 */
public class Anagram {

    public static class Map {
        public void map(String key, String value,
                        OutputCollector<String, String> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, String value);
            StringTokenizer st = new StringTokenizer(value);
            while (st.hasMoreTokens()) {
                String cur = st.nextToken();
                char[] ch = cur.toCharArray();
                Arrays.sort(ch);
                String standard = new String(ch);
                output.collect(standard, cur);
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<String> values,
                           OutputCollector<String, List<String>> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, List<String> value);
            List<String> res = new ArrayList<String>();
            while (values.hasNext()) {
                res.add(values.next());
            }
            output.collect(key, res);
        }
    }
}
