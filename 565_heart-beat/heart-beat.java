/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/heart-beat
@Language: Java
@Datetime: 17-01-14 08:39
*/

public class HeartBeat {
    Map<String, Integer> log;
    int period;
    public HeartBeat() {
        // initialize your data structure here
        log = new HashMap<String, Integer>();
    }

    // @param slaves_ip_list a list of slaves'ip addresses
    // @param k an integer
    // @return void
    public void initialize(List<String> slaves_ip_list, int k) {
        // Write your code here
        this.period = k;
        for (String slave_ip : slaves_ip_list) {
            log.put(slave_ip, 0);
        }
    }

    // @param timestamp current timestamp in seconds
    // @param slave_ip the ip address of the slave server
    // @return nothing
    public void ping(int timestamp, String slave_ip) {
        // Write your code here
        if (log.containsKey(slave_ip)) {
            log.put(slave_ip, timestamp);
        }
    }

    // @param timestamp current timestamp in seconds
    // @return a list of slaves'ip addresses that died
    public List<String> getDiedSlaves(int timestamp) {
        // Write your code here
        List<String> died = new ArrayList<String>();
        for (String slave_ip : log.keySet()) {
            int previous = log.get(slave_ip);
            if (timestamp - previous >= 2 * period) {
                died.add(slave_ip);
            }
        }
        return died;
    }
}