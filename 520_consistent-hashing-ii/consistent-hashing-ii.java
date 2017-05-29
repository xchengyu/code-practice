/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/consistent-hashing-ii
@Language: Java
@Datetime: 17-01-15 09:31
*/

public class Solution {
    Map<Integer, List<Integer>> machines;
    Set<Integer> used;
    int k;
    int n;
    // @param n a positive integer
    // @param k a positive integer
    // @return a Solution object
    public static Solution create(int n, int k) {
        // Write your code here
        Solution solution = new Solution();
        solution.machines = new HashMap<Integer, List<Integer>>();
        solution.used = new HashSet<Integer>();
        solution.k = k;
        solution.n = n;
        return solution;
    }

    // @param machine_id an integer
    // @return a list of shard ids
    public List<Integer> addMachine(int machine_id) {
        // Write your code here
        if (!machines.containsKey(machine_id)) {
            Random rd = new Random();
            machines.put(machine_id, new ArrayList<Integer>());
            for (int i = 0; i < k; i++) {
                int point = rd.nextInt(n);
                while (used.contains(point)) {
                    point = rd.nextInt(n);
                }
                used.add(point);
                machines.get(machine_id).add(point);
            }
        }
        Collections.sort(machines.get(machine_id));
        return machines.get(machine_id);
    }

    // @param hashcode an integer
    // @return a machine id
    public int getMachineIdByHashCode(int hashcode) {
        // Write your code here
        int distance = 0;
        int min = n + 1;
        int id = 0;
        hashcode = hashcode % n;
        for (Map.Entry<Integer, List<Integer>> entry : machines.entrySet()) {
            int key = entry.getKey();
            List<Integer> points = entry.getValue();
            for (Integer point : points) {
                distance = point - hashcode;
                if (distance < 0) {
                    distance += n;
                }
                if (distance >= 0 && distance < min) {
                    min = distance; 
                    id = key;
                }
            }
        }
        return id;
    }
}