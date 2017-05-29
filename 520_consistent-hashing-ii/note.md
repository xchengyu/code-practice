```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/consistent-hashing-ii
@Language: Markdown
@Datetime: 17-01-15 09:31
```

public class Solution {
    public int n;
    public int k;
    public HashSet<Integer> ids;
    public HashMap<Integer, List<Integer>> machines;
    // @param n a positive integer
    // @param k a positive integer
    // @return a Solution object
    public static Solution create(int n, int k) {
        // Write your code here
        Solution solution = new Solution();
        solution.n = n;
        solution.k = k;
        solution.ids = new HashSet<Integer>();
        solution.machines = new HashMap<Integer, List<Integer>>();
        return solution;
    }

    // @param machine_id an integer
    // @return a list of shard ids
    public List<Integer> addMachine(int machine_id) {
        // Write your code here
        Random rd = new Random();
        List<Integer> randomNum = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            int tmp = rd.nextInt(n);
            while (ids.contains(tmp)) {
                tmp = rd.nextInt(n);
            }
            ids.add(tmp);
            randomNum.add(tmp);
        }
        Collections.sort(randomNum);
        machines.put(machine_id, randomNum);
        return randomNum;
    }

    // @param hashcode an integer
    // @return a machine id
    public int getMachineIdByHashCode(int hashcode) {
        // Write your code here
        hashcode = hashcode % n;
        int min = n + 1;
        int id = 0;
        for (Map.Entry<Integer, List<Integer>> entry : machines.entrySet()) {
            int key = entry.getKey();
            List<Integer> random_nums = entry.getValue();
            for (Integer num : random_nums) {
                int d = num - hashcode;
                if (d < 0) {//两种可能，(hashcode， num) = (91， 1) or (3， 6);顺时针，是否跨越0点
                    d += n;
                }
                if (d >= 0 && d < min) {
                    min = d;
                    id = key;
                }
            }
        }
        return id;
    }
}