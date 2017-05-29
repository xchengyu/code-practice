/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/n-gram-map-reduce
@Language: Java
@Datetime: 16-10-19 08:06
*/

/**
 * Definition of OutputCollector:
 * class OutputCollector<K, V> {
 *     public void collect(K key, V value);
 *         // Adds a key/value pair to the output buffer
 * }
 */
public class NGram {

    public static class Map {
        public void map(String _, int n, String str,
                        OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, Integer value);
            int len = str.length();
            for (int i = 0; i <= len - n; i++) {
                output.collect(str.substring(i, i + n), 1);
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<Integer> values,
                           OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            int sum = 0;
            while (values.hasNext()) {
                sum += values.next();
            }
            output.collect(key, sum);
        }
    }
}