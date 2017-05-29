/*
@Copyright:LintCode
@Author:   vadxin
@Problem:  http://www.lintcode.com/problem/standard-bloom-filter
@Language: Java
@Datetime: 16-08-02 00:24
*/

public class StandardBloomFilter {
    private List<Integer> hashes;
    private int[] bitArr;
    private int size = 65536;//必须设置的非常大来避免collision
    public StandardBloomFilter(int k) {
        // initialize your data structure here
        this.hashes = new ArrayList<Integer>();
        int base = 33;
        for (int i = 0; i < k; i++) {
            hashes.add(base);
            base += 2;
        }
        bitArr = new int[size];
    }

    public void add(String word) {
        // Write your code here
        if (word == null || word.length() == 0) {
            return;
        }
        if (contains(word)) {
            return;
        }
        for (Integer base : hashes) {
            int index = hashcode(word, base, size);
            bitArr[index] = 1;
        }
    }

    public boolean contains(String word) {
        // Write your code here
        if (word == null || word.length() == 0) {
            return false;
        }
        for (Integer base : hashes) {
            int index = hashcode(word, base, size);
            if (bitArr[index] == 0) {
                return false;
            }
        }
        return true;
    }
    public int hashcode(String word, int base, int size) {
        char[] character = word.toCharArray();
        int remainder = 0;
        for (int i = 0; i < character.length; i++) {
            remainder = (remainder * base + ((int) character[i])) % size;
        }
        return remainder % size;
    }
}