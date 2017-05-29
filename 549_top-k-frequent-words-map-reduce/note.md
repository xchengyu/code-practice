```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/top-k-frequent-words-map-reduce
@Language: Markdown
@Datetime: 16-08-24 04:19
```

class Pair {
    String key;
    int num;
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
        Queue<Pair> queue = null;
        int size;
        private Comparator<Pair> pairComparator = new Comparator<Pair>() {
            public int compare(Pair left, Pair right) {
                if (left.num != right.num) {
                    return left.num - right.num;
                }
                return right.key.compareTo(left.key);
            }
        };
        public void setup(int k) {
            // initialize your data structure here
            this.size = k;
            queue = new PriorityQueue<Pair>(size, pairComparator);
        }   

        public void reduce(String key, Iterator<Integer> values) {
            // Write your code here
            int sum = 0;
            while (values.hasNext()) {
                sum += values.next();
            }
            Pair cur = new Pair(key, sum);
            if (queue.size() < size) {
                queue.offer(cur);
            } else {
                Pair top = queue.peek();
                if (pairComparator.compare(cur, top) > 0) {
                    queue.poll();
                    queue.offer(cur);
                }
            }
        }

        public void cleanup(OutputCollector<String, Integer> output) {
            // Output the top k pairs <word, times> into output buffer.
            // Ps. output.collect(String key, Integer value);
            List<Pair> res = new ArrayList<Pair>();
            while (!queue.isEmpty()) {
                res.add(queue.poll());
            }
            for (int i = res.size() - 1; i >= 0; i--) {
                Pair tmp = res.get(i);
                output.collect(tmp.key, tmp.num);
            }
        }
    }
}