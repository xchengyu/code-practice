/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/top-k-frequent-words-map-reduce
@Language: Java
@Datetime: 16-08-24 04:19
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
class Pair {
    public String key;
    public int num;
    public Pair(String key, int num) {
        this.key = key;
        this.num = num;
    }
}
public class TopKFrequentWords {

    public static class Map {
        public void map(String _, Document value,
                        OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            StringTokenizer st = new StringTokenizer(value.content);
            while (st.hasMoreTokens()) {
                String word = st.nextToken();
                output.collect(word, 1);
            }
        }
    }

    public static class Reduce {
        private Queue<Pair> queue;
        private int size;
        public void setup(int k) {
            // initialize your data structure here
            this.size = k;
            this.queue = new PriorityQueue<Pair>(size, new Comparator<Pair>() {
                 public int compare(Pair a, Pair b) {
                     if (a.num != b.num) {
                         return a.num - b.num;
                     } else {
                         return b.key.compareTo(a.key);
                     }
                 }
                
            });
        }   

        public void reduce(String key, Iterator<Integer> values) {
            // Write your code here
            int sum = 0;
            while (values.hasNext()) {
                sum += values.next();
            }
            Pair tmp = new Pair(key, sum);
            if (queue.size() < size) {
                queue.offer(tmp);
            } else {
                Pair top = queue.peek();
                if (tmp.num > top.num || (tmp.num == top.num && tmp.key.compareTo(top.key) < 0)) {
                    queue.poll();
                    queue.offer(tmp);
                }
            }
        }

        public void cleanup(OutputCollector<String, Integer> output) {
            // Output the top k pairs <word, times> into output buffer.
            // Ps. output.collect(String key, Integer value);
            List<Pair> list = new ArrayList<Pair>();
            while (!queue.isEmpty()) {
                list.add(queue.poll());
            }
            for (int i = list.size() - 1; i >= 0; i--) {
                Pair cur = list.get(i);
                output.collect(cur.key, cur.num);
            }
        }
    }
}