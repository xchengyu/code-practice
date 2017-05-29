/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/memcache
@Language: Java
@Datetime: 16-07-24 06:59
*/

public class Memcache {
    class Element {
        public int value;
        public int expire;
        public Element (int value, int expire) {
            this.value = value;
            this.expire = expire;
        }
    }
    public Map<Integer, Element> cache;
    public Memcache() {
        // Initialize your data structure here.
        cache = new HashMap<Integer, Element>();
    }

    public int get(int curtTime, int key) {
        // Write your code here
        if (!cache.containsKey(key)) {
            return Integer.MAX_VALUE;
        }
        Element elem = cache.get(key);
        if (elem.expire >= curtTime || elem.expire == -1) {
            return elem.value;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public void set(int curtTime, int key, int value, int ttl) {
        // Write your code here
        int expire = ttl == 0 ? -1 : curtTime + ttl - 1;
        Element elem = new Element(value, expire);
        cache.put(key, elem);
    }

    public void delete(int curtTime, int key) {
        // Write your code here
        cache.remove(key);
    }
    
    public int incr(int curtTime, int key, int delta) {
        // Write your code here
        if (!cache.containsKey(key)) {
            return Integer.MAX_VALUE;
        }
        cache.get(key).value += delta;
        return get(curtTime, key);
    }

    public int decr(int curtTime, int key, int delta) {
        // Write your code here
        if (!cache.containsKey(key)) {
            return Integer.MAX_VALUE;
        }
        cache.get(key).value -= delta;
        return get(curtTime, key);
    }
}