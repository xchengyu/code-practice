/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/rate-limiter
@Language: Java
@Datetime: 16-07-27 09:57
*/

public class RateLimiter {
    /**
     * @param timestamp the current timestamp
     * @param event the string to distinct different event
     * @param rate the format is [integer]/[s/m/h/d]
     * @param increment whether we should increase the counter
     * @return true or false to indicate the event is limited or not
     */
    private Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    public boolean isRatelimited(int timestamp, String event, String rate, boolean increment) {
        // Write your code here
        int start = rate.indexOf("/");
        int total_time = Integer.parseInt(rate.substring(0, start));
        String type = rate.substring(start + 1, rate.length());
        int time = 1;
        if (type.equals("m")) {
            time = time * 60;
        } else if (type.equals("h")) {
            time = time * 60 * 60;
        } else if (type.equals("d")) {
            time = time * 60 * 60 * 24;
        }
        int last_time = timestamp - time + 1;
        if (!map.containsKey(event)) {
            map.put(event, new ArrayList<Integer>());
        }
        boolean rt = find_event(map.get(event), last_time) >= total_time;
        if (increment && !rt) {
            map.get(event).add(timestamp);
        }
        return rt;
    }
    private int find_event(List<Integer> list, int last_time) {
        int l = 0;
        int r = list.size() - 1;
        if (r == -1) {
            return 0;
        }
        if (list.get(r) < last_time) {
            return 0;
        }
        int ans = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) >= last_time) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return list.size() - 1 - ans + 1;
    }
}