```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/anagram-map-reduce
@Language: Markdown
@Datetime: 16-08-22 19:29
```

public class Anagram {

    public static class Map {
        public void map(String key, String value,
                        OutputCollector<String, String> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, String value);
            StringTokenizer st = new StringTokenizer(value);
            while (st.hasMoreTokens()) {
                String origin = st.nextToken();
                char[] character = origin.toCharArray();
                Arrays.sort(character);
                String standard = new String(character);
                output.collect(standard, origin);
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<String> values,
                           OutputCollector<String, List<String>> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, List<String> value);
            List<String> result = new ArrayList<String>();
            while (values.hasNext()) {
                result.add(values.next());
            }
            output.collect(key, result);
        }
    }
}
