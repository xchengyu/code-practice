/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/sort-integers-map-reduce
@Language: Java
@Datetime: 16-10-20 05:27
*/

/**
 * Definition of OutputCollector:
 * class OutputCollector<K, V> {
 *     public void collect(K key, V value);
 *         // Adds a key/value pair to the output buffer
 * }
 */
public class SortIntegers {

    public static class Map {
        public void map(int _, List<Integer> value,
                        OutputCollector<String, List<Integer>> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, List<Integer> value);
            Collections.sort(value);
            output.collect("_", value);
        }
    }
        
    public static class Reduce {
        public void reduce(String key, List<List<Integer>> values,
                           OutputCollector<String, List<Integer>> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, List<Integer> value);
            List<Integer> result = mergeK(values, 0, values.size() - 1);
            output.collect(key, result);
        }
        
        public List<Integer> mergeK(List<List<Integer>> values, int start, int end) {
            if (start == end) {
                return values.get(start);
            } else if (end - start == 1) {
                return mergeTwo(values.get(start), values.get(end));
            } else {
                int mid = start + (end - start) / 2;
                List<Integer> left = mergeK(values, start, mid);
                List<Integer> right = mergeK(values, mid + 1, end);
                return mergeTwo(left, right);
            }
        }
        public List<Integer> mergeTwo(List<Integer> left, List<Integer> right) {
            List<Integer> result = new ArrayList<Integer>();
            int i = 0;
            int j = 0;
            while (i < left.size() && j < right.size()) {
                if (left.get(i) <= right.get(j)) {
                    result.add(left.get(i));
                    i++;
                } else {
                    result.add(right.get(j));
                    j++;
                }
            }
            while (i < left.size()) {
                result.add(left.get(i));
                i++;
            }
            while (j < right.size()) {
                result.add(right.get(j));
                j++;
            }
            return result;
        }
    }
}