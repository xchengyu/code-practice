/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/lfu-cache
@Language: Java
@Datetime: 16-07-07 06:40
*/

class Node {
    public int key;
    public int freq;
    public int value;
    Node prev;
    Node next;
    public Node(int key, int value, int freq) {
        this.key = key;
        this.value = value;
        this.freq = freq;
        prev = next = null;
    }
}
public class LFUCache {
    private int capacity;
    private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    private Node head = new Node(-1, -1, Integer.MAX_VALUE);
    private Node tail = new Node(-1, -1, Integer.MAX_VALUE);
    // @param capacity, an integer
    public LFUCache(int capacity) {
        // Write your code here
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // Write your code here
        if (map.containsKey(key)) {
            Node tmp = map.get(key);
            Node newNode = new Node(key, value, tmp.freq + 1);
            Node obj = tmp.next;
            while (obj.freq <= newNode.freq) {
                obj = obj.next;
            }
            Node pre = obj.prev;
            pre.next = newNode;
            obj.prev = newNode;
            newNode.prev = pre;
            newNode.next = obj;
            tmp.prev.next = tmp.next;
            tmp.next.prev = tmp.prev;
            map.put(key, newNode);
        } else {
            Node newNode = new Node(key, value, 0);
            if (map.size() < capacity) {
                insertNode(newNode);
            } else {
                if (capacity == 0) {
                    return;
                }
                removeFirst();
                insertNode(newNode);
            }
        }
        return;
    }
    private void removeFirst() {
        Node tmp = head.next;
        head.next = tmp.next;
        tmp.next.prev = head;
        map.remove(tmp.key);
        return;
    }
    private void insertNode(Node newNode) {
        Node obj = head.next;
        while (obj.freq <= newNode.freq) {
            obj = obj.next;
        }
        Node pre = obj.prev;
        pre.next = newNode;
        obj.prev = newNode;
        newNode.prev = pre;
        newNode.next = obj;
        map.put(newNode.key, newNode);
        return;
    }

    public int get(int key) {
        // Write your code here
        if (map.containsKey(key)) {
            Node tmp = map.get(key);
            Node newNode = new Node(key, tmp.value, tmp.freq + 1);
            Node obj = tmp.next;
            while (obj.freq <= newNode.freq) {
                obj = obj.next;
            }
            Node pre = obj.prev;
            pre.next = newNode;
            obj.prev = newNode;
            newNode.prev = pre;
            newNode.next = obj;
            tmp.prev.next = tmp.next;
            tmp.next.prev = tmp.prev;
            map.put(key, newNode);
            return map.get(key).value;
        }
        return -1;
    }
}