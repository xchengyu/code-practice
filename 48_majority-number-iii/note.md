```
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/majority-number-iii
@Language: Markdown
@Datetime: 16-08-16 05:40
```

和majority number 2一个思路，详细解释看majority number 2 的notice
思路和Majority NumberII 一样，维护k-1个candidate 在map里面，key为数字值，value为出现次数。先找到这k-1个candidate后，扫描所有元素，如果该元素存在在map里面，update map；如果不存在，1： 如果map里面有值为count= 0，那么删除掉这个元素，加入新元素；2：map里面没有0出现，那么就每个元素的count--
剩下的map里面的值都有可能是majority，所以重新扫描数组，记录下每一个元素出现次数，次数最大的就是majority

public int majorityNumber(ArrayList<Integer> nums, int k) {
        // write your code
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (Integer num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
            if (map.size() >= k) {
                removeKey(map);
            }
        }
        if (map.size() == 0) {
            return Integer.MIN_VALUE;//没有majority number
        }
        for (Integer num : map.keySet()) {
            map.put(num, 0);
        }
        for (Integer num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }
        }
        int maxKey = 0;
        int max = Integer.MIN_VALUE;
        for (Integer key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                maxKey = key;
            }
        }
        return maxKey;
    }
    public void removeKey(HashMap<Integer, Integer> map) {
        List<Integer> removeList = new ArrayList<>();
        for (Integer key : map.keySet()) {
            map.put(key, map.get(key) - 1);
            if (map.get(key) == 0) {
                removeList.add(key);//在这种循环中，不能直接删除这个element，否则会造成inconsistency，程序会报错
            }
        }
        for (Integer key : removeList) {
            map.remove(key);
        }
        return;
    }